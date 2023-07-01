package com.example.demo.controller;

import com.example.demo.service.IWordTOpdfServce;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author :songyuan.zheng
 * @date :  2023/7/1 14:50
 */
@RestController
@RequestMapping("word-to-pdf")
public class WordTOpdfController {
    private final IWordTOpdfServce iWordTOpdfServce;

    public WordTOpdfController(IWordTOpdfServce iWordTOpdfServce) {
        this.iWordTOpdfServce = iWordTOpdfServce;
    }

    @PostMapping("translate")
    public void setiWordTOpdfServce() throws IOException {
        iWordTOpdfServce.wordTOpdf();
    }
}
