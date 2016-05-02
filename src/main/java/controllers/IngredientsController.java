package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pojos.Ingredient;
import pojos.Language;
import pojos.TranslatedIngredient;
import services.IngredientsService;

@Controller
public class IngredientsController {
	
	@Autowired
	IngredientsService ingredientsService;

	@RequestMapping(value = "insertIngredient.ds", method = RequestMethod.POST)
	public String insertIngredient(@RequestParam("inid1") int inid,@RequestParam("itype") String itype, Model model) throws Exception {

		int success = 0;
		try {
			Ingredient ingredient = new Ingredient(inid,itype);
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
			TranslatedIngredient translatedIngredient = new TranslatedIngredient(tinid,ingredient,locale,iname);
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
			Ingredient  ingredient = new Ingredient(inid);
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
}
