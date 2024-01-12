package com.new_year_timecapsure.New_Year_timecapsure.repository;

import com.new_year_timecapsure.New_Year_timecapsure.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    List<Question> findQuestionByCategory(String category);
}
