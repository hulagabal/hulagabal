package seleniumWebdriver;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Test444 {
	private static String data[][] = null;

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void test444() {
		Assert.assertTrue(false);
	}

	@Test
	public void checkLogins(String uname, String pass) {
		System.out.println(uname + " " + pass);
	}

	public static String[][] dateProvider() {
		
		try {
			@SuppressWarnings("resource")
			HSSFWorkbook workbook = new HSSFWorkbook(
					new FileInputStream(new File("C:\\Users\\Mitturaj.h\\Desktop\\data.xlsx")));
			Sheet sheet = workbook.getSheetAt(0);

			int row = sheet.getLastRowNum()+1;
			System.out.println(row);
			data=new String[row][2]; 
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < 2; j++) {
					data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
					

				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return data;
	}
	
	@DataProvider(name="testData")
	public static Object[][] getdata(){
		return dateProvider();
		
	}

	
}
