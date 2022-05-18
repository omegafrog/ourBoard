package com.board.main.domain;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemoryPostsRepository implements PostsRepository{

    private final HashMap<Integer, Posts> memoryPostsRepository;

    public List<Posts> findAll(){
        return null;
    }
    public Optional<Posts> findById(int id){
        return Optional.ofNullable(memoryPostsRepository.get(id));
    }
}
