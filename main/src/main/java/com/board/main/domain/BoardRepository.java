package com.board.main.domain;

import java.util.List;

public interface BoardRepository {
    void newBoard(Board board);

    Board findById(int id);

    List<Board> findAll();

    Board findByName(String name);
}
