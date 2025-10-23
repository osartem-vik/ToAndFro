package com.ToAndFro.models;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class City {
    private Long id;
    private String name;
    private Long regionId;
}
