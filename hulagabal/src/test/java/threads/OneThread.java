package threads;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OneThread extends Thread {
	

	public void run() {
		while (true) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			String time = dateFormat.format(new Date());
			System.out.print("\r"+time);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
	}

}
