package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pojos.Language;
import services.LanguagesService;

@Controller
public class LanguagesController {

	@Autowired
	LanguagesService languagesService;
	
	@RequestMapping(value = "insertLocale.ds", method = RequestMethod.POST)
	public String insertLocale(@RequestParam("lid") int lid,@RequestParam("locale") String locale,@RequestParam("lang") String lang, Model model) throws Exception {

		int success = 0;
		try {
			Language language = new Language(lid,locale,lang);
			success = languagesService.insertLocale(language);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("languageRowsAffected", success);
		return "Insert_Locale";
	}
	
	@RequestMapping(value = "deleteLocale.ds", method = RequestMethod.POST)
	public String deleteLocale(@RequestParam("lid") int lid, Model model) throws Exception {

		int success = 0;
		try {
			Language language = new Language(lid);
			success = languagesService.deleteLocale(language);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("deletedLanguageRowsAffected", success);
		return "Delete_Locale";
	}
	
}
