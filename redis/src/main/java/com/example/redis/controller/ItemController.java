package com.example.redis.controller;

import com.example.redis.dto.ItemDto;
import com.example.redis.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("items")
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping("{id}/purchase")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void purchase(
            @PathVariable("id")
            Long id
    ) {
        itemService.purchase(id);
    }

    @GetMapping("/most-sold")
    public ResponseEntity<List<ItemDto>> getMostSold() {
        return ResponseEntity.ok(itemService.getMostSold());
    }

    @PostMapping
    public ResponseEntity<ItemDto> create(@RequestBody ItemDto itemDto) {
        return ResponseEntity.created(URI.create("temp"))
                .body(itemService.create(itemDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemDto> update(@PathVariable Long id, @RequestBody ItemDto itemDto) {
        return ResponseEntity.ok(itemService.update(id, itemDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> readOne(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.readOne(id));
    }

    @GetMapping
    public ResponseEntity<List<ItemDto>> readAll() {
        return ResponseEntity.ok(itemService.readAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        itemService.delete(id);
        return ResponseEntity.noContent()
                .build();
    }

    @GetMapping("/search")
    public ResponseEntity<Page<ItemDto>> search(@RequestParam String query, Pageable pageable) {
        return ResponseEntity.ok(itemService.searchByName(query, pageable));
    }
}