package com.ToAndFro.models;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Favorite {
    private Long userId;
    private Long listingId;
}
