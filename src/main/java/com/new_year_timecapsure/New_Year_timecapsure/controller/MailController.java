package com.new_year_timecapsure.New_Year_timecapsure.controller;

import com.new_year_timecapsure.New_Year_timecapsure.dto.MailDTO;
import com.new_year_timecapsure.New_Year_timecapsure.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;

    @GetMapping("/mail")
    public String execMail(MailDTO mailDTO){
        mailService.sendMail();
        return "hello";
    }
}
