package com.new_year_timecapsure.New_Year_timecapsure.repository;

import com.new_year_timecapsure.New_Year_timecapsure.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
