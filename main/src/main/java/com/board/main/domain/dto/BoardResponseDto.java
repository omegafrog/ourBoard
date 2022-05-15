package com.board.main.domain.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class BoardResponseDto {
    private final String name;
    private final int boardId;
    private final int postsId;

    @Builder

    public BoardResponseDto(String name, int boardId, int postsId) {
        this.name = name;
        this.boardId = boardId;
        this.postsId = postsId;
    }
}
