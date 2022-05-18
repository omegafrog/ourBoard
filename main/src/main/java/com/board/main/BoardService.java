package com.board.main;

import com.board.main.domain.Board;
import com.board.main.domain.MemoryBoardRepository;
import com.board.main.domain.dto.BoardResponseDto;
import com.board.main.domain.dto.SaveBoardRequestDto;
import com.board.main.domain.dto.UpdateBoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final MemoryBoardRepository memoryBoardRepository;



    public List<Board> findAll(){
        return memoryBoardRepository.findAll();
    }

    public int save(SaveBoardRequestDto saveBoardRequestDto){
        Board board = Board.builder()
                .id(memoryBoardRepository.getSequence())
                .name(saveBoardRequestDto.getName())
                .description(saveBoardRequestDto.getDescription())
                .postsId(saveBoardRequestDto.getPostId())
                .build();
        int id = memoryBoardRepository.save(board);
        return id;
    }
    public int update(UpdateBoardRequestDto updateBoardRequestDto){
        Board board = memoryBoardRepository.findById(updateBoardRequestDto.getId()).orElseThrow( () -> new IllegalArgumentException("그런 보드는 없습니다."));
        int id = board.update(updateBoardRequestDto.getName(), updateBoardRequestDto.getDescription());
        return id;
    }
    public BoardResponseDto findById(int id){
        Board curBoard = memoryBoardRepository.findById(id).orElseThrow( ()->new IllegalArgumentException("해당 게시판이 없습니다. id:"+id));
        return BoardResponseDto.builder()
                .id(curBoard.getId())
                .description(curBoard.getDescription())
                .postId(curBoard.getPostsId())
                .name(curBoard.getName())
                .build();
    }
}
