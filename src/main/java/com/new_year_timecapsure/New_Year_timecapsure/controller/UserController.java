package com.new_year_timecapsure.New_Year_timecapsure.controller;

import com.new_year_timecapsure.New_Year_timecapsure.dto.*;
import com.new_year_timecapsure.New_Year_timecapsure.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {
    private final UserService userService;

}
