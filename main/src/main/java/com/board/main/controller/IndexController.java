package com.board.main.controller;

import com.board.main.BoardService;
import com.board.main.PostsService;
import com.board.main.domain.Board;
import com.board.main.domain.dto.BoardResponseDto;
import com.board.main.domain.dto.SaveBoardRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@RequiredArgsConstructor
@Controller
public class IndexController {
    private final BoardService boardService;

    private final PostsService postsService;
    @GetMapping("/")
    public String home() {
        List<Board> allBoards = boardService.findAll();
        return "home";
    }

    @GetMapping("/boards/new")
    public String newBoard() {
        return "boards/new";
    }

    @GetMapping("/boards/{boardId}/modify")
    public String updateBoard(@PathVariable("boardId") int id, Model model){
        BoardResponseDto boardResponseDto=boardService.findById(id);
        System.out.println(boardResponseDto.getId());
        model.addAttribute("board", boardResponseDto);
        return "boards/modify";
    }
}
