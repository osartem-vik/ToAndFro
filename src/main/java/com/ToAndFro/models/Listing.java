package com.ToAndFro.models;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Listing {
    private Long id;
    private Long userId;
    private Long categoryId;
    private Long cityId;
    private String title;
    private String description;
    private BigDecimal price;
    private List<Long> imageIds;
    private LocalDateTime createdAt;
    private String status;
}
