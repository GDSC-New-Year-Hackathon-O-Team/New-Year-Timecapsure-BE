package com.new_year_timecapsure.New_Year_timecapsure.dto;

import com.new_year_timecapsure.New_Year_timecapsure.entity.TimeCapsure;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
public class FindTimeCapsureDetailDTO {
    private Long id;
    private String title;
    private String contents;
    private LocalDate startDate;
    private LocalDate endDate;
    private String category;
    private Boolean isPrivate;

    @Builder
    public FindTimeCapsureDetailDTO(Long id, String title, String contents, LocalDate startDate, LocalDate endDate, String category, Boolean isPrivate) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.startDate = startDate;
        this.endDate = endDate;
        this.category = category;
        this.isPrivate = isPrivate;
    }

    public static FindTimeCapsureDetailDTO from(TimeCapsure timeCapsure) {
        return FindTimeCapsureDetailDTO.builder()
                .id(timeCapsure.getTimeCapsureId())
                .title(timeCapsure.getTimeCapsureTitle())
                .contents(timeCapsure.getTimeCapsureContents())
                .startDate(timeCapsure.getTimeCapsureStart())
                .endDate(timeCapsure.getTimeCapsureEnd())
                .category(timeCapsure.getTimeCapsureCategory())
                .isPrivate(timeCapsure.getIsPrivate())
                .build();
    }
}
