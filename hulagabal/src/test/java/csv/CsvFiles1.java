package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CsvFiles1 {
	static String filePath = "C:\\Users\\Mitturaj.h\\Desktop\\customers.csv";
	static BufferedReader bufferedReader = null;

	static String line = "";
	static String[][] players;
	static int rows = 0;

	private static String[][] getdata() {
		try {
			players = new String[2][3];
			bufferedReader = new BufferedReader(new FileReader(filePath));
			while ((line = bufferedReader.readLine()) != null) {

				String[] country = line.split(",");

				// this will determine number of columns in the csv file after
				// spitting by commas
				System.out.println("Number columns " + country.length);
				for (int x = 0; x < country.length; x++) {
					players[rows][x] = country[x];

				}

				System.out.println(country[1]);
				rows++;

			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {

				e.printStackTrace();
			}
		}
		System.out.println("number of the rows in the columns " + rows);
		return players;

	}

	@DataProvider(name = "data")
	public static Object[][] getPlayers() {
		return getdata();

	}

	@Test(dataProvider = "data")
	public void testPlayers(String fname, String lname, String country) {
		System.out.println(fname + " " + lname + " " + country);

	}
}
