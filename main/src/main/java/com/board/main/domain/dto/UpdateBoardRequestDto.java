package com.board.main.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class UpdateBoardRequestDto {
    private int id;
    private String name;
    private String description;

    @Builder
    public UpdateBoardRequestDto(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
