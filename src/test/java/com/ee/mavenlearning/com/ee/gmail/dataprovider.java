package com.ee.mavenlearning.com.ee.gmail;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class dataprovider {
	@DataProvider
	public static Object[][] info() throws IOException{
		
		Data_fetching df = new Data_fetching("G:/selenium/com.ee.gmail/sheet1.xls");
		int row =df.row_no(0);
	//	row=row+1;
		Object[][] data = new Object[row][2];
		//int i=0;
		for( int i=0;i<row;i++){
			// i=1;
			data[i][0]=df.get_data(0, i, 0);
			data[i][1]=df.get_data(0, i, 1);
		//	data[i][2]=df.get_data(0, i, 2);
			
		}
		
		return data;
		
		
		
	}
	@DataProvider
	public static Object[][] compse_msg() throws IOException{
		
		Data_fetching df = new Data_fetching("G:/selenium/com.ee.gmail/Book1.xls");
		int row =df.row_no(0);
	//	row=row+1;
		Object[][] data = new Object[row][5];
		//int i=0;
		for( int i=0;i<row;i++){
			// i=1;
			data[i][0]=df.get_data(0, i, 0);
			data[i][1]=df.get_data(0, i, 1);
		data[i][2]=df.get_data(0, i, 2);
		data[i][3]=df.get_data(0, i, 3);
		data[i][4]=df.get_data(0, i, 4);
			
		}
		
		return data;
		
		
		
	}

}
