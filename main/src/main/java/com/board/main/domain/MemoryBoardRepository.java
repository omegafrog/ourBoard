package com.board.main.domain;

import java.util.HashMap;
import java.util.List;

import com.board.main.domain.Board;
import com.board.main.domain.BoardRepository;

public class MemoryBoardRepository implements BoardRepository {

    HashMap<Integer, Board> memoryBoardRepository = new HashMap<>();

    @Override
    public List<Board> findAll() {
        return null;
    }

    @Override
    public Board findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Board findByName(String name) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void newBoard(Board board) {
        // TODO Auto-generated method stub
        memoryBoardRepository.put(board.getId(), board);
    }

}
