package com.board.main.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardResponseDto {
    private final String name;
    private final int id;
    private final String description;
    private final int postId;

    @Builder
    public BoardResponseDto(String name, int id, String description, int postId) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.postId = postId;
    }
}
