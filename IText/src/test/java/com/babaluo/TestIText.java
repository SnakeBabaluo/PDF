package com.babaluo;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
/**
 * 创建日期 : 2020/11/2 17:43
 */
public class TestIText {

    @Test
    public void testIText() throws Exception{
        //创建文件对象
        Document doc = new Document();

        //设置文件储存路径
        //指定路径
        File file = new File("g:\\ITex.pdf");
        //路径放入字节输出流内
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        //指定文件对象和要保存的位置
        PdfWriter.getInstance(doc, fileOutputStream);

        //打开文档
        doc.open();

        //写入内容
        BaseFont ch = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        doc.add(new Paragraph("解决中文乱码,使用宋体",new Font(ch)));
        //doc.add(new Paragraph("Hello World"));

        //关闭文档
        doc.close();

    }
}
