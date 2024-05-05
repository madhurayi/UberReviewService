package com.example.UberReviewService.services;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Driver;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.BookingRepository;
import com.example.UberReviewService.repositories.DriverRepository;
import com.example.UberReviewService.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements CommandLineRunner {

    private final ReviewRepository reviewRepository;

    private final BookingRepository bookingRepository;

    private final DriverRepository driverRepository;

    public ReviewService(ReviewRepository reviewRepository, BookingRepository bookingRepository, DriverRepository driverRepository){
        this.reviewRepository=reviewRepository;
        this.bookingRepository = bookingRepository;
        this.driverRepository = driverRepository;
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
        //List<Driver> drivers= driverRepository.findAll();
        Optional<Driver> drivers= driverRepository.findById(3L);
        System.out.println(drivers.get().getName());
        //reviewRepository.deleteById(2L);

        Optional<Driver> d= driverRepository.hqlFindByIdAndLisence(4L,"AP12x46");
        System.out.println(d.get().getName());
    }
}
