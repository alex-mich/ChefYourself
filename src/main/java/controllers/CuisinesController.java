package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pojos.Cuisine;
import pojos.Language;
import pojos.TranslatedCuisine;
import services.CuisinesService;

@Controller
public class CuisinesController {

	@Autowired
	CuisinesService cuisinesService;

	@RequestMapping(value = "insertCuisine.ds", method = RequestMethod.POST)
	public String insertCuisine(@RequestParam("cid1") int cid, Model model) throws Exception {

		int success = 0;
		try {
			Cuisine cuisine = new Cuisine(cid);
			success = cuisinesService.insertCuisine(cuisine);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("cuisineRowsAffected", success);
		return "Insert_Cuisine";
	}

	@RequestMapping(value = "insertTranslatedCuisine.ds", method = RequestMethod.POST)
	public String insertTraslatedCuisine(@RequestParam("tcid") int tcid, @RequestParam("cid2") int cid,
			@RequestParam("loc") String loc, @RequestParam("cname") String cname, Model model) throws Exception {

		int success = 0;
		try {
			Cuisine cuisine = new Cuisine(cid);
			Language locale = new Language(loc);
			TranslatedCuisine translatedCuisine = new TranslatedCuisine(tcid, cuisine, locale, cname);
			success = cuisinesService.insertTranslatedCuisine(translatedCuisine);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("translatedCuisineRowsAffected", success);
		return "Insert_Cuisine";
	}

	@RequestMapping(value = "deleteCuisine.ds", method = RequestMethod.POST)
	public String deleteCuisine(@RequestParam("cid") int cid, Model model) throws Exception {

		int success = 0;
		try {
			Cuisine cuisine = new Cuisine(cid);
			success = cuisinesService.deleteCuisine(cuisine);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("deletedCuisineRowsAffected", success);
		return "Delete_Cuisine";
	}

	@RequestMapping(value = "deleteTranslatedCuisine.ds", method = RequestMethod.POST)
	public String deleteTranslatedCuisine(@RequestParam("tcid") int tcid, Model model) throws Exception {

		int success = 0;
		try {
			TranslatedCuisine translatedCuisine = new TranslatedCuisine(tcid);
			success = cuisinesService.deleteTranslatedCuisine(translatedCuisine);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("deletedTranslatedCuisineRowsAffected", success);
		return "Delete_Cuisine";
	}

	@RequestMapping(value = "updateCuisine.ds", method = RequestMethod.POST)
	public String updateCuisine(@RequestParam("curcid1") String curcid, @RequestParam("newcid1") String newcid,
			Model model) throws Exception {
		int currentCid, updatedCid;
		int success = 0;
		try {

			if (curcid.equals("")) {
				currentCid = 0;
			} else
				currentCid = Integer.parseInt(curcid);

			if (newcid.equals("")) {
				updatedCid = 0;
			} else
				updatedCid = Integer.parseInt(newcid);

			Cuisine currentCuisine = new Cuisine(currentCid);
			Cuisine updatedCuisine = new Cuisine(updatedCid);
			success = cuisinesService.updateCuisine(currentCuisine, updatedCuisine);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("updatedCuisineRowsAffected", success);
		return "Update_Cuisine";
	}

	@RequestMapping(value = "updateTranslatedCuisine.ds", method = RequestMethod.POST)
	public String updateTranslatedCuisine(@RequestParam("curtcid") String curtcid,
			@RequestParam("curcid2") String curcid, @RequestParam("curloc") String curloc,
			@RequestParam("curcname") String curcname, @RequestParam("newtcid") String newtcid,
			@RequestParam("newcid2") String newcid,@RequestParam("newloc") String newloc,
			@RequestParam("newcname") String newcname, Model model) throws Exception {
		
		int currentCid, updatedCid, currentTcid, updatedTcid;
		int success = 0;
		try {

			if (curcid.equals("")) {
				currentCid = 0;
			} else
				currentCid = Integer.parseInt(curcid);

			if (newcid.equals("")) {
				updatedCid = 0;
			} else
				updatedCid = Integer.parseInt(newcid);
			
			if (curtcid.equals("")) {
				currentTcid = 0;
			} else
				currentTcid = Integer.parseInt(curtcid);

			if (newtcid.equals("")) {
				updatedTcid = 0;
			} else
				updatedTcid = Integer.parseInt(newtcid);

			Cuisine currentCuisine = new Cuisine(currentCid);
			Language currentLocale = new Language(curloc);
			TranslatedCuisine currentTranslatedCuisine = new TranslatedCuisine(currentTcid,currentCuisine,currentLocale,curcname);
			
			Cuisine updatedCuisine = new Cuisine(updatedCid);
			Language updatedLocale = new Language(newloc);
			TranslatedCuisine updatedTranslatedCuisine = new TranslatedCuisine(updatedTcid,updatedCuisine,updatedLocale,newcname);
			
			success = cuisinesService.updateTranslatedCuisine(currentTranslatedCuisine, updatedTranslatedCuisine);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("updatedTranslatedCuisineRowsAffected", success);
		return "Update_Cuisine";
	}
}
