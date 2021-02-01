package demo.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo {
	 private static Logger logger = LogManager.getLogger(Demo.class);
	public static void main(String[] args) 
	{
		System.out.println("Started");
		logger.info("This is Information Logger");
		logger.error("This is Error Logger");
		logger.warn("This is Warn Logger");
		logger.fatal("This Fatal logger");
		logger.debug("This is Debug Logger");
		System.out.println("Ended");
		
	}

}
