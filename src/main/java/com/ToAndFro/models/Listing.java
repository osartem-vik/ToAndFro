package com.ToAndFro.models;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
