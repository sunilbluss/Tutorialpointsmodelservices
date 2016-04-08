package com.bluss.tutorials.tutorialspoint.utilitymodelservices;

import java.util.ArrayList;
import java.util.List;

import org.bluss.tutorials.tutorialspoint.model.HomeModel;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.bluss.tutorials.tutorialspoint.utilitymodel.Hiperlink;
import com.bluss.tutorials.tutorialspoint.utilitymodel.OneTech;

public class HomeModelUtilityServices {
	
	public Elements giveMeFeaturedBoxs(Document doc){
		Elements allFeaturedBox = doc.select(".featured-boxes  .featured-box");
		return allFeaturedBox;
	}
	

	public List<Hiperlink> giveMeSetOfHiperLinks(Element elements){
		List<Hiperlink> orderedHiperLinkArray = new ArrayList<Hiperlink>();
		for(Element linkI: elements.children()){
			Element actualLink = linkI.select("a").get(0);
			Hiperlink hipLik = new Hiperlink();
			hipLik.setLink(actualLink.attr("href").toString());
			hipLik.setDesc(actualLink.html().replace("Learn", ""));
			orderedHiperLinkArray.add(hipLik);
		}
		return orderedHiperLinkArray;
	}
	
	public HomeModel giveMeHomeModel(Document doc){
		HomeModel homeModel = new HomeModel();
		Elements allFeaturedBox = giveMeFeaturedBoxs(doc);
		List<OneTech> listOfAllTech = new ArrayList<OneTech>();
		for (Element ele : allFeaturedBox) {
			Elements featuredChilderen = ele.children();
			for(int i=0;i<featuredChilderen.size();i++){
				OneTech oneTech = new OneTech();
				Element title = featuredChilderen.get(i);
				oneTech.setTitle(title.html());
				oneTech.setLinkAndDesc(giveMeSetOfHiperLinks(featuredChilderen.get(++i)));
				listOfAllTech.add(oneTech);
			}
		}
		homeModel.setListOfTech(listOfAllTech);
		return homeModel;
	}
}
