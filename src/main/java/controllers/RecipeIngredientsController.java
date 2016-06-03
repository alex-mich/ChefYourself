package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import enumerations.TableType;
import pojos.RecipeIngredient;
import pojos.TranslatedIngredient;
import pojos.TranslatedRecipe;
import services.RecipeIngredientsService;

@Controller
public class RecipeIngredientsController {

	@Autowired
	RecipeIngredientsService recipeIngredientsService;

	@RequestMapping(value = "insertGreekRecipeIngredients.ds", method = RequestMethod.POST)
	public String insertGreekRecipeIngredient(@RequestParam("griid") int griid, @RequestParam("tgrrid2") int tgrrid,
			@RequestParam("tinid") int tinid, @RequestParam("grriquan") String grriquan, Model model) {

		int success = 0;

		try {
			TranslatedRecipe translatedRecipe = new TranslatedRecipe(tgrrid);
			TranslatedIngredient translatedIngredient = new TranslatedIngredient(tinid);
			RecipeIngredient recipeIngredient = new RecipeIngredient(griid, translatedRecipe, translatedIngredient,
					grriquan);
			success = recipeIngredientsService.insertRecipeIngredient(recipeIngredient, TableType.GREEK_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("greekRecipeIngredientsRowsAffected", success);
		return "Insert_Greek_Recipe";
	}

	@RequestMapping(value = "insertGlobalRecipeIngredients.ds", method = RequestMethod.POST)
	public String insertGlobalRecipeIngredient(@RequestParam("gliid") int gliid, @RequestParam("tglrid2") int tglrid,
			@RequestParam("tinid") int tinid, @RequestParam("glriquan") String glriquan, Model model) {

		int success = 0;

		try {
			TranslatedRecipe translatedRecipe = new TranslatedRecipe(tglrid);
			TranslatedIngredient translatedIngredient = new TranslatedIngredient(tinid);
			RecipeIngredient recipeIngredient = new RecipeIngredient(gliid, translatedRecipe, translatedIngredient,
					glriquan);
			success = recipeIngredientsService.insertRecipeIngredient(recipeIngredient, TableType.GLOBAL_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("globalRecipeIngredientsRowsAffected", success);
		return "Insert_Global_Recipe";
	}

	@RequestMapping(value = "insertSpanishRecipeIngredients.ds", method = RequestMethod.POST)
	public String insertSpanishRecipeIngredient(@RequestParam("spiid") int spiid, @RequestParam("tsprid2") int tsprid,
			@RequestParam("tinid") int tinid, @RequestParam("spriquan") String spriquan, Model model) {

		int success = 0;

		try {
			TranslatedRecipe translatedRecipe = new TranslatedRecipe(tsprid);
			TranslatedIngredient translatedIngredient = new TranslatedIngredient(tinid);
			RecipeIngredient recipeIngredient = new RecipeIngredient(spiid, translatedRecipe, translatedIngredient,
					spriquan);
			success = recipeIngredientsService.insertRecipeIngredient(recipeIngredient, TableType.SPANISH_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("spanishRecipeIngredientsRowsAffected", success);
		return "Insert_Spanish_Recipe";
	}

	@RequestMapping(value = "deleteGreekRecipeIngredient.ds", method = RequestMethod.POST)
	public String deleteGreekRecipeIngredient(@RequestParam("griid") int griid, Model model) {

		int success = 0;

		try {
			RecipeIngredient recipeIngredient = new RecipeIngredient(griid);
			success = recipeIngredientsService.deleteRecipeIngredient(recipeIngredient, TableType.GREEK_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("deletedGreekRecipeIngredientsRowsAffected", success);
		return "Delete_Greek_Recipe";
	}

	@RequestMapping(value = "deleteGlobalRecipeIngredient.ds", method = RequestMethod.POST)
	public String deleteGlobalRecipeIngredient(@RequestParam("gliid") int gliid, Model model) {

		int success = 0;

		try {
			RecipeIngredient recipeIngredient = new RecipeIngredient(gliid);
			success = recipeIngredientsService.deleteRecipeIngredient(recipeIngredient, TableType.GLOBAL_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("deletedGlobalRecipeIngredientsRowsAffected", success);
		return "Delete_Global_Recipe";
	}

	@RequestMapping(value = "deleteSpanishRecipeIngredient.ds", method = RequestMethod.POST)
	public String deleteSpanishRecipeIngredient(@RequestParam("spiid") int spiid, Model model) {

		int success = 0;

		try {
			RecipeIngredient recipeIngredient = new RecipeIngredient(spiid);
			success = recipeIngredientsService.deleteRecipeIngredient(recipeIngredient, TableType.SPANISH_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("deletedSpanishRecipeIngredientsRowsAffected", success);
		return "Delete_Spanish_Recipe";
	}

	@RequestMapping(value = "updateGreekRecipeIngredient.ds", method = RequestMethod.POST)
	public String updateGreekRecipeIngredient(@RequestParam("curgriid") String curgriid,
			@RequestParam("curtgrrid2") String curtgrrid, @RequestParam("curtinid") String curtinid,
			@RequestParam("curgrriquan") String curgrriquan, @RequestParam("newgriid") String newgriid,
			@RequestParam("newtgrrid2") String newtgrrid, @RequestParam("newtinid") String newtinid,
			@RequestParam("newgrriquan") String newgrriquan, Model model) throws Exception {

		int currentGriid, updatedGriid, currentGrrid, updatedGrrid, currentTinid, updatedTinid;
		int success = 0;
		try {

			currentGriid = curgriid.equals("") ? 0 : Integer.parseInt(curgriid);
			updatedGriid = newgriid.equals("") ? 0 : Integer.parseInt(newgriid);
			currentGrrid = curtgrrid.equals("") ? 0 : Integer.parseInt(curtgrrid);
			updatedGrrid = newtgrrid.equals("") ? 0 : Integer.parseInt(newtgrrid);
			currentTinid = curtinid.equals("") ? 0 : Integer.parseInt(curtinid);
			updatedTinid = newtinid.equals("") ? 0 : Integer.parseInt(newtinid);

			TranslatedRecipe currentTranslatedRecipe = new TranslatedRecipe(currentGrrid);
			TranslatedIngredient currentTranslatedIngredient = new TranslatedIngredient(currentTinid);
			RecipeIngredient currentRecipeIngredient = new RecipeIngredient(currentGriid, currentTranslatedRecipe,
					currentTranslatedIngredient, curgrriquan);

			TranslatedRecipe updatedTranslatedRecipe = new TranslatedRecipe(updatedGrrid);
			TranslatedIngredient updatedTranslatedIngredient = new TranslatedIngredient(updatedTinid);
			RecipeIngredient updatedRecipeIngredient = new RecipeIngredient(updatedGriid, updatedTranslatedRecipe,
					updatedTranslatedIngredient, newgrriquan);

			success = recipeIngredientsService.updateRecipeIngredient(currentRecipeIngredient, updatedRecipeIngredient,
					TableType.GREEK_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("updatedGreekRecipeIngrdientRowsAffected", success);
		return "Update_Greek_Recipe";
	}

	@RequestMapping(value = "updateGlobalRecipeIngredient.ds", method = RequestMethod.POST)
	public String updateGlobalRecipeIngredient(@RequestParam("curgliid") String curgliid,
			@RequestParam("curtglrid2") String curtglrid, @RequestParam("curtinid") String curtinid,
			@RequestParam("curglriquan") String curglriquan, @RequestParam("newgliid") String newgliid,
			@RequestParam("newtglrid2") String newtglrid, @RequestParam("newtinid") String newtinid,
			@RequestParam("newglriquan") String newglriquan, Model model) throws Exception {

		int currentGliid, updatedGliid, currentGlrid, updatedGlrid, currentTinid, updatedTinid;
		int success = 0;
		try {

			currentGliid = curgliid.equals("") ? 0 : Integer.parseInt(curgliid);
			updatedGliid = newgliid.equals("") ? 0 : Integer.parseInt(newgliid);
			currentGlrid = curtglrid.equals("") ? 0 : Integer.parseInt(curtglrid);
			updatedGlrid = newtglrid.equals("") ? 0 : Integer.parseInt(newtglrid);
			currentTinid = curtinid.equals("") ? 0 : Integer.parseInt(curtinid);
			updatedTinid = newtinid.equals("") ? 0 : Integer.parseInt(newtinid);

			TranslatedRecipe currentTranslatedRecipe = new TranslatedRecipe(currentGlrid);
			TranslatedIngredient currentTranslatedIngredient = new TranslatedIngredient(currentTinid);
			RecipeIngredient currentRecipeIngredient = new RecipeIngredient(currentGliid, currentTranslatedRecipe,
					currentTranslatedIngredient, curglriquan);

			TranslatedRecipe updatedTranslatedRecipe = new TranslatedRecipe(updatedGlrid);
			TranslatedIngredient updatedTranslatedIngredient = new TranslatedIngredient(updatedTinid);
			RecipeIngredient updatedRecipeIngredient = new RecipeIngredient(updatedGliid, updatedTranslatedRecipe,
					updatedTranslatedIngredient, newglriquan);

			success = recipeIngredientsService.updateRecipeIngredient(currentRecipeIngredient, updatedRecipeIngredient,
					TableType.GLOBAL_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("updatedGlobalRecipeIngrdientRowsAffected", success);
		return "Update_Global_Recipe";
	}

	@RequestMapping(value = "updateSpanishRecipeIngredient.ds", method = RequestMethod.POST)
	public String updateSpanishRecipeIngredient(@RequestParam("curspiid") String curspiid,
			@RequestParam("curtsprid2") String curtsprid, @RequestParam("curtinid") String curtinid,
			@RequestParam("curspriquan") String curspriquan, @RequestParam("newspiid") String newspiid,
			@RequestParam("newtsprid2") String newtsprid, @RequestParam("newtinid") String newtinid,
			@RequestParam("newspriquan") String newspriquan, Model model) throws Exception {

		int currentSpiid, updatedSpiid, currentSprid, updatedSprid, currentTinid, updatedTinid;
		int success = 0;
		try {

			currentSpiid = curspiid.equals("") ? 0 : Integer.parseInt(curspiid);
			updatedSpiid = newspiid.equals("") ? 0 : Integer.parseInt(newspiid);
			currentSprid = curtsprid.equals("") ? 0 : Integer.parseInt(curtsprid);
			updatedSprid = newtsprid.equals("") ? 0 : Integer.parseInt(newtsprid);
			currentTinid = curtinid.equals("") ? 0 : Integer.parseInt(curtinid);
			updatedTinid = newtinid.equals("") ? 0 : Integer.parseInt(newtinid);

			TranslatedRecipe currentTranslatedRecipe = new TranslatedRecipe(currentSprid);
			TranslatedIngredient currentTranslatedIngredient = new TranslatedIngredient(currentTinid);
			RecipeIngredient currentRecipeIngredient = new RecipeIngredient(currentSpiid, currentTranslatedRecipe,
					currentTranslatedIngredient, curspriquan);

			TranslatedRecipe updatedTranslatedRecipe = new TranslatedRecipe(updatedSprid);
			TranslatedIngredient updatedTranslatedIngredient = new TranslatedIngredient(updatedTinid);
			RecipeIngredient updatedRecipeIngredient = new RecipeIngredient(updatedSpiid, updatedTranslatedRecipe,
					updatedTranslatedIngredient, newspriquan);

			success = recipeIngredientsService.updateRecipeIngredient(currentRecipeIngredient, updatedRecipeIngredient,
					TableType.SPANISH_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("updatedSpanishRecipeIngrdientRowsAffected", success);
		return "Update_Spanish_Recipe";
	}

	@RequestMapping("/viewGreekRecipeIngredientsTable.ds")
	public ModelAndView viewGreekRecipeIngredients(Model model) {
		List<RecipeIngredient> recipeIngredientsList = null;
		try {
			recipeIngredientsList = recipeIngredientsService.viewRecipeIngredientsTable(TableType.GREEK_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("tableName", "Greek Recipe Ingredients Table");
		model.addAttribute("columnName1", "Greek Recipe Ingredient ID");
		model.addAttribute("columnName2", "Translated Recipe ID");
		model.addAttribute("columnName3", "Translated Ingredinet ID");
		model.addAttribute("columnName4", "Ingredient Quantity");
		return new ModelAndView("ViewRecipeIngredientsTable", "recipeIngredientsList", recipeIngredientsList);
	}

	@RequestMapping("/viewGlobalRecipeIngredientsTable.ds")
	public ModelAndView viewGlobalRecipeIngredients(Model model) {
		List<RecipeIngredient> recipeIngredientsList = null;
		try {
			recipeIngredientsList = recipeIngredientsService.viewRecipeIngredientsTable(TableType.GLOBAL_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("tableName", "Global Recipe Ingredients Table");
		model.addAttribute("columnName1", "Global Recipe Ingredient ID");
		model.addAttribute("columnName2", "Translated Recipe ID");
		model.addAttribute("columnName3", "Translated Ingredinet ID");
		model.addAttribute("columnName4", "Ingredient Quantity");
		return new ModelAndView("ViewRecipeIngredientsTable", "recipeIngredientsList", recipeIngredientsList);
	}

	@RequestMapping("/viewSpanishRecipeIngredientsTable.ds")
	public ModelAndView viewSpanishRecipeIngredients(Model model) {
		List<RecipeIngredient> recipeIngredientsList = null;
		try {
			recipeIngredientsList = recipeIngredientsService.viewRecipeIngredientsTable(TableType.SPANISH_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("tableName", "Spanish Recipe Ingredients Table");
		model.addAttribute("columnName1", "Spanish Recipe Ingredient ID");
		model.addAttribute("columnName2", "Translated Recipe ID");
		model.addAttribute("columnName3", "Translated Ingredinet ID");
		model.addAttribute("columnName4", "Ingredient Quantity");
		return new ModelAndView("ViewRecipeIngredientsTable", "recipeIngredientsList", recipeIngredientsList);
	}

}
