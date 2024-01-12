package com.new_year_timecapsure.New_Year_timecapsure.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class FindTimeCapsureDTO {
    private Long id;
    private String category;
    private boolean isLocked;
    private LocalDate startDate;
    private LocalDate endDate;
    private String question;
    private String contents;

    @Builder
    public FindTimeCapsureDTO(Long id, String category, boolean isLocked, LocalDate startDate, LocalDate endDate, String question, String contents) {
        this.id = id;
        this.category = category;
        this.isLocked = isLocked;
        this.startDate = startDate;
        this.endDate = endDate;
        this.question = question;
        this.contents = contents;
    }
}
