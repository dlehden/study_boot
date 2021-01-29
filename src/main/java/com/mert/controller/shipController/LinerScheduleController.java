package com.mert.controller.shipController;

import com.mert.dto.shipDto.LinerScheduleDto;
import com.mert.service.shipService.LinerScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LinerScheduleController {

    private final LinerScheduleService linerScheduleService;

    @GetMapping("liner-schedule")
    public List<LinerScheduleDto> getAllSchedule(){
        return linerScheduleService.getAllSchedule();
    }
}
