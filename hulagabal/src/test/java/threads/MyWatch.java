package threads;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MyWatch {

	
	public static void main(String[] args) {
		
		Thread thread=new Thread(new Watch());
		thread.start();
	}
}

class Watch implements Runnable {
	 DateFormat formate;
	 Calendar cal;
	 String time;

	 public void show() throws IOException {
		
		
		System.out.print("\r"+time);
		
		
	 }

	 
	 public void run() {
	  try {
	   while (true) {

	    new GregorianCalendar();
	    cal = Calendar.getInstance();

	    formate = new SimpleDateFormat("hh:mm:ss");
	    Date date = cal.getTime();
	    time = formate.format(date);
	    show();
	    Thread.sleep(1000);
	   }
	  } catch (Exception e) {
	   e.getMessage();
	  }

	 }

	} 