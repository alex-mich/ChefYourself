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

import pojos.Ingredient;
import pojos.Language;
import pojos.TranslatedIngredient;
import services.IngredientsService;

@Controller
public class IngredientsController {

	@Autowired
	IngredientsService ingredientsService;

	@RequestMapping(value = "insertIngredient.ds", method = RequestMethod.POST)
	public String insertIngredient(@RequestParam("inid1") int inid, @RequestParam("itype") String itype, Model model)
			throws Exception {

		int success = 0;
		try {
			Ingredient ingredient = new Ingredient(inid, itype);
			success = ingredientsService.insertIngredient(ingredient);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("ingredientRowsAffected", success);
		return "Insert_Ingredient";
	}

	@RequestMapping(value = "insertTranslatedIngredient.ds", method = RequestMethod.POST)
	public String insertTraslatedIngredient(@RequestParam("tinid") int tinid, @RequestParam("inid2") int inid,
			@RequestParam("loc") String loc, @RequestParam("iname") String iname, Model model) throws Exception {

		int success = 0;
		try {
			Ingredient ingredient = new Ingredient(inid);
			Language locale = new Language(loc);
			TranslatedIngredient translatedIngredient = new TranslatedIngredient(tinid, ingredient, locale, iname);
			success = ingredientsService.insertTranslatedIngredient(translatedIngredient);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("translatedIngredientRowsAffected", success);
		return "Insert_Ingredient";
	}

	@RequestMapping(value = "deleteIngredient.ds", method = RequestMethod.POST)
	public String deleteIngredient(@RequestParam("inid") int inid, Model model) throws Exception {
		int success = 0;
		try {
			Ingredient ingredient = new Ingredient(inid);
			success = ingredientsService.deleteIngredient(ingredient);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("deletedIngredientRowsAffected", success);
		return "Delete_Ingredient";
	}

	@RequestMapping(value = "deleteTranslatedIngredient.ds", method = RequestMethod.POST)
	public String deleteTranslatedIngredient(@RequestParam("tinid") int tinid, Model model) throws Exception {
		int success = 0;
		try {
			TranslatedIngredient translatedIngredient = new TranslatedIngredient(tinid);
			success = ingredientsService.deleteTranslatedIngredient(translatedIngredient);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("deletedTranslatedIngredientRowsAffected", success);
		return "Delete_Ingredient";
	}

	@RequestMapping(value = "updateIngredient.ds", method = RequestMethod.POST)
	public String updateIngredient(@RequestParam("curinid1") String curinid, @RequestParam("newinid1") String newinid,
			@RequestParam("curitype") String curitype, @RequestParam("newitype") String newitype, Model model)
			throws Exception {

		int currentInid, updatedInid;
		int success = 0;
		try {

			if (curinid.equals("")) {
				currentInid = 0;
			} else
				currentInid = Integer.parseInt(curinid);

			if (newinid.equals("")) {
				updatedInid = 0;
			} else
				updatedInid = Integer.parseInt(newinid);

			Ingredient currentIngredient = new Ingredient(currentInid,curitype);
			Ingredient updatedIngredient = new Ingredient(updatedInid,newitype);
			success = ingredientsService.updateIngredient(currentIngredient, updatedIngredient);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("updatedIngredientRowsAffected", success);
		return "Update_Ingredient";
	}

	@RequestMapping(value = "updateTranslatedIngredient.ds", method = RequestMethod.POST)
	public String updateTranslatedIngredient(@RequestParam("curtinid") String curtinid,
			@RequestParam("curinid2") String curinid, @RequestParam("curloc") String curloc,
			@RequestParam("curiname") String curiname, @RequestParam("newtinid") String newtinid,
			@RequestParam("newinid2") String newinid, @RequestParam("newloc") String newloc,
			@RequestParam("newiname") String newiname, Model model) throws Exception {

		int currentInid, updatedInid, currentTinid, updatedTinid;
		int success = 0;
		try {

			if (curinid.equals("")) {
				currentInid = 0;
			} else
				currentInid = Integer.parseInt(curinid);

			if (newinid.equals("")) {
				updatedInid = 0;
			} else
				updatedInid = Integer.parseInt(newinid);

			if (curtinid.equals("")) {
				currentTinid = 0;
			} else
				currentTinid = Integer.parseInt(curtinid);

			if (newtinid.equals("")) {
				updatedTinid = 0;
			} else
				updatedTinid = Integer.parseInt(newtinid);

			Ingredient currentIngredient = new Ingredient(currentInid);
			Language currentLocale = new Language(curloc);
			TranslatedIngredient currentTranslatedIngredient = new TranslatedIngredient(currentTinid, currentIngredient,
					currentLocale, curiname);

			Ingredient updatedIngredient = new Ingredient(updatedInid);
			Language updatedLocale = new Language(newloc);
			TranslatedIngredient updatedTranslatedIngredient = new TranslatedIngredient(updatedTinid, updatedIngredient,
					updatedLocale, newiname);

			success = ingredientsService.updateTranslatedIngredient(currentTranslatedIngredient,
					updatedTranslatedIngredient);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("updatedTranslatedIngredientRowsAffected", success);
		return "Update_Ingredient";
	}
	
	@RequestMapping("/viewIngredientsTable.ds")
	public ModelAndView viewIngredientsTable(Model model) {
		List<Ingredient> ingredientsList = new ArrayList<Ingredient>();
		try {
			ingredientsList = ingredientsService.viewIngredientsTable();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("tableName", "Ingredients Table");
		model.addAttribute("columnName1", "Ingredient ID");
		model.addAttribute("columnName2", "Ingredient Type");
		return new ModelAndView("ViewIngredientsTable", "ingredientsList", ingredientsList);
	}
}
