package com.new_year_timecapsure.New_Year_timecapsure.dto;


import com.new_year_timecapsure.New_Year_timecapsure.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserLoginResponseDTO {
    private Long userId;

    public UserLoginResponseDTO(Long userId) {
        this.userId = userId;
    }

    public static UserLoginResponseDTO from(User user) {
        return new UserLoginResponseDTO(user.getUserId());
    }
}
