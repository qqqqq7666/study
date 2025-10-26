package com.example.redis.service;

import com.example.redis.dto.ItemDto;
import com.example.redis.entity.Item;
import com.example.redis.entity.ItemOrder;
import com.example.redis.repository.ItemOrderRepository;
import com.example.redis.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ItemService {
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
}
