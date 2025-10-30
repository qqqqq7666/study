package com.example.redis.service;

import com.example.redis.dto.ItemDto;
import com.example.redis.entity.Item;
import com.example.redis.entity.ItemJpaEntity;
import com.example.redis.entity.ItemOrder;
import com.example.redis.repository.ItemJpaRepository;
import com.example.redis.repository.ItemOrderRepository;
import com.example.redis.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemJpaRepository itemJpaRepository;
    private final ItemRepository itemRepository;
    private final ItemOrderRepository itemOrderRepository;
    @Qualifier("rankTemplate")
    private final ZSetOperations<String, ItemDto> ranksOps;

    public void purchase(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found")
        );

        itemOrderRepository.save(ItemOrder.builder()
                .item(item)
                .count(1)
                .build());

        ranksOps.incrementScore(
                "soldRanks",
                ItemDto.fromEntity(item),
                1
        );
    }

    public List<ItemDto> getMostSold() {
        Set<ItemDto> ranks = ranksOps.reverseRange("soldRanks", 0, 9);
        assert ranks != null;
        if (ranks.isEmpty())
            return Collections.emptyList();

        return ranks.stream().toList();
    }

    @CachePut(cacheNames = "itemCache", key = "#result.id")
    public ItemDto create(ItemDto dto) {
        return ItemDto.fromEntity(itemRepository.save(Item.builder()
                .name(dto.name())
                .description(dto.description())
                .price(dto.price())
                .build()
        ));
    }

    @CachePut(cacheNames = "itemCache", key = "args[0]")
    @CacheEvict(cacheNames = "itemAllCache", allEntries = true)
    @Transactional
    public ItemDto update(Long id, ItemDto dto) {
        ItemJpaEntity item = itemJpaRepository.findById(id)
                .orElseThrow();

        item.update(dto);
        return ItemDto.fromEntity(item);
    }

    // cacheNames: 메서드로 인해서 만들어질 캐시를 지칭하는 이름
    // key: 캐시에서 데이터를 구분하기 위해 활용할 값
    @Cacheable(cacheNames = "itemCache", key = "args[0]")
    public ItemDto readOne(Long id) {
        log.info("#### Read One: {}", id);
        return itemJpaRepository.findById(id)
                .map(ItemDto::fromEntity)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found"));
    }

    // Spel의 일종
    @Cacheable(cacheNames = "itemAllCache", key = "methodName")
    public List<ItemDto> readAll() {
        log.info("#### Read All");
        return itemJpaRepository.findAll()
                .stream()
                .map(ItemDto::fromEntity)
                .toList();
    }

    @CacheEvict(cacheNames = {"itemAllCache", "itemCache"}, key = "args[0]")
    public void delete(Long id) {
        itemJpaRepository.deleteById(id);
    }

    @Cacheable(cacheNames = "itemSearchCache", key = "{args[0], args[1].pageNumber, args[1].pageSize}")
    public Page<ItemDto> searchByName(String query, Pageable pageable) {
        return itemJpaRepository.findAllByNameContains(query, pageable)
                .map(ItemDto::fromEntity);
    }
}
