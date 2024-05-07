package com.example.UberReviewService.repositories;

import com.example.UberReviewService.models.Booking;
import com.example.UberReviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository //It is a string annotation that indicates that the decorated class is a repository
public interface BookingRepository extends JpaRepository<Booking,Long>  //Jparepository it is JPA specific extention for a repository.
                                                                        // It contains the full API of a CRUD Repository
                                                                        // So it contains a basic api for CRUD operations.
{
    List<Booking> findAllByDriverId(Long driverId);
    List<Booking> findAllByDriverIdIn(List<Driver> drivers);

}
