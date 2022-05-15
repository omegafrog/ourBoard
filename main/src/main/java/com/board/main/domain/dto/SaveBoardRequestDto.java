package com.board.main.domain.dto;


import com.board.main.domain.Board;
import lombok.Builder;
import lombok.Getter;

@Getter
public class SaveBoardRequestDto {

    String name;
    int id;
    int postsId;

    @Builder
    public SaveBoardRequestDto(String name, int id, int postsId) {
        this.name = name;
        this.id = id;
        this.postsId = postsId;
    }

    public Board toEntity(){
        return Board.builder()
                .name(this.name)
                .boardId(this.id)
                .postsId(this.postsId)
                .build();
    }
}
