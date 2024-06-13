package com.example.demo.controller;


import com.example.demo.domain.dto.BoardDto;
import com.example.demo.restcontroller.BoardRestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value={BoardController.class, BoardRestController.class})
public class BoardControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void listTest() throws Exception {
        // given - 테스트 준비 (변수선언 /입력값 정의)
        BoardDto boardDto = getBoardDto();

        // when - 처리해야되는 Action 을 준비 (Repository, Service)

        // then - 테스트 검증 처리 (실제값 과 예상값을 비교)
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/board/list")
                        .param("pageNo", String.valueOf(1L))
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void PostGetTest() throws Exception {
        // given - 테스트 준비 (변수선언 /입력값 정의)
        BoardDto boardDto = getBoardDto();

        // when - 처리해야되는 Action 을 준비 (Repository, Service)

        // then - 테스트 검증 처리 (실제값 과 예상값을 비교)
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/board/post")
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void PostPostTest() throws Exception {
        // given - 테스트 준비 (변수선언 /입력값 정의)
        BoardDto boardDto = getBoardDto();
        ObjectMapper objectMapper = new ObjectMapper();

        // when - 처리해야되는 Action 을 준비 (Repository, Service)

        // then - 테스트 검증 처리 (실제값 과 예상값을 비교)
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/board/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(boardDto))
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void UpdateGetTest() throws Exception {
        // given - 테스트 준비 (변수선언 /입력값 정의)
        BoardDto boardDto = getBoardDto();
        // when - 처리해야되는 Action 을 준비 (Repository, Service)

        // then - 테스트 검증 처리 (실제값 과 예상값을 비교)
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .get("/board/update")
                                .param("no", String.valueOf(boardDto.getNo()))
                                .param("title", boardDto.getTitle())
                                .param("writer", boardDto.getWriter())
                                .param("contents", boardDto.getContents())
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    private BoardDto getBoardDto() {
        return new BoardDto(1L, "테스트 제목", "관리자", "테스트 중입니다.");
    }

}
