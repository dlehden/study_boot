package com.mert.service.shipService;

import com.mert.dto.shipDto.LinerScheduleDto;
import com.mert.model.shipModel.LinerSchedule;
import com.mert.repository.shipInfoRepository.LinerScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LinerScheduleService {

    private final LinerScheduleRepository linerScheduleRepository;

    public List<LinerScheduleDto> getAllSchedule(){
        List<LinerSchedule> list = linerScheduleRepository.findAll();
        List<LinerScheduleDto> dtoList = new ArrayList<>();
        list.forEach(linerSchedule -> {
           dtoList.add(LinerScheduleDto.builder()
                   .id(linerSchedule.getId())
                   .calendarId(linerSchedule.getId().toString())
                   .title(linerSchedule.getLinerCode())
                   .category("time")
                   .start(linerSchedule.getEta())
                   .end(linerSchedule.getEtd())
                   .build());
        });
        return dtoList;
    }

}
