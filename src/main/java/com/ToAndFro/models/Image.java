package com.ToAndFro.models;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Image {
    private Long id;
    private String path;
    private Long listingId;
}
