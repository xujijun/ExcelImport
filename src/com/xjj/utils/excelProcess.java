package com.xjj.utils;

import java.io.IOException;

import javax.servlet.ServletInputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class excelProcess {
	public static String process(ServletInputStream is) throws IOException{
		String result = "";
		
		byte[]   junk   =   new   byte[1024];   

		int   bytesRead   =   0;   

		//读取文件流  ，必须先读4次 ，去除is的流的header信息去掉，否则会报错和乱码 
		for(int x=0;x<4;x++){  
		   bytesRead   =   is.readLine(junk, 0, junk.length);   
		}   

		//生成Excel表
		HSSFWorkbook workbook     = new HSSFWorkbook(is);
		//获取第一个工作簿
		HSSFSheet sheet = workbook.getSheetAt(0);		
		//总行数
		int rows=sheet.getPhysicalNumberOfRows();
		
		//要导入的字段
		double number=0;
		String clazz=null;
		String name=null;
		String gender=null;
		
		for (int i = 1; i < rows; i++) {
			HSSFRow row = sheet.getRow(i);
			//判断是否还需要导入数据
			if (row == null) {
				break;
			}
		
			//读取字段，根据excel表调整
			
			//读取第1个字段:班级
			if(row.getCell(1)!=null){
				double c = row.getCell(1).getNumericCellValue();
				clazz = String.format("%2.0f", c).trim();
				//clazz = row.getCell(1).getRichStringCellValue().toString().trim();// .getStringCellValue().trim();
			}
			
			//读取第2个字段:座位号
			if(row.getCell(3)!=null){
				number = row.getCell(3).getNumericCellValue();
				//String string =row.getCell(1).getStringCellValue();
			}
			
			//读取第3个字段:姓名
			if(row.getCell(2)!=null){
				name = row.getCell(2).getStringCellValue().replace('*', ' ').trim();
			}
			
			//读取第4个字段:性别
			if(row.getCell(4)!=null){
				gender = row.getCell(4).getStringCellValue().trim();
			}
			
			String s = String.format("INSERT INTO `schoolmate` (name, class, number, gender) VALUES ('%s', '92(%s)', %10.0f, '%s');", name, clazz, number, gender);
			
			//System.out.println(s);
			result += s + "<br>";
		}	
		
		return result;
	}
}
