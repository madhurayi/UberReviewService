package com.example.UberReviewService.repositories;

import com.example.UberReviewService.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface  ReviewRepository extends JpaRepository<Review, Long> {
    Optional<Review> findReviewById(Long id);

    Integer countAllByRatingLessThanEqual(float rating);

    List<Review> findAllByRatingGreaterThanEqual(float rating);

    List<Review> findAllByCreatedAtBefore(Date date);

    @Query("select r from Booking b inner join Review r on b.id = r.booking.id where b.id = :bookingId")
    Optional<Review> findReviewByBookingId(Long bookingId);
}
