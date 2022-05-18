package com.board.main.controller;

import com.board.main.BoardService;
import com.board.main.PostsService;

import com.board.main.domain.dto.BoardResponseDto;
import com.board.main.domain.dto.PostsResponseDto;
import com.board.main.domain.dto.SaveBoardRequestDto;
import com.board.main.domain.dto.UpdateBoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    private final PostsService postsService;

    // 해당 id를 가진 보드의 모든 글을 보여줌.
    @GetMapping("/boards/{boardId}")
    public String postsList(@PathVariable int boardId, Model model){
        BoardResponseDto boardResponseDto = boardService.findById(boardId);
        PostsResponseDto postsResponseDto = postsService.findById(boardResponseDto.getPostId());
        model.addAttribute("posts", postsResponseDto);
        model.addAttribute("board", boardResponseDto);
        return "boards/board";
    }



    @PostMapping("/boards/new")
    public String newBoard( SaveBoardRequestDto saveBoardRequestDto){
        boardService.save(saveBoardRequestDto);
        return "redirect:/";
    }

    @PutMapping("/boards/{boardId}")
    public String updateBoard(@PathVariable("boardId") int id, UpdateBoardRequestDto updateBoardRequestDto){
        boardService.update(updateBoardRequestDto);
        return "redirect:/";
    }
}
