package io.util.testdata;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestDataUtilityClass 
{
	
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	public static String TestData_Sheet_Path="/home/qapitol/Automation/dataprovider.io/TestData-DP/DP.xlsx";

	
	
	//Method for fetching testdata from excel sheet using testNG data provider
	public static Object[][] getTestData(String sheetname)
	{
		try
		{
			book= WorkbookFactory.create(new FileInputStream(TestData_Sheet_Path));
				
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		sheet=book.getSheet(sheetname);
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int i=0; i<sheet.getLastRowNum(); i++)
		{
			for(int k=0; k<sheet.getRow(0).getLastCellNum(); k++)
			{
				data[i][k]= sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
	}
	
	
	
}
	