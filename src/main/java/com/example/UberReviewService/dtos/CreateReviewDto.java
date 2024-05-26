package com.example.UberReviewService.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateReviewDto {

    private String content;
    private float rating;
    private Long bookingId;

}
