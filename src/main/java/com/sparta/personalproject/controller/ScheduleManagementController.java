package com.sparta.personalproject.controller;


import com.sparta.personalproject.dto.ScheduleManagementResponseDto;
import com.sparta.personalproject.dto.ScheduleRequestDto;
import com.sparta.personalproject.entity.ScheduleManagement;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController // 컴포넌트 스캔방식으로 자동 의존관계 설정 , Controller는 view를 반환 RestController는 데이터를 반환
@RequestMapping("/api") // api 중복
public class ScheduleManagementController {

    private final Map<String, ScheduleManagement> scheduleManagementList = new HashMap<>();

    @PostMapping("/schedules") // 복수형태 , 숫자 붙으면서 복수형태가 가독성 용이
    public ScheduleManagementResponseDto schedulecreat(@RequestBody ScheduleRequestDto requestDto) { // 데이터는 바디 부분에 json형태로 넘어오면 Requestbody
        // RequestDto -> Entity로 수정 저장을 해야되기 때문
        ScheduleManagement scheduleManagement = new ScheduleManagement(requestDto);

        // Max ID Check
        String maxwriter = scheduleManagementList.size() > 0 ? Collections.max(scheduleManagementList.keySet()) + scheduleManagement.getWriter() : "작성자:";
        scheduleManagement.setWriter(maxwriter);

        // DB 저장
        scheduleManagementList.put(scheduleManagement.getWriter(), scheduleManagement);

        // Entity -> ResponseDto
        ScheduleManagementResponseDto scheduleManagementResponseDto = new ScheduleManagementResponseDto(scheduleManagement);

        return scheduleManagementResponseDto;
    }

    @GetMapping("/schedules")
    public List<ScheduleManagementResponseDto> getScheduleManagement() {
        // Map to List
        List<ScheduleManagementResponseDto> responseList = scheduleManagementList.values().stream()
                .map(ScheduleManagementResponseDto::new).toList();

        return responseList;
    }

    @PutMapping("/schedules/{writer}")
    public String updateSchedule(@PathVariable String writer, @RequestBody ScheduleRequestDto requestDto) {
        // 해당 정보가 DB에 존재하는지 확인
        if (scheduleManagementList.containsKey(writer)) { // 해당메모 가져오기
            ScheduleManagement scheduleManagement = scheduleManagementList.get(writer);
            // 일정 수정
            scheduleManagement.update(requestDto);
            return scheduleManagement.getWriter();
        } else {
            throw new IllegalArgumentException("존재하지 않는 일정입니다");
        }
    }

    @DeleteMapping("/schedules/{passward}")
    public int deleteScheduleManagement(@PathVariable int passward) {
        if (scheduleManagementList.containsKey(passward)) {
            // 해당 일정 삭제
            scheduleManagementList.remove(passward);
            return passward;
        } else {
            throw new IllegalArgumentException("존재하지 않는 일정입니다");
        }
    }
}
