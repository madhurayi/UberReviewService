package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.BookingRepository;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReviewService implements CommandLineRunner {

    private final ReviewRepository reviewRepository;

    private final BookingRepository bookingRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository){
        this.reviewRepository=reviewRepository;
        this.bookingRepository = bookingRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("--------------");
        Review r= Review.builder()
                .content("Amazing ride quality")
                .rating(4)
                .build();
        Booking b= Booking
                .builder()
                .review(r)
                .endTime(new Date())
                .build();

        bookingRepository.save(b);
        reviewRepository.save(r);

        System.out.println(r.getId());
        List<Review> reviews= reviewRepository.findAll();
        for(Review review: reviews){
            System.out.println(r.getContent());
        }
        //reviewRepository.deleteById(2L);

    }
}
