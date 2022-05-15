package com.board.main;

import com.board.main.domain.Board;
import com.board.main.domain.MemoryBoardRepository;
import com.board.main.domain.dto.BoardResponseDto;
import com.board.main.domain.dto.SaveBoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private MemoryBoardRepository memoryBoardRepository;

    public List<Board> findAll(){
        return memoryBoardRepository.findAll();
    }

    public int save(SaveBoardRequestDto saveBoardRequestDto){
        return saveBoardRequestDto.toEntity().getBoardId();
    }
    public int findPostsIdById(int id){
        Board curBoard = memoryBoardRepository.findById(id);
        return curBoard.getPostsId();
    }
}
