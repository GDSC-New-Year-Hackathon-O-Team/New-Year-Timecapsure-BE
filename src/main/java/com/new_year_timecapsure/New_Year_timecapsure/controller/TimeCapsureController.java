package com.new_year_timecapsure.New_Year_timecapsure.controller;

import com.new_year_timecapsure.New_Year_timecapsure.service.TimeCapsureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/timecapsure")
@RequiredArgsConstructor
public class TimeCapsureController {
    private final TimeCapsureService timeCapsureService;

    //TODO: 황서은
    @PostMapping("/freeform")
    public ResponseEntity addFreeFormTimeCapsure(){
        return ResponseEntity.ok().build();
    }

    //TODO: 김한주
    @PostMapping("/randomform")
    public ResponseEntity addRandomFormTimeCapsure(){
        return ResponseEntity.ok().build();
    }

    //TODO: 김한주
    @GetMapping("/{userId}")
    public ResponseEntity getTimecapsuresByUserId(){
        return ResponseEntity.ok().build();
    }

    //TODO: 김한주
    @GetMapping("/{timecapsureId}")
    public ResponseEntity getTimecapsuresByID(){
        return ResponseEntity.ok().build();
    }

    //TODO: 김한주
    @GetMapping("/{userID}/others")
    public ResponseEntity getOtherTimecapsures(){
        return ResponseEntity.ok().build();
    }
}
