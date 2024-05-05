package com.example.UberReviewService.repositories;

import com.example.UberReviewService.models.BaseModel;
import com.example.UberReviewService.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
    Optional<Driver> findByIdAndLisenceNumber(Long id,String lisenceNumber);

    @Query(nativeQuery = true,value = "SELECT * FROM DRIVER where id=:id AND lisence_number=:lisence") //RAW myswl query, error is thrown at runtime is query has issue
    Optional<Driver> rawFindByIdAndLisenceNumber(Long id,String lisence);

    @Query(value= "SELECT d From Driver as d where d.id=:id AND d.lisenceNumber=:lisenceNumber") //Hibernate query, error is thrown at compile time
    Optional<Driver> hqlFindByIdAndLisence(Long id,String lisenceNumber);
}
