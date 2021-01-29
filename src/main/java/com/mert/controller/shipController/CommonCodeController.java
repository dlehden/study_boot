package com.mert.controller.shipController;

import com.mert.dto.shipDto.CommonCodeDto;
import com.mert.service.shipService.CommonCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/common-code")
public class CommonCodeController {
    private final CommonCodeService commonCodeService;

    @Autowired
    public CommonCodeController(CommonCodeService commonCodeService){
        this.commonCodeService = commonCodeService;
    }

    @GetMapping("/all") //common code 전체 조회
    public List<CommonCodeDto> getAllCommonCode(){
        return commonCodeService.getAllCommonCode();
    }

    @GetMapping("/{country}/all") // 특정 나라의 common code 전체 조회
    public List<CommonCodeDto> getCountryCommonCode(@PathVariable String country){
        System.out.println(country.toUpperCase());
        return commonCodeService.getCountryCommonCode(country.toUpperCase());
    }
}
