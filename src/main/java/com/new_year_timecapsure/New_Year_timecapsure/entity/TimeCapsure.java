package com.new_year_timecapsure.New_Year_timecapsure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;

@Entity
public class TimeCapsure extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timeCapsureId;

    @ManyToOne
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private User user;

    @Column
    private String timeCapsureTitle;

    @Column
    private String timeCapsureContents;

    @CreatedDate
    private Timestamp timeCapsureStart;

    @CreatedDate
    private Timestamp timeCapsureEnd;

    @Column
    private String timeCapsureCategory;

    @Column
    private Boolean isPrivate;
}
