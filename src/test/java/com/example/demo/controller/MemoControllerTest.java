package com.example.demo.controller;

import com.example.demo.domain.dto.MemoDto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(value={MemoController.class})
class MemoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void t1() throws Exception {
        // given - 테스트 준비 (변수선언 / 입력값 정의)
        MemoDto memoDto = new MemoDto(1l, "text1");

        // when - 처리해야되는 Action 을 준비 (Repository , Service)


        // then - 테스트 검증 처리 (실제값 과 예상값을 비교)
        this.mockMvc.perform(
                MockMvcRequestBuilders
                        .get("/memo/get")
                        .param("memoDto", String.valueOf(memoDto))
        ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void t2() throws Exception {
        // given - 테스트 준비 (변수선언 / 입력값 정의)
        MemoDto memoDto = new MemoDto(1l, "text1");

        // when - 처리해야되는 Action 을 준비 (Repository , Service)


        // then - 테스트 검증 처리 (실제값 과 예상값을 비교)
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/memo/post")
                                .content(String.valueOf(memoDto))
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }

    @Test
    public void t3() throws Exception {
        // given - 테스트 준비 (변수선언 / 입력값 정의)
        MemoDto memoDto = new MemoDto(1l, "text1");

        // when - 처리해야되는 Action 을 준비 (Repository , Service)

        // then - 테스트 검증 처리 (실제값 과 예상값을 비교)
        this.mockMvc.perform(
                        MockMvcRequestBuilders
                                .post("/memo/post_header")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(String.valueOf(memoDto))
                ).andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(print());
    }
}