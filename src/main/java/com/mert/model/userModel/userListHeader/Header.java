package com.mert.model.userModel.userListHeader;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Header {
    private boolean result;

    @Column(name = "data")
    private Dat data;

    private String message;
}
