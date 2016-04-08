package org.bluss.tutorials.tutorialspoint.tutorialpointsmodelservices;

import org.bluss.tutorials.tutorialspoint.model.HomeModel;
import org.bluss.tutorials.tutorialspoint.model.TutDetailModel;
import org.bluss.tutorials.tutorialspoint.modelservices.TutDetailModelService;

import com.SerializerAndDecerializer.JsonSerialDecerial;

public class TutModelSerivceTest {
	
	public static void main(String [] args){
		TutDetailModelService tutService = new TutDetailModelService();
		TutDetailModel tutModel = tutService.getMeTutDetailModelFor("http://www.tutorialspoint.com/ajax/ajax_database.htm");
		JsonSerialDecerial jsonSD = new JsonSerialDecerial();
		String serializedPersonString = jsonSD.writeObjectToSerializedString(tutModel);
		System.out.println(serializedPersonString);
		
	}
}
