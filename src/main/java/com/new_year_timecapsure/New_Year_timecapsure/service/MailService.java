package com.new_year_timecapsure.New_Year_timecapsure.service;

/*import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;*/

import com.new_year_timecapsure.New_Year_timecapsure.dto.MailDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Component
@EnableScheduling
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

/*    @Scheduled(fixedDelay = 1000)
    public void schedulerTest(){
        System.out.println("SchedulerTest");
    }*/

    @Scheduled(cron = "0/600 * * * * *")
    public void sendMail(){
        ArrayList<String> toUserList = new ArrayList<>();

        toUserList.add("newyeartimecapsure@gmail.com");

        int toUserSize = toUserList.size();

        SimpleMailMessage simpleMessage = new SimpleMailMessage();

        simpleMessage.setTo((String[]) toUserList.toArray(new String[toUserSize]));

        simpleMessage.setSubject("당신의 New-Year TimeCapsule을 확인해보세요~!");

        simpleMessage.setText("2024.01.13[토] 타임캡슐이 공개되었습니다!\nNew-Year TimeCapsule에 방문하여 과거에 작성한 캡슐을 열어보세요");

        javaMailSender.send(simpleMessage);
    }
}
/*
@Service
@AllArgsConstructor
public class MailService {

    private JavaMailSender javaMailSender;
    private static final String FROM_ADDRESS = "이메일에 보낼 주소";

    public void mailSend(MailDTO mailDTO){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailDTO.getAddress());
        message.setSubject(mailDTO.getTitle());
        message.setText(mailDTO.getMessage());
        javaMailSender.send(message);
    }
}*/
