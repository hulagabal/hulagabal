package log4j2;

import org.apache.logging.log4j.LogManager;

public class LogIt {
	private static final org.apache.logging.log4j.Logger LOGGER=LogManager.getLogger(LogIt.class.getName());
	
	public static void main(String[] args) {
		LOGGER.info("Loggin here");
		
		
	}

}
