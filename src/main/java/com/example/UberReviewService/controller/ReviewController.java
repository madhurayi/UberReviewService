package com.example.UberReviewService.controller;

import com.example.UberReviewService.adapters.CreateReviewDtoToReviewAdapter;
import com.example.UberReviewService.dtos.CreateReviewDto;
import com.example.UberReviewService.dtos.ReviewDto;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.services.ReviewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    private ReviewService reviewService;
    private CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;

    public ReviewController(ReviewService reviewService, CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter) {
        this.reviewService = reviewService;
        this.createReviewDtoToReviewAdapter = createReviewDtoToReviewAdapter;
    }

    @PostMapping
    public ResponseEntity<?> createReview(@RequestBody CreateReviewDto request) {
            Review incomingReview=createReviewDtoToReviewAdapter.convertDto(request);
            if(incomingReview == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Arguments");
            }
            return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.saveReview(incomingReview));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getReviewById(@PathVariable long id) {
        // The below code is to return the custom response usong dto
        Optional<Review> review=reviewService.findReviewById(id);
        ReviewDto response= ReviewDto.builder()
                .booking(review.get().getBooking().getId())
                .content(review.get().getContent())
                .createdAt(review.get().getCreatedAt())
                .updatedAt(review.get().getUpdatedAt())
                .rating(review.get().getRating())
                .id(review.get().getId())
                .build();
//        return ResponseEntity.status(HttpStatus.OK).body(response);
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.findReviewById(id));
    }

    @GetMapping
    public ResponseEntity<?> getAllReviews() {
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.findAllReviews());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReviewById(@PathVariable long id) {
        Optional<Review> review=reviewService.findReviewById(id);
        if(!review.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Review not found");
        }
        reviewService.deleteReviewById(id);
        return ResponseEntity.status(HttpStatus.OK).body(review.get()+"\n"+"Review deleted");
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<?> getAllReviewsRatingGreaterThan(@RequestParam int rating) {

        return ResponseEntity.status(HttpStatus.OK).body(reviewService.findAllReviewsRatingGreaterThan(rating));
    }

    @GetMapping("/{booking_id}/review")
    public ResponseEntity<?> getAllReviewsBookingId(@PathVariable long booking_id) {
        return ResponseEntity.status(HttpStatus.OK).body(reviewService.getReviewByBookingId(booking_id));
    }
}
