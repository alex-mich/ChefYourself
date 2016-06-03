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
import pojos.RecipeDescription;
import pojos.TranslatedRecipe;
import services.DescriptionsService;

@Controller
public class DescriptionsController {

	@Autowired
	DescriptionsService descriptionsService;

	@RequestMapping(value = "/insertGreekRecipeDescription.ds", method = RequestMethod.POST)
	public String insertGreekRecipeDescription(@RequestParam("grrdid") int grrdid, @RequestParam("tgrrid3") int tgrrid,
			@RequestParam("grrdesc") String grrdesc, Model model) {

		int success = 0;

		try {
			TranslatedRecipe translatedRecipe = new TranslatedRecipe(tgrrid);
			RecipeDescription recipeDescription = new RecipeDescription(grrdid, translatedRecipe, grrdesc);
			success = descriptionsService.insertGreekRecipeDescription(recipeDescription);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("greekDescriptionRowsAffected", success);
		return "Insert_Greek_Recipe";
	}

	@RequestMapping(value = "insertGlobalRecipeDescription.ds", method = RequestMethod.POST)
	public String insertGlobalRecipeDescription(@RequestParam("glrdid") int glrdid, @RequestParam("tglrid3") int tglrid,
			@RequestParam("glrdesc") String glrdesc, Model model) {

		int success = 0;

		try {
			TranslatedRecipe translatedRecipe = new TranslatedRecipe(tglrid);
			RecipeDescription recipeDescription = new RecipeDescription(glrdid, translatedRecipe, glrdesc);
			success = descriptionsService.insertGlobalRecipeDescription(recipeDescription);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("globalDescriptionRowsAffected", success);
		return "Insert_Global_Recipe";
	}

	@RequestMapping(value = "insertSpanishRecipeDescription.ds", method = RequestMethod.POST)
	public String insertSpanishRecipeDescription(@RequestParam("sprdid") int sprdid,
			@RequestParam("tsprid3") int tsprid, @RequestParam("sprdesc") String sprdesc, Model model) {

		int success = 0;

		try {
			TranslatedRecipe translatedRecipe = new TranslatedRecipe(tsprid);
			RecipeDescription recipeDescription = new RecipeDescription(sprdid, translatedRecipe, sprdesc);
			success = descriptionsService.insertSpanishRecipeDescription(recipeDescription);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("spanishDescriptionRowsAffected", success);
		return "Insert_Spanish_Recipe";
	}
	
	@RequestMapping(value = "deleteGreekRecipeDescription.ds", method = RequestMethod.POST)
	public String deleteGreekRecipeDescription(@RequestParam("grrdid") int grrdid, Model model) {

		int success = 0;

		try {
			RecipeDescription recipeDescription = new RecipeDescription(grrdid);
			success = descriptionsService.deleteGreekRecipeDescription(recipeDescription);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("deletedGreekRecipeDescriptionRowsAffected", success);
		return "Delete_Greek_Recipe";
	}

	@RequestMapping(value = "deleteGlobalRecipeDescription.ds", method = RequestMethod.POST)
	public String deleteGlobalRecipeDescription(@RequestParam("glrdid") int glrdid, Model model) {

		int success = 0;

		try {
			RecipeDescription recipeDescription = new RecipeDescription(glrdid);
			success = descriptionsService.deleteGlobalRecipeDescription(recipeDescription);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("deletedGlobalRecipeDescriptionRowsAffected", success);
		return "Delete_Global_Recipe";
	}

	@RequestMapping(value = "deleteSpanishRecipeDescription.ds", method = RequestMethod.POST)
	public String deleteSpanishRecipeDescription(@RequestParam("sprdid") int sprdid, Model model) {

		int success = 0;

		try {
			RecipeDescription recipeDescription = new RecipeDescription(sprdid);
			success = descriptionsService.deleteSpanishRecipeDescription(recipeDescription);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("deletedSpanishRecipeDescriptionRowsAffected", success);
		return "Delete_Spanish_Recipe";
	}
	
	@RequestMapping(value = "updateGreekRecipeDescription.ds", method = RequestMethod.POST)
	public String updateGreekRecipeDescription(@RequestParam("curgrrdid") String curgrrdid,
			@RequestParam("curtgrrid3") String curtgrrid, @RequestParam("curgrrdesc") String curgrrdesc,
			@RequestParam("newgrrdid") String newgrrdid, @RequestParam("newtgrrid3") String newtgrrid,
			@RequestParam("newgrrdesc") String newgrrdesc, Model model) throws Exception {

		int currentGrdid, updatedGrfiid, currentTgrrid, updatedTgrrid;
		int success = 0;
		try {

			currentGrdid = curgrrdid.equals("") ? 0 : Integer.parseInt(curgrrdid);
			updatedGrfiid = newgrrdid.equals("") ? 0 : Integer.parseInt(newgrrdid);
			currentTgrrid = curtgrrid.equals("") ? 0 : Integer.parseInt(curtgrrid);
			updatedTgrrid = newtgrrid.equals("") ? 0 : Integer.parseInt(newtgrrid);

			TranslatedRecipe currentTranslatedRecipe = new TranslatedRecipe(currentTgrrid);
			RecipeDescription currentRecipeDescription = new RecipeDescription(currentGrdid, currentTranslatedRecipe,
					curgrrdesc);

			TranslatedRecipe updatedTranslatedRecipe = new TranslatedRecipe(updatedTgrrid);
			RecipeDescription updatedRecipeDescription = new RecipeDescription(updatedGrfiid, updatedTranslatedRecipe,
					newgrrdesc);

			success = descriptionsService.updateRecipeDescription(currentRecipeDescription, updatedRecipeDescription,
					TableType.GREEK_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("updatedGreekRecipeDescriptionRowsAffected", success);
		return "Update_Greek_Recipe";
	}

	@RequestMapping(value = "updateGlobalRecipeDescription.ds", method = RequestMethod.POST)
	public String updateGlobalRecipeDescription(@RequestParam("curglrdid") String curglrdid,
			@RequestParam("curtglrid3") String curtglrid, @RequestParam("curglrdesc") String curglrdesc,
			@RequestParam("newglrdid") String newglrdid, @RequestParam("newtglrid3") String newtglrid,
			@RequestParam("newglrdesc") String newglrdesc, Model model) throws Exception {

		int currentGldid, updatedGldid, currentTglrid, updatedTglrid;
		int success = 0;
		try {

			currentGldid = curglrdid.equals("") ? 0 : Integer.parseInt(curglrdid);
			updatedGldid = newglrdid.equals("") ? 0 : Integer.parseInt(newglrdid);
			currentTglrid = curtglrid.equals("") ? 0 : Integer.parseInt(curtglrid);
			updatedTglrid = newtglrid.equals("") ? 0 : Integer.parseInt(newtglrid);

			TranslatedRecipe currentTranslatedRecipe = new TranslatedRecipe(currentTglrid);
			RecipeDescription currentRecipeDescription = new RecipeDescription(currentGldid, currentTranslatedRecipe,
					curglrdesc);

			TranslatedRecipe updatedTranslatedRecipe = new TranslatedRecipe(updatedTglrid);
			RecipeDescription updatedRecipeDescription = new RecipeDescription(updatedGldid, updatedTranslatedRecipe,
					newglrdesc);

			success = descriptionsService.updateRecipeDescription(currentRecipeDescription, updatedRecipeDescription,
					TableType.GLOBAL_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("updatedGlobalRecipeDescriptionRowsAffected", success);
		return "Update_Global_Recipe";
	}

	@RequestMapping(value = "updateSpanishRecipeDescription.ds", method = RequestMethod.POST)
	public String updateSpanishRecipeDescription(@RequestParam("cursprdid") String cursprdid,
			@RequestParam("curtsprid3") String curtsprid, @RequestParam("cursprdesc") String cursprdesc,
			@RequestParam("newsprdid") String newsprdid, @RequestParam("newtsprid3") String newtsprid,
			@RequestParam("newsprdesc") String newsprdesc, Model model) throws Exception {

		int currentSprdid, updatedSprdid, currentTsprid, updatedTsprid;
		int success = 0;
		try {

			currentSprdid = cursprdid.equals("") ? 0 : Integer.parseInt(cursprdid);
			updatedSprdid = newsprdid.equals("") ? 0 : Integer.parseInt(newsprdid);
			currentTsprid = curtsprid.equals("") ? 0 : Integer.parseInt(curtsprid);
			updatedTsprid = newtsprid.equals("") ? 0 : Integer.parseInt(newtsprid);

			TranslatedRecipe currentTranslatedRecipe = new TranslatedRecipe(currentTsprid);
			RecipeDescription currentRecipeDescription = new RecipeDescription(currentSprdid, currentTranslatedRecipe,
					cursprdesc);

			TranslatedRecipe updatedTranslatedRecipe = new TranslatedRecipe(updatedTsprid);
			RecipeDescription updatedRecipeDescription = new RecipeDescription(updatedSprdid, updatedTranslatedRecipe,
					newsprdesc);

			success = descriptionsService.updateRecipeDescription(currentRecipeDescription, updatedRecipeDescription,
					TableType.SPANISH_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("updatedSpanishRecipeDescriptionRowsAffected", success);
		return "Update_Spanish_Recipe";
	}
	
	@RequestMapping("/viewGreekRecipeDescriptionsTable.ds")
	public ModelAndView viewGreekRecipeDescription(Model model) {
		List<RecipeDescription> recipeDescriptionsList = null;
		try {
			recipeDescriptionsList = descriptionsService.viewRecipeDescriptionTable(TableType.GREEK_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("tableName", "Greek Recipes Description Table");
		model.addAttribute("columnName1", "Greek Recipe Description ID");
		model.addAttribute("columnName2", "Translated Recipe ID");
		model.addAttribute("columnName3", "Recipe Description");
		return new ModelAndView("ViewRecipeDescriptionsTable", "recipeDescriptionsList", recipeDescriptionsList);
	}

	@RequestMapping("/viewGlobalRecipeDescriptionsTable.ds")
	public ModelAndView viewGlobalRecipeDescription(Model model) {
		List<RecipeDescription> recipeDescriptionsList = null;
		try {
			recipeDescriptionsList = descriptionsService.viewRecipeDescriptionTable(TableType.GLOBAL_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("tableName", "Global Recipes Description Table");
		model.addAttribute("columnName1", "Global Recipe Description ID");
		model.addAttribute("columnName2", "Translated Recipe ID");
		model.addAttribute("columnName3", "Recipe Description");
		return new ModelAndView("ViewRecipeDescriptionsTable", "recipeDescriptionsList", recipeDescriptionsList);
	}

	@RequestMapping("/viewSpanishRecipeDescriptionsTable.ds")
	public ModelAndView viewSpanishRecipeDescription(Model model) {
		List<RecipeDescription> recipeDescriptionsList = null;
		try {
			recipeDescriptionsList = descriptionsService.viewRecipeDescriptionTable(TableType.SPANISH_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("tableName", "Spanish Recipes Description Table");
		model.addAttribute("columnName1", "Spanish Recipe Description ID");
		model.addAttribute("columnName2", "Translated Recipe ID");
		model.addAttribute("columnName3", "Recipe Description");
		return new ModelAndView("ViewRecipeDescriptionsTable", "recipeDescriptionsList", recipeDescriptionsList);
	}
	
}
