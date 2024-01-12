package com.new_year_timecapsure.New_Year_timecapsure.controller;

import com.new_year_timecapsure.New_Year_timecapsure.dto.UserLoginRequestDTO;
import com.new_year_timecapsure.New_Year_timecapsure.dto.UserLoginResponseDTO;
import com.new_year_timecapsure.New_Year_timecapsure.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    public ResponseEntity<UserLoginResponseDTO> login(@RequestBody UserLoginRequestDTO userLoginRequestDTO) {
        UserLoginResponseDTO userLoginResponseDTO = userService.login(userLoginRequestDTO);
        return ResponseEntity.ok(userLoginResponseDTO);
    }
}
