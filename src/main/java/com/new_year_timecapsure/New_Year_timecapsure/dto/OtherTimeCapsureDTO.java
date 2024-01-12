package com.new_year_timecapsure.New_Year_timecapsure.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class OtherTimeCapsureDTO {
    private Long id;
    private String contents;
//    private String category;
//    private String title;
//    private LocalDate startDate;
//    private LocalDate endDate;


    @Builder
    public OtherTimeCapsureDTO(String contents, Long id) {
        this.contents = contents;
        this.id = id;
    }
}
