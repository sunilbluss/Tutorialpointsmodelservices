package org.bluss.tutorials.tutorialspoint.modelservices;

import java.io.IOException;

import org.bluss.tutorials.tutorialspoint.model.HomeModel;
import org.bluss.tutorials.tutorialspoint.model.TutDetailModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.bluss.tutorials.tutorialspoint.utilitymodelservices.HomeModelUtilityServices;
import com.bluss.tutorials.tutorialspoint.utilitymodelservices.TutModelUtilityServices;

public class TutDetailModelService {
	
	public TutDetailModel getMeTutDetailModelFor(String url){
		Document doc;
		try {
			TutModelUtilityServices tutDetailModelService = new TutModelUtilityServices();
			doc = Jsoup.connect(url).timeout(0)
					.ignoreContentType(true).get();
			TutDetailModel tutModel=tutDetailModelService.giveMeTutDetailModel(doc);
			return tutModel;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
