package com.mert.repository.shipInfoRepository;

import com.mert.dto.shipDto.CommonCodeDto;
import com.mert.model.shipModel.CommonCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonCodeRepository extends JpaRepository<CommonCode, Long> {
    public List<CommonCode> findByCountryCode(String countryCode);
}
