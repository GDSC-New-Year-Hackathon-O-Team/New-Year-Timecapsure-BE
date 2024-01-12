package com.new_year_timecapsure.New_Year_timecapsure.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserLoginRequestDTO {
    private String userEmail;
    private String password;
}
