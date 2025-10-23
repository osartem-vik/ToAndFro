package com.ToAndFro.models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Listing {
    private Long id;
    private Long userId;
    private Category category;
    private Long cityId;
    private String title;
    private String description;
    private BigDecimal price;
    private LocalDateTime createdAt;
    private Status status;
}
