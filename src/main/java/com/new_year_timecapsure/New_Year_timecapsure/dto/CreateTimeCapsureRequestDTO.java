package com.new_year_timecapsure.New_Year_timecapsure.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateTimeCapsureRequestDTO {
    private String title;
    private String contents;
    private String category;
    private Boolean isPrivate;
}
