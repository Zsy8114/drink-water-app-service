package com.example.demo.service;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author :songyuan.zheng
 * @date :  2023/7/1 14:07
 */
public interface ITranslateServce {
    void wordTOpdf() throws IOException;

    void pdfTOword();
}
