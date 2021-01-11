package com.mert.model.userLIstHeader;


import com.mert.dto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Dat {
    private List<UserDto> contents;
}