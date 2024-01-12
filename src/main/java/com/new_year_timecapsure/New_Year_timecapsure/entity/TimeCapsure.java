package com.new_year_timecapsure.New_Year_timecapsure.entity;

import jakarta.persistence.*;
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
}
