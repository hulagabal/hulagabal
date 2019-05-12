package selenium;

import java.io.File;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class MyDataProvider {

	static String[][] data;

	@DataProvider(name = "mydata")
	public static Object[][] supplyData() throws Exception {
		return getdata();

	}

	private static String[][] getdata() throws Exception {
		Workbook workbook = WorkbookFactory.create(new File("C:\\Users\\Mitturaj.h\\Desktop\\data - Copy.xls"));

		Sheet sheet = workbook.getSheetAt(0);

		int rows = sheet.getLastRowNum() + 1;
		System.out.println("Number of Rows in the XLS sheet " + rows);

		int cols = sheet.getRow(0).getLastCellNum();
		System.out.println("Number of columns in the XLS sheet " + cols);

		data = new String[rows][cols];

		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < cols; y++) {
				DataFormatter formatter = new DataFormatter();
				String user = formatter.formatCellValue(sheet.getRow(x).getCell(y));
				System.out.println(user);

				// Store them in the 2D array
				data[x][y] = user;
			}
		}
		// Return 2D array
		return data;

	}

	public static void main(String[] args) throws Exception {
		getdata();
	}
}
