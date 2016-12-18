package com.venolabs.mietwagen.bo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * fabrica de business objects
 * @author sergio
 *
 */
public class BOFactory {

	private BOFactory() {}
	
	private static ApplicationContext appContext = 
	    	  new ClassPathXmlApplicationContext("config/BeanLocations.xml");
	
	public static CarBO carBO() {
		return (CarBO)appContext.getBean("carBo");
	}
	
	public static ClientBO clientBO() {
		return (ClientBO)appContext.getBean("clientBo");
	}
	
	public static RentBO rentBO() {
		return (RentBO)appContext.getBean("rentBo");
	}
}
