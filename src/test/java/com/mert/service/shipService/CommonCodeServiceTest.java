package com.mert.service.shipService;

import com.mert.dto.shipDto.CommonCodeDto;
import com.mert.model.shipModel.CommonCode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CommonCodeServiceTest {

    @Autowired
    private CommonCodeService commonCodeService;

    @Test
    public void getAllCommonCodeTest(){
        List<CommonCodeDto> list = commonCodeService.getAllCommonCode();
        list.forEach(System.out::println);

        Assertions.assertAll(
                ()->Assertions.assertEquals(list.size(), 3),
                ()->Assertions.assertEquals(list.get(0).getCountryCode(), "KR"),
                ()->Assertions.assertEquals(list.get(1).getCountryCode(), "KR"),
                ()->Assertions.assertEquals(list.get(2).getCountryCode(), "CN"),
                ()->Assertions.assertEquals(list.get(0).getPortCode(), "KRKIN"),
                ()->Assertions.assertEquals(list.get(1).getPortCode(), "KRPUS"),
                ()->Assertions.assertEquals(list.get(2).getPortCode(), "CNSHA")
        );
    }

    @Test
    public void getCountryCommonCodeTess(){
        List<CommonCodeDto> list = commonCodeService.getCountryCommonCode("KR");
        list.forEach(System.out::println);

        Assertions.assertAll(
                ()->Assertions.assertEquals(list.size(), 2),
                ()->Assertions.assertEquals(list.get(0).getCountryCode(), "KR"),
                ()->Assertions.assertEquals(list.get(1).getCountryCode(), "KR"),
                ()->Assertions.assertEquals(list.get(0).getPortCode(), "KRKIN"),
                ()->Assertions.assertEquals(list.get(1).getPortCode(), "KRPUS")
        );
    }
}