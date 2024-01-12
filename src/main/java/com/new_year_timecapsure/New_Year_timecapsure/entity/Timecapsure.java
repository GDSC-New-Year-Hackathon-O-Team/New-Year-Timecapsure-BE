package com.new_year_timecapsure.New_Year_timecapsure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
public class Timecapsure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timecapsureId;

    @ManyToOne
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private User user;

    @Column
    private String timecapsureTitle;

    @Column
    private String timecapsureContents;

    @CreatedDate
    private Timestamp timecapsureStart;

    @CreatedDate
    private Timestamp timecapsureEnd;

    @Column
    private String timecapsureCategory;

    @Column
    private Boolean isPrivated;
}
