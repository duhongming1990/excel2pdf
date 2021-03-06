package com.github.caryyu.excel2pdf.bean;

import com.itextpdf.text.FontFactory;
import com.itextpdf.text.FontFactoryImp;
import com.itextpdf.text.pdf.BaseFont;
import org.apache.poi.xssf.usermodel.XSSFFont;

/**
 * Created by cary on 6/15/17.
 */
public class Resource {
    /**
     * 中文字体支持
     */
   protected static BaseFont BASE_FONT_CHINESE;
    static {
        try {
            BASE_FONT_CHINESE = BaseFont.createFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            // 搜尋系統,載入系統內的字型(慢)
           FontFactory.registerDirectories();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 將 POI Font 轉換到 iText Font
     * @param font
     * @return
     */
    public static com.itextpdf.text.Font getFont(XSSFFont font) {
    	try {
//            com.itextpdf.text.Font iTextFont =FontFactory.getFont(font.getFontName(), BaseFont.IDENTITY_H, BaseFont.EMBEDDED,font.getFontHeightInPoints());
    		//防止linux系统没有宋体，导致PDF的字体乱码或者空白
            com.itextpdf.text.Font iTextFont =FontFactory.getFont("STSongStd-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED,font.getFontHeightInPoints());
    		return iTextFont;
        } catch (Exception e) {
            e.printStackTrace();
        }
    	return null;
    }
}