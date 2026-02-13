package com.ToAndFro.models.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CityResponseDto {
    private Long id;
    private String name;
    private RegionResponseDto region;
}
