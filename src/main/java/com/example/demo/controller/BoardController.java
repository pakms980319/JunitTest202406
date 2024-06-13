package com.example.demo.controller;


import com.example.demo.domain.dto.BoardDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/board")
@Slf4j
public class BoardController {

    @GetMapping("/list")
    public void list(@RequestParam(required = true) Long pageNo){
        log.info("GET /board/list  pageNo : " + pageNo);
    }

    @GetMapping("/post")
    public void post_get(){
        log.info("GET /board/post");
    }

    @PostMapping("/post")
    public void post_post(@RequestBody BoardDto dto){
        log.info("POST /board/post dto : " + dto);
    }

    @GetMapping("/update")
    public void update_get(@ModelAttribute BoardDto dto){
        log.info("GET /board/update dto : " + dto);
    }
}

