package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.src.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT=300;
	public static long IMPLICIT_WAIT=60;
	String data[][]=new String[3][5];
	String s1;
	public void Switchfram()
	{
		 driver.switchTo().frame("mainpanel");
	}
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	
	
	
	
@DataProvider(name="excelData")
	public String[][] excelDataRead() throws Exception
	{
		File f=new File("C:\\Users\\new\\eclipse-workspace\\AutomationTest\\src\\main\\java\\com\\crm\\qa\\testdata\\CRM_Test_data.xlsx");
		FileInputStream fis=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);

		for(int i=0;i<3;i++) {
			for (int j=0;j<5;j++) {
				String s1=sheet.getRow(i).getCell(j).getStringCellValue();
				data[i][j]=s1;
			}
		}
		for(int i=0;i<3;i++) {
			for (int j=0;j<5;j++) {
				//String s1=sheet.getRow(i).getCell(j).getStringCellValue();
				 System.out.print( data[i][j]);
				 }
			System.out.println();
			}
			
			
		
		wb.close();
		return data;
		
		}
		/*
		 * @Test(enabled=false) public void excelTest() throws Exception { String path =
		 * "C:\\Users\\new\\eclipse-workspace\\AutomationTest\\src\\main\\java\\com\\crm\\qa\\testdata\\CRM_Test_data.xlsx";
		 * FileInputStream fs = new FileInputStream(path);
		 * 
		 * XSSFWorkbook wb = new XSSFWorkbook(fs); XSSFSheet sheet1 = wb.getSheetAt(0);
		 * int lastRow = sheet1.getLastRowNum();
		 * 
		 * int column=sheet1.getRow(0).getLastCellNum(); for(int i=0; i<=lastRow; i++){
		 * for(int j=0;j<column;j++) {
		 * 
		 * 
		 * //String m=sheet1.getRow(i).getCell(j).getStringCellValue();
		 * //cell.setCellValue("WriteintoExcel");
		 * 
		 * System.out.println();
		 * 
		 * } System.out.println(); } FileOutputStream fos = new FileOutputStream(path);
		 * wb.write(fos); fos.close(); }
		 */
}

