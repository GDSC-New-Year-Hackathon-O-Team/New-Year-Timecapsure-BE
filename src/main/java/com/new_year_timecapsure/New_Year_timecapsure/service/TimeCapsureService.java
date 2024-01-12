package com.new_year_timecapsure.New_Year_timecapsure.service;

import com.new_year_timecapsure.New_Year_timecapsure.repository.TimeCapsureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimeCapsureService {
    private final TimeCapsureRepository timeCapsureRepository;


}
