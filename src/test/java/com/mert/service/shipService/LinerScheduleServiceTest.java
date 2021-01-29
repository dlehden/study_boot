package com.mert.service.shipService;

import com.mert.dto.shipDto.LinerScheduleDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LinerScheduleServiceTest {

    @Autowired
    private LinerScheduleService linerScheduleService;

    @Test
    public void getAllScheduleTest(){
        List<LinerScheduleDto> list = linerScheduleService.getAllSchedule();
        list.forEach(System.out::println);
    }
}