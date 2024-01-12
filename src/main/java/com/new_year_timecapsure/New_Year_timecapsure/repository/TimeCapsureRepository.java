package com.new_year_timecapsure.New_Year_timecapsure.repository;

import com.new_year_timecapsure.New_Year_timecapsure.entity.TimeCapsure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeCapsureRepository extends JpaRepository<TimeCapsure,Long> {
}
