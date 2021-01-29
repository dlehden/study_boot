package com.mert.service.shipService;

import com.mert.dto.shipDto.CommonCodeDto;
import com.mert.model.shipModel.CommonCode;
import com.mert.repository.shipInfoRepository.CommonCodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommonCodeService {
    private final CommonCodeRepository commonCodeRepository;

    @Autowired
    public CommonCodeService(CommonCodeRepository commonCodeRepository){
        this.commonCodeRepository = commonCodeRepository;
    }

    // 모든 나라 코드 - 항구 코드 쌍 출력
    public List<CommonCodeDto> getAllCommonCode(){
        List<CommonCodeDto> dtoList = new ArrayList<CommonCodeDto>();
        List<CommonCode> list = commonCodeRepository.findAll();
        list.forEach(commonCode->{
            CommonCodeDto commonCodeDto=CommonCodeDto.builder()
                    .id(commonCode.getId())
                    .countryCode(commonCode.getCountryCode())
                    .portCode(commonCode.getPortCode())
                    .build();

            dtoList.add(commonCodeDto);
        });

        return dtoList;
    }

    // 특정 나라의 항구 코드 목록 출력
    public List<CommonCodeDto> getCountryCommonCode(String country){
        List<CommonCodeDto> dtoList = new ArrayList<CommonCodeDto>();
        List<CommonCode> list = commonCodeRepository.findByCountryCode(country);
        list.forEach(commonCode->{
            CommonCodeDto commonCodeDto=CommonCodeDto.builder()
                    .id(commonCode.getId())
                    .countryCode(commonCode.getCountryCode())
                    .portCode(commonCode.getPortCode())
                    .build();

            dtoList.add(commonCodeDto);
        });

        return dtoList;
    }
}
