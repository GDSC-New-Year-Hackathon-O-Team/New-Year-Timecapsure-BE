package com.new_year_timecapsure.New_Year_timecapsure.service;

import com.new_year_timecapsure.New_Year_timecapsure.dto.CreateTimeCapsureRequestDTO;
import com.new_year_timecapsure.New_Year_timecapsure.dto.CreateTimeCapsureResponseDTO;
import com.new_year_timecapsure.New_Year_timecapsure.dto.FindTimeCapsureDTO;
import com.new_year_timecapsure.New_Year_timecapsure.dto.FindTimeCapsureDetailDTO;
import com.new_year_timecapsure.New_Year_timecapsure.dto.FindTitleByCategoryDTO;
import com.new_year_timecapsure.New_Year_timecapsure.dto.OtherTimeCapsureDTO;
import com.new_year_timecapsure.New_Year_timecapsure.entity.Question;
import com.new_year_timecapsure.New_Year_timecapsure.entity.TimeCapsure;
import com.new_year_timecapsure.New_Year_timecapsure.entity.User;
import com.new_year_timecapsure.New_Year_timecapsure.repository.QuestionRepository;
import com.new_year_timecapsure.New_Year_timecapsure.repository.TimeCapsureRepository;
import com.new_year_timecapsure.New_Year_timecapsure.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TimeCapsureService {
    private final TimeCapsureRepository timeCapsureRepository;
    private final UserRepository userRepository;
    private final QuestionRepository questionRepository;

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

    public List<OtherTimeCapsureDTO> findOthersTimeCapsures(Long timecapsureId) {
        List<OtherTimeCapsureDTO> otherTimeCapsureDTOs = new ArrayList<>();

        TimeCapsure timeCapsure = timeCapsureRepository.findById(timecapsureId)
                .orElseThrow(() -> new IllegalArgumentException("잘못된 타임캡슐 ID입니다."));
        User user = timeCapsure.getUser();
        List<TimeCapsure> allTimeCapsure = timeCapsureRepository.findAll();
        for (TimeCapsure tc : allTimeCapsure) {
            System.out.println(tc.toString());
            System.out.println(user);
            if (tc.getUser().getUserId() == user.getUserId())
                continue;

            if(!tc.getTimeCapsureTitle().equals(timeCapsure.getTimeCapsureTitle()))
                continue;
            if(tc.getIsPrivate())
                continue;
            otherTimeCapsureDTOs.add(OtherTimeCapsureDTO.builder()
                    .id(tc.getTimeCapsureId())
                    .contents(tc.getTimeCapsureContents().trim())
                    .build());
        }
        return otherTimeCapsureDTOs;
    }

    public FindTitleByCategoryDTO getTitleByCategory(String category) {
        List<Question> questionByCategory = questionRepository.findQuestionByCategory(category);
        int length = questionByCategory.size();
        int index = (int) (Math.random() * length);
        return new FindTitleByCategoryDTO(questionByCategory.get(index).getQuestion());
    }

    public CreateTimeCapsureResponseDTO createTimeCapsure(CreateTimeCapsureRequestDTO createTimeCapsureRequestDTO) {

        User user = userRepository.findById(1L).get();
        int randomTermMonth = (int) (Math.random() * 12);
        LocalDate endDate = LocalDate.now().plusMonths(randomTermMonth);
        TimeCapsure timeCapsure = TimeCapsure.builder()
                .user(user)
                .timeCapsureTitle(createTimeCapsureRequestDTO.getTitle())
                .timeCapsureContents(createTimeCapsureRequestDTO.getContents())
                .timeCapsureStart(LocalDate.now())
                .timeCapsureEnd(LocalDate.of(endDate.getYear(), endDate.getMonth(), 1))
                .timeCapsureCategory(createTimeCapsureRequestDTO.getCategory())
                .isPrivate(createTimeCapsureRequestDTO.getIsPrivate())
                .build();
        timeCapsureRepository.save(timeCapsure);
        return new CreateTimeCapsureResponseDTO(true);
    }
}

