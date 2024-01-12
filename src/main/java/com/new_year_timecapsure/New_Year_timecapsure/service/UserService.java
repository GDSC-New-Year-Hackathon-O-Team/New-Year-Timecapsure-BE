package com.new_year_timecapsure.New_Year_timecapsure.service;

import com.new_year_timecapsure.New_Year_timecapsure.entity.User;
import com.new_year_timecapsure.New_Year_timecapsure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

}
