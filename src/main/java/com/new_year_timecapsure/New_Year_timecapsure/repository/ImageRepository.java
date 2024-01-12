package com.new_year_timecapsure.New_Year_timecapsure.repository;

import com.new_year_timecapsure.New_Year_timecapsure.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
}
