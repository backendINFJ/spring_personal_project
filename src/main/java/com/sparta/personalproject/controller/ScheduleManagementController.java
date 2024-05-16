package com.sparta.personalproject.controller;


import com.sparta.personalproject.dto.ScheduleManagementResponseDto;
import com.sparta.personalproject.dto.ScheduleRequestDto;
import com.sparta.personalproject.entity.ScheduleManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController // 컴포넌트 스캔방식으로 자동 의존관계 설정 , Controller는 view를 반환 RestController는 데이터를 반환
@RequestMapping("/api") // api 중복
public class ScheduleManagementController {

    private final Map<String, ScheduleManagement> scheduleManagementList = new HashMap<>();

    @PostMapping("/create")
    public ScheduleManagementResponseDto schedulecreat(@RequestBody ScheduleRequestDto requestDto) { // 데이터는 바디 부분에 json형태로 넘어오면 Requestbody
        // RequestDto -> Entity로 수정 저장을 해야되기 때문
        ScheduleManagement scheduleManagement = new ScheduleManagement(requestDto);

        // Max ID Check
        String maxwriter = scheduleManagementList.size() > 0 ? Collections.max(scheduleManagementList.keySet()) + 1 : "OMG";
       scheduleManagement.setWriter(maxwriter);

        // DB 저장
        scheduleManagementList.put(scheduleManagement.getWriter(), scheduleManagement);

        // Entity -> ResponseDto
        ScheduleManagementResponseDto scheduleManagementResponseDto = new ScheduleManagementResponseDto(scheduleManagement);

        return scheduleManagementResponseDto;
    }
}
