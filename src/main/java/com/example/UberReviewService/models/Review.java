package com.example.UberReviewService.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="booking_review")
@Inheritance(strategy = InheritanceType.JOINED)
public class Review extends BaseModel{

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    Booking booking; // W  e have defined a 1:1 relationship between a booking and review

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private float rating;

    public String toString(){
        return "Review: "+this.content+" "+this.rating+" "+this.createdAt;
    }
}
