package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pojos.Language;
import pojos.Method;
import pojos.TranslatedMethod;
import services.MethodsService;

@Controller
public class MethodsController {

	@Autowired
	MethodsService methodsService;

	@RequestMapping(value = "insertMethod.ds", method = RequestMethod.POST)
	public String insertMethod(@RequestParam("mid1") int mid, Model model) throws Exception {

		int success = 0;
		try {
			Method method = new Method(mid);
			success = methodsService.insertMethod(method);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("methodRowsAffected", success);
		return "Insert_Method";
	}

	@RequestMapping(value = "insertTranslatedMethod.ds", method = RequestMethod.POST)
	public String insertTraslatedMethod(@RequestParam("tmid") int tmid, @RequestParam("mid2") int mid,
			@RequestParam("loc") String loc, @RequestParam("mname") String mname, Model model) throws Exception {

		int success = 0;
		try {
			Method method = new Method(mid);
			Language locale = new Language(loc);
			TranslatedMethod translatedMethod = new TranslatedMethod(tmid,locale,method,mname);
			success = methodsService.insertTranslatedMethod(translatedMethod);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("translatedMethodRowsAffected", success);
		return "Insert_Method";
	}
	
	@RequestMapping(value = "deleteMethod.ds", method = RequestMethod.POST)
	public String deleteMethod(@RequestParam("mid") int mid, Model model) throws Exception {

		int success = 0;
		try {
			Method method = new Method(mid);
			success = methodsService.deleteMethod(method);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("deletedMethodRowsAffected", success);
		return "Delete_Method";
	}
	
	@RequestMapping(value = "deleteTranslatedMethod.ds", method = RequestMethod.POST)
	public String deleteTranslatedMethod(@RequestParam("tmid") int tmid, Model model) throws Exception {

		int success = 0;
		try {
			TranslatedMethod translatedMethod = new TranslatedMethod(tmid);
			success = methodsService.deleteTranslatedMethod(translatedMethod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("deletedTranslatedMethodRowsAffected", success);
		return "Delete_Method";
	}
	
}
