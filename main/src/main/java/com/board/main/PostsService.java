package com.board.main;

import com.board.main.domain.MemoryPostsRepository;
import com.board.main.domain.Posts;
import com.board.main.domain.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final MemoryPostsRepository memoryPostsRepository;

    public List<Posts> findAll(){
        return memoryPostsRepository.findAll();
    }
    public PostsResponseDto findById(int id){
        Posts posts =  memoryPostsRepository.findById(id).orElse(Posts.builder().build());
        return PostsResponseDto.builder()
                .id(posts.getId())
                .contents(posts.getContents())
                .build();

    }
}
