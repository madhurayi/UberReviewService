package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    public Optional<Review> findReviewById(long id);
    public List<Review> findAllReviews();
    public boolean deleteReviewById(long id);
    public Review saveReview(Review review);

    List<Review> findAllReviewsRatingGreaterThan(int rating);


    Optional<Review> getReviewByBookingId(long bookingId);
}
