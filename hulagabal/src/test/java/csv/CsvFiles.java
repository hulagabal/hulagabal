package csv;

import java.io.DataInputStream;
import java.io.FileInputStream;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CsvFiles {

	private static String line;

	static int row;
	static int cols;
	static String[][] customers;

	/*
	 * Retrieve data from the CSV file and return it has String two dimensional
	 * String array
	 */
	private static String[][] getdata() throws Exception {

		String filePath = "C:\\Users\\Mitturaj.h\\Desktop\\customers.csv";

		DataInputStream dataInputStream = new DataInputStream(new FileInputStream(filePath));

		/*
		 * initialised the array and give size of the columns and rows for CSV
		 * file data
		 */
		customers = new String[2][3];
		/* ReadLine() method is deprecated now, will need to find alternative
		 for this one ;)*/
		while ((line = dataInputStream.readLine()) != null) {

			String[] data = line.split(",");

			// can find number of columns after splitting by comma
			int cols = data.length;

			for (int x = 0; x < cols; x++) {

				customers[row][x] = data[x];

			}
			// can find rows numbers by iterating the row variable ;)
			row++;

		}
		return customers;
	}

	@DataProvider(name = "data")
	public static Object[][] getdataprovider() throws Exception {
		return getdata();
	}

	@Test(dataProvider = "data")
	public void show(String fname, String lname, String city) {
		System.out.println(fname + " " + lname + " " + city);

	}
}
