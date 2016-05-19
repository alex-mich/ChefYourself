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
			TranslatedMethod translatedMethod = new TranslatedMethod(tmid,method,locale,mname);
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
	
	@RequestMapping(value = "updateMethod.ds", method = RequestMethod.POST)
	public String updateMethod(@RequestParam("curmid1") String curmid, @RequestParam("newmid1") String newmid,
			Model model) throws Exception {
		int currentMid, updatedMid;
		int success = 0;
		try {

			if (curmid.equals("")) {
				currentMid = 0;
			} else
				currentMid = Integer.parseInt(curmid);

			if (newmid.equals("")) {
				updatedMid = 0;
			} else
				updatedMid = Integer.parseInt(newmid);

			Method currentMethod = new Method(currentMid);
			Method updatedMethod = new Method(updatedMid);
			success = methodsService.updateMethod(currentMethod, updatedMethod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("updatedMethodRowsAffected", success);
		return "Update_Method";
	}

	@RequestMapping(value = "updateTranslatedMethod.ds", method = RequestMethod.POST)
	public String updateTranslatedMethod(@RequestParam("curtmid") String curtmid,
			@RequestParam("curmid2") String curmid, @RequestParam("curloc") String curloc,
			@RequestParam("curmname") String curmname, @RequestParam("newtmid") String newtmid,
			@RequestParam("newmid2") String newmid,@RequestParam("newloc") String newloc,
			@RequestParam("newmname") String newmname, Model model) throws Exception {
		
		int currentMid, updatedMid, currentTmid, updatedTmid;
		int success = 0;
		try {

			if (curmid.equals("")) {
				currentMid = 0;
			} else
				currentMid = Integer.parseInt(curmid);

			if (newmid.equals("")) {
				updatedMid = 0;
			} else
				updatedMid = Integer.parseInt(newmid);
			
			if (curtmid.equals("")) {
				currentTmid = 0;
			} else
				currentTmid = Integer.parseInt(curtmid);

			if (newtmid.equals("")) {
				updatedTmid = 0;
			} else
				updatedTmid = Integer.parseInt(newtmid);

			Method currentMethod = new Method(currentMid);
			Language currentLocale = new Language(curloc);
			TranslatedMethod currentTranslatedMethod = new TranslatedMethod(currentTmid,currentMethod,currentLocale,curmname);
			
			Method updatedMethod = new Method(updatedMid);
			Language updatedLocale = new Language(newloc);
			TranslatedMethod updatedTranslatedMethod = new TranslatedMethod(updatedTmid,updatedMethod,updatedLocale,newmname);
			
			success = methodsService.updateTranslatedMethod(currentTranslatedMethod, updatedTranslatedMethod);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("updatedTranslatedMethodRowsAffected", success);
		return "Update_Method";
	}
	
	@RequestMapping("/viewMethodsTable.ds")
	public ModelAndView viewMethodsTable(Model model) {
		List<Method> methodsList = new ArrayList<Method>();
		try {
			methodsList = methodsService.viewMethodsTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("tableName", "Methods Table");
		model.addAttribute("columnName", "Method ID");
		return new ModelAndView("ViewMethodsTable", "methodsList", methodsList);
	}
	
	@RequestMapping("/viewTranslatedMethodsTable.ds")
	public ModelAndView viewTranslatedCuisinesTable(Model model) {
		List<TranslatedMethod> translatedMethodsList = new ArrayList<TranslatedMethod>();
		try {
			translatedMethodsList = methodsService.viewTranslatedMethodsTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("tableName", "Translated Methods Table");
		model.addAttribute("columnName1", "Translated Method ID");
		model.addAttribute("columnName2", "Method ID");
		model.addAttribute("columnName3", "Locale");
		model.addAttribute("columnName4", "Method Name");
		return new ModelAndView("ViewTranslatedMethodsTable", "translatedMethodsList", translatedMethodsList);
	}
	
}
