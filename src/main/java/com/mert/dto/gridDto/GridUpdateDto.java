package com.mert.dto.gridDto;

import com.mert.dto.userDto.UserDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GridUpdateDto {
    private List<UserDto> updatedRows;
}
