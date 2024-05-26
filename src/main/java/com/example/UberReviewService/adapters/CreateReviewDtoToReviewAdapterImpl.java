package com.example.UberReviewService.adapters;

import com.example.UberReviewService.dtos.CreateReviewDto;
import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Review;
import com.example.UberReviewService.repositories.BookingRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CreateReviewDtoToReviewAdapterImpl implements CreateReviewDtoToReviewAdapter {
    private BookingRepository bookingRepository;
    public CreateReviewDtoToReviewAdapterImpl(BookingRepository BookingRepository) {
        this.bookingRepository = BookingRepository;
    }

    @Override
    public Review convertDto(CreateReviewDto createReviewDto) {
        Optional<Booking> booking1=bookingRepository.findById(createReviewDto.getBookingId());
        Review review= Review.builder()
                .content(createReviewDto.getContent())
                .rating(createReviewDto.getRating())
                .booking(booking1.get())
                .build();
        return review;
    }
}
