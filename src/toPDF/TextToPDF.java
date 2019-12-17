/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toPDF;



import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.*;
/** 
 *
 * @author pipegoods
 */
public class TextToPDF {
    public static void TextToPDF(String Texto) {
        try{
      InputStreamReader in= new InputStreamReader(System.in);
      BufferedReader bin= new BufferedReader(in);
        Document document = new Document(PageSize.A4, 36, 72, 108, 180);
        PdfWriter.getInstance(document,new FileOutputStream("pdfFile.pdf"));
        document.open();
        document.add(new Paragraph(Texto));
        System.out.println("Text is inserted into pdf file");
        document.close();
    }catch(Exception e){}
    }
}
