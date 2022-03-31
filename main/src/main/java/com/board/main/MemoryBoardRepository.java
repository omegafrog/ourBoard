package com.board.main;

import java.util.HashMap;
import java.util.List;

import com.board.main.repository.Board;
import com.board.main.repository.BoardRepository;

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
