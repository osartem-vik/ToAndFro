package com.ToAndFro.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "listing")
public class Listing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(columnDefinition = "enum('TRANSPORT', 'IMMOBILITY', 'ELECTRONICS', 'HOME', 'WORK', 'SERVICES', 'FASHION', 'ANIMALS')")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    private String title;

    @Column(columnDefinition = "text")
    private String description;

    private BigDecimal price;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(columnDefinition = "enum('ACTIVE', 'PENDING', 'SOLD', 'ARCHIVED')")
    private Status status;
}
