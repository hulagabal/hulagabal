package threads;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Watch1 {
	
	public static void main(String[] args) throws InterruptedException {
		
		while(true){
			
			String date=new SimpleDateFormat("hh:mm:ss").format(new Date());
			System.out.print("\r"+date);
			Thread.sleep(1000);
		}
		
	}

}
