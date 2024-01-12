package com.new_year_timecapsure.New_Year_timecapsure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class TimeCapsure extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timeCapsureId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private User user;

    @Column
    private String timeCapsureTitle;

    @Column
    private String timeCapsureContents;

    private LocalDate timeCapsureStart;

    private LocalDate timeCapsureEnd;

    @Column
    private String timeCapsureCategory;

    @Column
    private Boolean isPrivate;

    @Builder
    public TimeCapsure(User user, String timeCapsureTitle, String timeCapsureContents, LocalDate timeCapsureStart, LocalDate timeCapsureEnd, String timeCapsureCategory, Boolean isPrivate) {
        this.user = user;
        this.timeCapsureTitle = timeCapsureTitle;
        this.timeCapsureContents = timeCapsureContents;
        this.timeCapsureStart = timeCapsureStart;
        this.timeCapsureEnd = timeCapsureEnd;
        this.timeCapsureCategory = timeCapsureCategory;
        this.isPrivate = isPrivate;
    }
}
