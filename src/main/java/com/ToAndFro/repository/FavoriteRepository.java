package com.ToAndFro.repository;

import com.ToAndFro.models.Favorite;
import com.ToAndFro.models.FavoriteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, FavoriteId> {
    boolean existsByUserIdAndListingId(Long userId, Long listingId);

    void deleteByUserIdAndListingId(Long userId, Long listingId);

    List<Favorite> findByUserId(Long userId);

    List<Favorite> findByListingId(Long listingId);
}