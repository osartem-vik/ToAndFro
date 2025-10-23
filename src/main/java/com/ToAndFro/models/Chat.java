package com.ToAndFro.models;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Chat {
    private Long id;
    private Long listingId;
    private Long buyerId;
}
