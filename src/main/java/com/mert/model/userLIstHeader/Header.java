package com.mert.model.userLIstHeader;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mert.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Header {
    private boolean result;

    @Column(name = "data")
    private Dat data;
}
