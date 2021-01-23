package com.mert.dto.shipDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonCodeDto {
    private Long id;

    private String countryCode;

    private String portCode;
}
