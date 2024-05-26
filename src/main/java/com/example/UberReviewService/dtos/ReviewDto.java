package com.example.UberReviewService.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewDto {
    private long id;
    private Date createdAt;
    private Date updatedAt;
    private String content;
    private float rating;
    private Long booking;

}
