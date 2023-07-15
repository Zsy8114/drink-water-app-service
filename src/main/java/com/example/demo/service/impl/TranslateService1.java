package com.example.demo.service.impl;

import com.documents4j.api.DocumentType;
import com.documents4j.api.IConverter;
import com.documents4j.job.LocalConverter;
import com.example.demo.service.ITranslateServce;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * @author :songyuan.zheng
 * @date :  2023/7/1 23:33
 */
@Service
public class TranslateService1 implements ITranslateServce {
    @Override
    public void wordTOpdf()  {

        String wordUrl = "D:\\word";
        File file = new File(wordUrl);
        // 检查文件夹是否存在
        if (file.exists() && file.isDirectory()) {
            //如果存在则获取文件夹的所有文件
            File[] files = file.listFiles();
            //遍历文件列表，获取word文件
            if (files != null) {
                for (File file1 : files) {

                    // 检查文件是否是Word文件（根据文件扩展名）
                    if (file1.isFile() && file1.getName().contains(".doc")) {
                        try {
                            System.out.println("文件为+++++++++"+file1.getName());
                            InputStream docxInputStream = null;
                            OutputStream outputStream = null;
                            System.out.println("word地址为++++++"+file1.getPath());
                            docxInputStream = new FileInputStream(file1.getPath());
                            //转化为pdf
                            String result=file1.getName().substring(0, file1.getName().indexOf("."));
                            String pdfUrl = "D:\\pdf\\"+result+".pdf";
                            File file2 = new File(pdfUrl);
                            if (!file2.getParentFile().exists()) {
                                file2.getParentFile().mkdir();
                            }
                            if (file2.exists()) {
                                file2.delete();
                            }
                            outputStream = new FileOutputStream(pdfUrl);
                            IConverter converter = LocalConverter.builder().build();
                            converter.convert(docxInputStream)
                                    .as(DocumentType.DOCX)
                                    .to(outputStream)
                                    .as(DocumentType.PDF).execute();
                            System.out.println("转化成功+++++++++++");
                            //关闭
                            converter.shutDown();
                            // 关闭
                            outputStream.close();
                            // 关闭
                            docxInputStream.close();
                        } catch (Exception e) {
                            System.out.println("[documents4J] word转pdf失败:" + e.toString());
                        }

                    }
                }
            }
        }
    }

    @Override
    public void pdfTOword() {
        String pdfUrl = "D:\\pdf";
        File file = new File(pdfUrl);
        // 检查文件夹是否存在
        if (file.exists() && file.isDirectory()) {
            //如果存在则获取文件夹的所有文件
            File[] files = file.listFiles();
            //遍历文件列表，获取word文件
            if (files != null) {
                for (File file1 : files) {

                    // 检查文件是否是pdf文件（根据文件扩展名）
                    if (file1.isFile() && file1.getName().contains(".pdf")) {
                        try {
                            System.out.println("文件为+++++++++"+file1.getName());
                            PDDocument document = PDDocument.load(file1);
                            System.out.println("pdf地址为++++++"+file1.getPath());
                            // 使用PDFTextStripper类从PDF中提取文本
                            PDFTextStripper pdfTextStripper = new PDFTextStripper();
                            String pdfText = pdfTextStripper.getText(document);
                            //转化为word
                            // 创建一个新的Word文档
                            String result=file1.getName().substring(0, file1.getName().indexOf("."));
                            String wordUrl = "D:\\word\\"+result+".doc";
                            File file2 = new File(wordUrl);
                            if (!file2.getParentFile().exists()) {
                                file2.getParentFile().mkdir();
                            }
                            if (file2.exists()) {
                                file2.delete();
                            }
                            XWPFDocument wordDocument = new XWPFDocument();
                            FileOutputStream outputStream = new FileOutputStream(wordUrl);
                            // 使用XWPFDocument类将提取的文本写入Word文档
                            XWPFParagraph paragraph = wordDocument.createParagraph();
                            XWPFRun run = paragraph.createRun();
                            run.setText(pdfText);
                            // 将Word文档写入输出流
                            wordDocument.write(outputStream);
                            wordDocument.close();
                            // 关闭资源
                            outputStream.close();
                            document.close();
                            System.out.println("PDF转换为Word成功！");
                        } catch (Exception e) {
                            System.err.println("PDF转换为Word时发生错误: " + e.getMessage());
                        }
                    }



                }
            }
        }
    }

}
