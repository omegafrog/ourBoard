package com.board.main.domain.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Optional;

@Getter
public class SaveBoardRequestDto {

    private String name;
    private String description;
    private int postId;

    @Builder

    public SaveBoardRequestDto(String name, String description, int postId) {
        this.name = name;
        this.description = description;
        this.postId = postId;
    }
}
