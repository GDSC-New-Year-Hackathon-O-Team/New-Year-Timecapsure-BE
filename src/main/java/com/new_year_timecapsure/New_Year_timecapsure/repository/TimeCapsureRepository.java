package com.new_year_timecapsure.New_Year_timecapsure.repository;

import com.new_year_timecapsure.New_Year_timecapsure.entity.TimeCapsure;
import com.new_year_timecapsure.New_Year_timecapsure.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeCapsureRepository extends JpaRepository<TimeCapsure,Long> {
    List<TimeCapsure> findTimeCapsureByUser(User user);
}
