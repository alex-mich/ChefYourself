package controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

			currentCid = curcid.equals("") ? 0 : Integer.parseInt(curcid);
			updatedCid = newcid.equals("") ? 0 : Integer.parseInt(newcid);
			
			currentTcid = curtcid.equals("") ? 0 : Integer.parseInt(curtcid);
			updatedTcid = newtcid.equals("") ? 0 : Integer.parseInt(newtcid);

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
	
	@RequestMapping("/viewCuisinesTable.ds")
	public ModelAndView viewCuisinesTable(Model model) {
		List<Cuisine> cuisinesList = new ArrayList<Cuisine>();
		try {
			cuisinesList = cuisinesService.viewCuisinesTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("tableName", "Cuisines Table");
		model.addAttribute("columnName", "Cuisine ID");
		return new ModelAndView("ViewCuisinesTable", "cuisinesList", cuisinesList);
	}
	
	@RequestMapping("/viewTranslatedCuisinesTable.ds")
	public ModelAndView viewTranslatedCuisinesTable(Model model) {
		List<TranslatedCuisine> translatedCuisinesList = new ArrayList<TranslatedCuisine>();
		try {
			translatedCuisinesList = cuisinesService.viewTranslatedCuisinesTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("tableName", "Translated Cuisines Table");
		model.addAttribute("columnName1", "Translated Cuisine ID");
		model.addAttribute("columnName2", "Cuisine ID");
		model.addAttribute("columnName3", "Locale");
		model.addAttribute("columnName4", "Cuisine Name");
		return new ModelAndView("ViewTranslatedCuisinesTable", "translatedCuisinesList", translatedCuisinesList);
	}
}
