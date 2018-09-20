package com.github.caryyu.excel2pdf;

import com.github.caryyu.excel2pdf.bean.Excel2Pdf;
import com.github.caryyu.excel2pdf.bean.ExcelObject;
import com.github.caryyu.excel2pdf.util.ConvertUtil;
import com.github.caryyu.excel2pdf.util.WaterPrintUtil;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author duhongming
 * @Email 19919902414@189.cn
 * @Date 2018/9/13 11:42
 */
public class PDFTest {

    @Test
    public void test() throws Exception{
        String pathOfXls = "src/test/resources/营业厅信息.xlsx";
        FileOutputStream fileOutputStream = new FileOutputStream(new File("target/output/营业厅信息.pdf"));

        OutputStream fos = new ByteArrayOutputStream();
        List<ExcelObject> objects = new ArrayList<ExcelObject>();
        objects.add(new ExcelObject("anchorName",new FileInputStream(pathOfXls)));
        Excel2Pdf pdf = new Excel2Pdf(objects, fos);
        pdf.convert();

        WaterPrintUtil.waterMark(new ConvertUtil().parse(fos),fileOutputStream, "00203219\n0601\n158143024杜\n20180917102134");
    }
}