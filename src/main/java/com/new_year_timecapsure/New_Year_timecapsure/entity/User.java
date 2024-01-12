package com.new_year_timecapsure.New_Year_timecapsure.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.math.BigInteger;
import java.sql.Timestamp;

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger userId;

    @Column(unique = true)
    private String userEmail;

    @Column
    private String userPassword;

    @CreatedDate
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;
}
