package com.ToAndFro.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum Category {
    ELECTRONICS(1, null, "electronics"),
    CLOTHING(2, null, "clothing"),
    BOOKS(3, null, "books"),

    SMARTPHONES(5, 1, "smartphones"),
    LAPTOPS(6, 1, "laptops"),
    TV(7, 1, "tv"),
    AUDIO(8, 1, "audio"),

    MEN_CLOTHING(9, 2, "men-clothing"),
    WOMEN_CLOTHING(10, 2, "women-clothing"),
    SHOES(11, 2, "shoes"),
    ACCESSORIES(12, 2, "accessories"),

    FICTION(13, 3, "fiction"),
    SCIENCE_BOOKS(14, 3, "science"),
    CHILDREN_BOOKS(15, 3, "children-books"),
    EDUCATIONAL(16, 3, "educational");

    private final int id;
    private final Integer parentId;
    private final String name;


    public static Optional<Category> findById(int id) {
        return Arrays.stream(values())
                .filter(category -> category.id == id)
                .findFirst();
    }

}
