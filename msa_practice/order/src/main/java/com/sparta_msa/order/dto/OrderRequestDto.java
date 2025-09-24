package com.sparta_msa.order.dto;

import lombok.Builder;

@Builder
public record OrderRequestDto(Long userId,
                              String memo,
                              Integer quantity) { }
