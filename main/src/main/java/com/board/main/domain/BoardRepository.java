package com.board.main.domain;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    int save(Board board);

    Optional<Board> findById(int id);

    List<Board> findAll();

    Board findByName(String name);
}
