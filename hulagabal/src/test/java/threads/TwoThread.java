package threads;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TwoThread implements Runnable {
	SimpleDateFormat dateFormat;
	String time;

	public void show() {
		System.out.print("\r" + time);

	}

	public void run() {

		while (true) {
			try {
				dateFormat = new SimpleDateFormat("hh:mm:ss");
				time = dateFormat.format(new Date());

				show();

				Thread.sleep(1000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		Thread thread = new Thread(new TwoThread());
		thread.start();
	}
}