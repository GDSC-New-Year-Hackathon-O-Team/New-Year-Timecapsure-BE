package com.new_year_timecapsure.New_Year_timecapsure.service;

import com.new_year_timecapsure.New_Year_timecapsure.dto.FindTimeCapsureDTO;
import com.new_year_timecapsure.New_Year_timecapsure.dto.FindTimeCapsureDetailDTO;
import com.new_year_timecapsure.New_Year_timecapsure.entity.TimeCapsure;
import com.new_year_timecapsure.New_Year_timecapsure.entity.User;
import com.new_year_timecapsure.New_Year_timecapsure.repository.TimeCapsureRepository;
import com.new_year_timecapsure.New_Year_timecapsure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TimeCapsureService {
    private final TimeCapsureRepository timeCapsureRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<FindTimeCapsureDTO> findTimeCapsuresByUserId(Long userId) {
        List<FindTimeCapsureDTO> findTimeCapsureDTOs = new ArrayList<>();
        User user = userRepository.findById(userId).orElseThrow(() ->
                new IllegalArgumentException("잘못된 유저 ID입니다."));
        List<TimeCapsure> timeCapsureByUser = timeCapsureRepository.findTimeCapsureByUser(user);
        for (TimeCapsure timeCapsure : timeCapsureByUser) {
            LocalDate timeCapsureEnd = timeCapsure.getTimeCapsureEnd();
            boolean isLocked = false;
            if (timeCapsureEnd.isAfter(LocalDate.now())) {
                isLocked = true;
            }

            FindTimeCapsureDTO findTimeCapsureDTO = FindTimeCapsureDTO.builder()
                    .id(timeCapsure.getTimeCapsureId())
                    .startDate(timeCapsure.getTimeCapsureStart())
                    .endDate(timeCapsureEnd)
                    .isLocked(isLocked)
                    .contents(timeCapsure.getTimeCapsureContents())
                    .question(timeCapsure.getTimeCapsureTitle())
                    .category(timeCapsure.getTimeCapsureCategory())
                    .build();
            findTimeCapsureDTOs.add(findTimeCapsureDTO);
        }
        return findTimeCapsureDTOs;
    }

    @Transactional(readOnly = true)
    public FindTimeCapsureDetailDTO findTimeCapsuresBy(Long timecapsureId) {
        TimeCapsure timeCapsure = timeCapsureRepository.findById(timecapsureId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 타임캡슐 ID입니다."));

       return FindTimeCapsureDetailDTO.from(timeCapsure);


    }
}

