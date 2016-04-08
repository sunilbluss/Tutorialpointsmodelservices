package org.bluss.tutorials.tutorialspoint.modelservices;

import java.io.IOException;

import org.bluss.tutorials.tutorialspoint.model.HomeModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bluss.tutorials.tutorialspoint.utilitymodelservices.HomeModelUtilityServices;

public class HomeModelService {

	private HomeModelUtilityServices homeModelUtilServices;

	public HomeModel getMeHomeModelFor(String url) {
		Document doc;
		try {
			homeModelUtilServices = new HomeModelUtilityServices();
			doc = Jsoup.connect(url).timeout(0)
					.ignoreContentType(true).get();
			HomeModel homeModel = homeModelUtilServices.giveMeHomeModel(doc);
			return homeModel;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
