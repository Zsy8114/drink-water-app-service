package com.example.demo.controller;

import com.example.demo.service.ITranslateServce;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author :songyuan.zheng
 * @date :  2023/7/1 14:50
 */
@RestController
@RequestMapping("translate")
public class TranslateController {
    private final ITranslateServce iWordTOpdfServce;

    public TranslateController (ITranslateServce iWordTOpdfServce) {
        this.iWordTOpdfServce = iWordTOpdfServce;
    }


    @PostMapping("word-to-pdf")
    public void setiWordTOpdfServce() throws IOException {
        iWordTOpdfServce.wordTOpdf();
    }


    @PostMapping("pdf-to-word")
    public void setipdfTOwordServce()  {
        iWordTOpdfServce.pdfTOword();
    }
}
