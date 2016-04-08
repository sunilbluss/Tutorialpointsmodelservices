package org.bluss.tutorials.tutorialspoint.tutorialpointsmodelservices;

import org.bluss.tutorials.tutorialspoint.model.HomeModel;
import org.bluss.tutorials.tutorialspoint.modelservices.HomeModelService;

import com.SerializerAndDecerializer.JsonSerialDecerial;

public class HomeModelSerivceTest {
	
	public static void main(String [] args){
		HomeModelService homeModelService = new HomeModelService();
		HomeModel homeModel = homeModelService.getMeHomeModelFor("http://www.tutorialspoint.com");
		
		JsonSerialDecerial jsonSD = new JsonSerialDecerial();
		String serializedPersonString = jsonSD.writeObjectToSerializedString(homeModel);
		System.out.println(serializedPersonString);
		
	}
}
