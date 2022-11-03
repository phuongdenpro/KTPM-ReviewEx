package com.example.maybayservice.repository;

import com.example.maybayservice.entity.MayBay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MayBayRepository extends JpaRepository<MayBay, String> {
    @Query("select c from MayBay c where c.tamBay > 10000")
    List<MayBay> getMayBayHon10000km();
}
