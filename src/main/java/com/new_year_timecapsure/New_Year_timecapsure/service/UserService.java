package com.new_year_timecapsure.New_Year_timecapsure.service;

import com.new_year_timecapsure.New_Year_timecapsure.dto.UserLoginRequestDTO;
import com.new_year_timecapsure.New_Year_timecapsure.dto.UserLoginResponseDTO;
import com.new_year_timecapsure.New_Year_timecapsure.entity.User;
import com.new_year_timecapsure.New_Year_timecapsure.repository.UserRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@NoArgsConstructor
public class UserService {
    private UserRepository userRepository;
    public UserLoginResponseDTO login(UserLoginRequestDTO userLoginRequestDTO) {
        User user = userRepository.findByUserEmail(userLoginRequestDTO.getUserEmail())
                .orElseThrow(() -> new IllegalArgumentException("없는 사용자 입니다."));
        return UserLoginResponseDTO.from(user);
    }
}
