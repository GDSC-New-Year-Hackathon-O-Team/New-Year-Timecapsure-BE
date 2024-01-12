package com.new_year_timecapsure.New_Year_timecapsure.service;

import com.new_year_timecapsure.New_Year_timecapsure.dto.FindTimeCapsureDTO;
import com.new_year_timecapsure.New_Year_timecapsure.entity.TimeCapsure;
import com.new_year_timecapsure.New_Year_timecapsure.entity.User;
import com.new_year_timecapsure.New_Year_timecapsure.repository.TimeCapsureRepository;
import com.new_year_timecapsure.New_Year_timecapsure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TimeCapsureService {
    private final TimeCapsureRepository timeCapsureRepository;
    private final UserRepository userRepository;

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
}

