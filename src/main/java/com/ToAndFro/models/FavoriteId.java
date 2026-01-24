package com.ToAndFro.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class FavoriteId implements Serializable {
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "listing_id")
    private Long listingId;
}