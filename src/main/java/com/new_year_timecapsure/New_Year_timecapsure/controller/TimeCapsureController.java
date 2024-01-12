package com.new_year_timecapsure.New_Year_timecapsure.controller;

import com.new_year_timecapsure.New_Year_timecapsure.dto.CategoryTotalDTO;
import com.new_year_timecapsure.New_Year_timecapsure.dto.CreateTimeCapsureRequestDTO;
import com.new_year_timecapsure.New_Year_timecapsure.dto.FindTimeCapsureDTO;
import com.new_year_timecapsure.New_Year_timecapsure.dto.FindTimeCapsureDetailDTO;
import com.new_year_timecapsure.New_Year_timecapsure.dto.OtherTimeCapsureDTO;
import com.new_year_timecapsure.New_Year_timecapsure.service.TimeCapsureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/timecapsure")
@RequiredArgsConstructor
@CrossOrigin("*")
public class TimeCapsureController {
    private final TimeCapsureService timeCapsureService;

    //TODO: 황서은
    @PostMapping("/freeform")
    public ResponseEntity addFreeFormTimeCapsure() {
        return ResponseEntity.ok().build();
    }

    @GetMapping("/title")
    public ResponseEntity getTitleByCategory(@RequestParam("category") String category) {
        return ResponseEntity.ok(timeCapsureService.getTitleByCategory(category));
    }

    //TODO: 김한주
    @PostMapping("/randomform")
    public ResponseEntity addRandomFormTimeCapsure(@RequestBody CreateTimeCapsureRequestDTO createTimeCapsureRequestDTO) {
        return ResponseEntity.ok(timeCapsureService.createTimeCapsure(createTimeCapsureRequestDTO));
    }

    //TODO: 김한주
    @GetMapping("/user/{userId}")
    public ResponseEntity getTimecapsuresByUserId(@PathVariable("userId") Long userId) {
        List<FindTimeCapsureDTO> timeCapsuresByUserId = timeCapsureService.findTimeCapsuresByUserId(userId);
        return ResponseEntity.ok(timeCapsuresByUserId);
    }

    //TODO: 김한주
    @GetMapping("/{timecapsureId}")
    public ResponseEntity getTimecapsuresByID(@PathVariable("timecapsureId") Long timecapsureId) {
        FindTimeCapsureDetailDTO timeCapsuresBy = timeCapsureService.findTimeCapsuresBy(timecapsureId);
        return ResponseEntity.ok(timeCapsuresBy);
    }

    //TODO: 김한주
    @GetMapping("/{timecapsureId}/others")
    public ResponseEntity getOtherTimecapsures(@PathVariable("timecapsureId") Long timecapsureId) {
        List<OtherTimeCapsureDTO> othersTimeCapsures = timeCapsureService.findOthersTimeCapsures(timecapsureId);
        return ResponseEntity.ok(othersTimeCapsures);
    }

    @GetMapping("/category/total")
    public ResponseEntity getCategoryTotal(){
        List<CategoryTotalDTO> categoryTotalDTOs = timeCapsureService.getCategoryTotal();
        return ResponseEntity.ok(categoryTotalDTOs);
    }
}
