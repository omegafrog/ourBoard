package com.board.main.domain.dto;

import com.board.main.domain.Post;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class PostsResponseDto {

    private int id;
    private List<Post> contents;

    @Builder
    public PostsResponseDto(int id, List<Post> contents) {
        this.id = id;
        this.contents = contents;
    }
}
