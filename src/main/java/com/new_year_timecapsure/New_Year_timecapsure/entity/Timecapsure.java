package com.new_year_timecapsure.New_Year_timecapsure.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigInteger;
import java.sql.Timestamp;

@Entity
public class Timecapsure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timecapsureId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

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
