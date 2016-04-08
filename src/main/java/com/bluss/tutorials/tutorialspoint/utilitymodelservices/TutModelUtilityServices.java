package com.bluss.tutorials.tutorialspoint.utilitymodelservices;

import static com.bluss.tutorials.tutorialspointservices.constant.AppConstants.cssProp.CSS_CLASS;

import java.util.ArrayList;
import java.util.List;

import org.bluss.tutorials.tutorialspoint.model.TutDetailModel;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Tag;
import org.jsoup.select.Elements;

import com.bluss.tutorials.tutorialspoint.tututilitymodel.TutContentBar;
import com.bluss.tutorials.tutorialspoint.tututilitymodel.TutSideBar;
import com.bluss.tutorials.tutorialspoint.tututilitymodel.TutSideBarSection;
import com.bluss.tutorials.tutorialspoint.utilitymodel.Hiperlink;
import com.bluss.tutorials.tutorialspointservices.UtilityServices;

public class TutModelUtilityServices {

	public TutDetailModel giveMeTutDetailModel(Document doc) {
		UtilityServices utilServices = new UtilityServices();
		TutDetailModel tutDetailModel = new TutDetailModel();
		TutSideBar sideBar;
		TutContentBar contentBar = new TutContentBar();
		doc = removeUnnecessoryNodes(doc);
		utilServices.mediaFromTheSameSite(doc);
		doc.select(CSS_CLASS + "cover").remove();
		Element newEle = modifyAccToHerokuTheme(doc);
		sideBar  = giveMeSideBarModel(doc);
		tutDetailModel.setSideBar(sideBar);
		contentBar.setContentBar(newEle.toString());
		tutDetailModel.setContentBar(contentBar);
		
		//nav nav-list primary left-menu >
		return tutDetailModel;
	}

	private TutSideBar giveMeSideBarModel(Document doc) {
		TutSideBar tutSideBar = new TutSideBar();
		TutSideBarSection tutSideBarSec = new TutSideBarSection();
		List<Hiperlink> hipLink = new ArrayList<Hiperlink>();
		Elements sideBar = doc.select(".nav.nav-list.primary.left-menu").not(".special").select("a");
		for(int i=0;i<sideBar.size()-1;i++){
			Element el = sideBar.get(i);
			Hiperlink hplnk = new Hiperlink();
			hplnk.setDesc(el.text());
			hplnk.setLink(el.attr("href"));
			hipLink.add(hplnk);
			tutSideBarSec.setListOfHiperLinks(hipLink);
			tutSideBar.setSections(tutSideBarSec);
			// process 
		}
		System.out.println(sideBar.toString());
		return tutSideBar;
	}

	public Element modifyAccToHerokuTheme(Document doc) {
		Elements elementsh1 = doc.select("h1");
		Elements elementsh2 = doc.select("h2");
		Elements elementsh3 = doc.select("h3");
		Elements elementsh4 = doc.select("h4");
		elementsh1.tagName("h2");
		elementsh2.tagName("h3");
		elementsh3.tagName("h4");
		elementsh4.tagName("h5");

		// replacing the pre with new type now
		Elements preEle = doc.select("pre");
		for (int i = 0; i < preEle.size(); i++) {
			Element el = preEle.get(i);
			Element replacePre = new Element(Tag.valueOf("div"), "");
			replacePre.addClass("CodeRay");
			replacePre.html("<div class=\"code\"><pre class=\"prettyprint\">"+el.html()+"</pre></div>");
			el.replaceWith(replacePre);
		}
		Elements nepreEle = doc.select("CodeRay");
		
		Element contentEle = doc.select(".col-md-7.middle-col").get(0);
		contentEle.removeClass(".col-md-7.middle-col").addClass(
				"main col-md-8 dynamic-tutorial-content content");
		//System.out.println(doc.html());
		return contentEle;
	}

	public Document removeUnnecessoryNodes(Document doc) {
		doc.select(".pre-btn").remove();
		doc.select(".nxt-btn").remove();
		doc.select(".topgooglead").remove();
		doc.select(".bottomgooglead").remove();
		doc.select(".print-btn").remove();
		doc.select(".pdf-btn").remove();
		doc.select("form").remove();
		doc.select("hr").remove();
		return doc;
	}
}
