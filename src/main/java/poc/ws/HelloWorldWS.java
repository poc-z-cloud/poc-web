package poc.ws;

import java.util.Calendar;
import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService (targetNamespace="http://ws.poc/", serviceName="HelloWorldService", portName="HelloWorldPort")
public class HelloWorldWS {

	@WebMethod()
	public String sayHello(String name){
		return "Hello, " + name;
	}
	
	@WebMethod()
	public Date sayNextDay(Date currentDate){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		
		return calendar.getTime();
	}

}
