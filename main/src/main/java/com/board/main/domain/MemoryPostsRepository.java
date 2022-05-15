package com.board.main.domain;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class MemoryPostsRepository implements PostsRepository{

    HashMap<Integer, Posts> memoryPostsRepository = new HashMap<>();

    public List<Posts> findAll(){
        return null;
    }
    public Optional<Posts> findById(int id){
        return Optional.ofNullable(memoryPostsRepository.get(id));
    }
}
