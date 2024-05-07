package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity //Entity annotation defines that a class can be mapped to a table
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Booking extends BaseModel{

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
    Review review; // We have defined a 1:1 relationship between a booking and review

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startTime;

    @Enumerated(value= EnumType.STRING)
    BookingStatus bookingStatus;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date endTime;

    private Long totalDistance;

    @ManyToOne
    private Driver driver;

    @ManyToOne
    private Passenger passenger;
}
