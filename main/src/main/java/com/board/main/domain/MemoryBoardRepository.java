package com.board.main.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class MemoryBoardRepository implements BoardRepository {

    private final HashMap<Integer, Board> memoryBoardRepository;

    private int sequence = 0;

    @Override
    public List<Board> findAll() {
        return null;
    }

    @Override
    public Optional<Board> findById(int id) {
        return Optional.ofNullable(memoryBoardRepository.get(id));
    }

    @Override
    public Board findByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int save(Board board) {
        // TODO Auto-generated method stub
        memoryBoardRepository.put(sequence++, board);
        return board.getId();
    }



    public int getSequence(){
        return this.sequence;
    }

}
