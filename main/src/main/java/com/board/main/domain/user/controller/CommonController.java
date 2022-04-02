package com.board.main.domain.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CommonController {
    @GetMapping(value = {"/","/ourboard"})
    public String mainView(){
        return "index";
    }

}
