package com.board.main.controller;

import java.util.LinkedList;

import com.board.main.BoardService;
import com.board.main.domain.Board;
import com.board.main.domain.Post;
import com.board.main.domain.Posts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    // 해당 id를 가진 보드의 모든 글을 보여줌.
    @GetMapping("/boards/{boardid}")
    // boardid라는 path variable을 쓰기 위해서는 getBoard라는 method안에다 @PathVariable
    // annotation을
    // 추가해야 한다. 그리고 그걸 boardid라는 이름의 변수로 짓고,
    // view로 인수를 전달해주기 위해서 model을 인자로 한다.
    public String getBoard(@PathVariable("boardid") int boardid, Model model) {
        // Board currentBoard = memoryBoardRepository.findById(boardid);
        // Posts currentPosts = memoryPostRepository.findById(postsid);
//        Board currentBoard = new Board();
//        currentBoard.setId(1);
//        currentBoard.setName("hi");
//        currentBoard.setPostsid(1);
//        Posts currentPosts = new Posts();
//        LinkedList contentList = new LinkedList<>();
//        contentList.add(new Post("no1", 1));
//        contentList.add(new Post("no2", 2));
//        contentList.add(new Post("no3", 3));
//        currentPosts.setContents(contentList);



        // 대충 더미 데이터를 만들고 model에 board와 posts를 넣는다.
//        model.addAttribute("board", currentBoard);
//        model.addAttribute("posts", currentPosts);

        return "boards/board";
    }

    @GetMapping("/boards/new")
    public String newBoard() {
        return "boards/new";
    }

    @PostMapping("/boards/new")
    public String postBoard(Board board) {
        // int newPostsid = memoryPostRepository.create();
        // int newBoardid = memoryBoardRepository.create(board.name, board.description,
        // postid);
        return "redirect:/";
    }
}
