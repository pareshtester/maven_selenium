package com.ee.mavenlearning.com.ee.gmail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class Data_fetching {
	WebDriver driver;
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	
	public Data_fetching(String src) throws IOException{
		
		File f = new File(src);
		FileInputStream fs = new FileInputStream(f);
		workbook = new HSSFWorkbook(fs);
		
		
		
		
	}
	
	public String get_data(int sheetno,int row,int col){
		sheet = workbook.getSheetAt(sheetno);
		String data =sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
		
		
	}
	public int row_no(int index){
		
		int r = workbook.getSheetAt(index).getLastRowNum();
		r = r+1;
		return r;
		
		
	}

}
