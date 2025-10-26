package com.example.redis.controller;

import com.example.redis.dto.ItemDto;
import com.example.redis.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}

