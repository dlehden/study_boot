package com.mert.dto.shipDto;


import lombok.*;
import net.bytebuddy.implementation.bind.annotation.Default;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
public class LinerScheduleDto {
    private Long id; // id 그대로

    private String calendarId; // 우선 id로, 추후에 수정 필요

    private String title; // 선사 liner_code

    private String category; // milestone, task, allday, time 중 하나

    private LocalDateTime start; // eta

    private LocalDateTime end; // etd
}
