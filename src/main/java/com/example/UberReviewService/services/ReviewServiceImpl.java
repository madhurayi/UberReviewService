package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    ReviewRepository reviewRepository;
    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }
    @Override
    public Optional<Review> findReviewById(long id) {
        return reviewRepository.findReviewById(id);
    }

    @Override
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public boolean deleteReviewById(long id) {
        if(reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }
    public List<Review> findAllReviewsRatingGreaterThan(int rating) {
        return reviewRepository.findAllByRatingGreaterThanEqual(rating);
    }

    public Optional<Review> getReviewByBookingId(long id) {
        return reviewRepository.findReviewByBookingId(id);
    }
}
