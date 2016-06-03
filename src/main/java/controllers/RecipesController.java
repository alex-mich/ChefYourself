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
import pojos.Language;
import pojos.Recipe;
import pojos.TranslatedCuisine;
import pojos.TranslatedMethod;
import pojos.TranslatedRecipe;
import services.RecipesService;

@Controller
public class RecipesController {

	@Autowired
	RecipesService recipeService;

	@RequestMapping(value = "insertGreekRecipe.ds", method = RequestMethod.POST)
	public String insertGreekRecipe(@RequestParam("grrid1") int grrid, Model model) throws Exception {

		int success = 0;
		try {
			Recipe recipe = new Recipe(grrid);
			success = recipeService.insertRecipe(recipe, TableType.GREEK_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("greekRecipesRowsAffected", success);
		return "Insert_Greek_Recipe";
	}

	@RequestMapping(value = "insertGlobalRecipe.ds", method = RequestMethod.POST)
	public String insertGlobalRecipe(@RequestParam("glrid1") int glrid, Model model) throws Exception {
		int success = 0;
		try {
			Recipe recipe = new Recipe(glrid);
			success = recipeService.insertRecipe(recipe, TableType.GLOBAL_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("globalRecipesRowsAffected", success);
		return "Insert_Global_Recipe";
	}

	@RequestMapping(value = "insertSpanishRecipe.ds", method = RequestMethod.POST)
	public String insertSpanishRecipe(@RequestParam("sprid1") int sprid, Model model) throws Exception {

		int success = 0;
		try {
			Recipe recipe = new Recipe(sprid);
			success = recipeService.insertRecipe(recipe, TableType.SPANISH_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("spanishRecipesRowsAffected", success);
		return "Insert_Spanish_Recipe";
	}

	@RequestMapping(value = "insertGreekRecipeTrans.ds", method = RequestMethod.POST)
	public String insertGreekRecipeTrans(@RequestParam("tgrrid") int tgrrid, @RequestParam("grrid2") int grrid,
			@RequestParam("tcid") int tcid, @RequestParam("tmid") int tmid, @RequestParam("loc") String loc,
			@RequestParam("grrname") String grrname, Model model) throws Exception {

		int success = 0;
		try {
			Recipe recipe = new Recipe(grrid);
			TranslatedCuisine transCuisine = new TranslatedCuisine(tcid);
			TranslatedMethod transMethod = new TranslatedMethod(tmid);
			Language locale = new Language(loc);
			TranslatedRecipe transRecipe = new TranslatedRecipe(tgrrid, recipe, transCuisine, transMethod, locale,
					grrname);
			success = recipeService.insertGreekTranslatedRecipe(transRecipe);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("greekTranslatedRecipesRowsAffected", success);
		return "Insert_Greek_Recipe";
	}

	@RequestMapping(value = "insertGlobalRecipeTrans.ds", method = RequestMethod.POST)
	public String insertGlobalRecipeTrans(@RequestParam("tglrid") int tglrid, @RequestParam("glrid2") int glrid,
			@RequestParam("tcid") int tcid, @RequestParam("tmid") int tmid, @RequestParam("loc") String loc,
			@RequestParam("glrname") String glrname, Model model) throws Exception {

		int success = 0;
		try {
			Recipe recipe = new Recipe(glrid);
			TranslatedCuisine transCuisine = new TranslatedCuisine(tcid);
			TranslatedMethod transMethod = new TranslatedMethod(tmid);
			Language locale = new Language(loc);
			TranslatedRecipe transRecipe = new TranslatedRecipe(tglrid, recipe, transCuisine, transMethod, locale,
					glrname);
			success = recipeService.insertGlobalTranslatedRecipe(transRecipe);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("globalTranslatedRecipesRowsAffected", success);
		return "Insert_Global_Recipe";
	}

	@RequestMapping(value = "insertSpanishRecipeTrans.ds", method = RequestMethod.POST)
	public String insertSpanishRecipeTrans(@RequestParam("tsprid") int tsprid, @RequestParam("sprid2") int sprid,
			@RequestParam("tcid") int tcid, @RequestParam("tmid") int tmid, @RequestParam("loc") String loc,
			@RequestParam("sprname") String sprname, Model model) throws Exception {

		int success = 0;
		try {
			Recipe recipe = new Recipe(sprid);
			TranslatedCuisine transCuisine = new TranslatedCuisine(tcid);
			TranslatedMethod transMethod = new TranslatedMethod(tmid);
			Language locale = new Language(loc);
			TranslatedRecipe transRecipe = new TranslatedRecipe(tsprid, recipe, transCuisine, transMethod, locale,
					sprname);
			success = recipeService.insertSpanishTranslatedRecipe(transRecipe);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("spanishTranslatedRecipesRowsAffected", success);
		return "Insert_Spanish_Recipe";
	}
	
	@RequestMapping(value = "deleteGreekRecipe.ds", method = RequestMethod.POST)
	public String deleteGreekRecipe(@RequestParam("grrid1") int grrid, Model model) {

		int success = 0;

		try {
			Recipe recipe = new Recipe(grrid);
			success = recipeService.deleteRecipe(recipe, TableType.GREEK_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("deletedGreekRecipesRowsAffected", success);
		return "Delete_Greek_Recipe";
	}

	@RequestMapping(value = "deleteGlobalRecipe.ds", method = RequestMethod.POST)
	public String deleteGlobalRecipe(@RequestParam("glrid1") int glrid, Model model) {

		int success = 0;

		try {
			Recipe recipe = new Recipe(glrid);
			success = recipeService.deleteRecipe(recipe, TableType.GLOBAL_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("deletedGlobalRecipesRowsAffected", success);
		return "Delete_Global_Recipe";
	}

	@RequestMapping(value = "deleteSpanishRecipe.ds", method = RequestMethod.POST)
	public String deleteSpanishRecipe(@RequestParam("sprid1") int sprid, Model model) {

		int success = 0;

		try {
			Recipe recipe = new Recipe(sprid);
			success = recipeService.deleteRecipe(recipe, TableType.SPANISH_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("deletedSpanishRecipesRowsAffected", success);
		return "Delete_Spanish_Recipe";
	}

	@RequestMapping(value = "deleteGreekRecipeTrans.ds", method = RequestMethod.POST)
	public String deleteGreekTranslatedRecipe(@RequestParam("tgrrid") int tgrrid, Model model) {

		int success = 0;

		try {
			TranslatedRecipe trRecipe = new TranslatedRecipe(tgrrid);
			success = recipeService.deleteTranslatedRecipe(trRecipe, TableType.GREEK_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("deletedGreekTranslatedRecipesRowsAffected", success);
		return "Delete_Greek_Recipe";
	}

	@RequestMapping(value = "deleteGlobalRecipeTrans.ds", method = RequestMethod.POST)
	public String deleteGlobalTranslatedRecipe(@RequestParam("tglrid") int tglrid, Model model) {

		int success = 0;

		try {
			TranslatedRecipe trRecipe = new TranslatedRecipe(tglrid);
			success = recipeService.deleteTranslatedRecipe(trRecipe, TableType.GLOBAL_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("deletedGlobalTranslatedRecipesRowsAffected", success);
		return "Delete_Global_Recipe";
	}

	@RequestMapping(value = "deleteSpanishRecipeTrans.ds", method = RequestMethod.POST)
	public String deleteSpanishTranslatedRecipe(@RequestParam("tsprid") int tsprid, Model model) {

		int success = 0;

		try {
			TranslatedRecipe trRecipe = new TranslatedRecipe(tsprid);
			success = recipeService.deleteTranslatedRecipe(trRecipe, TableType.SPANISH_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("deletedSpanishTranslatedRecipesRowsAffected", success);
		return "Delete_Spanish_Recipe";
	}

	@RequestMapping(value = "updateGreekRecipe.ds", method = RequestMethod.POST)
	public String updateGreekRecipe(@RequestParam("curgrrid1") String curgrrid,
			@RequestParam("newgrrid1") String newgrrid, Model model) throws Exception {

		int currentGrrid, updatedGrrid;
		int success = 0;
		try {

			currentGrrid = curgrrid.equals("") ? 0 : Integer.parseInt(curgrrid);
			updatedGrrid = newgrrid.equals("") ? 0 : Integer.parseInt(newgrrid);

			Recipe currentRecipe = new Recipe(currentGrrid);
			Recipe updatedRecipe = new Recipe(updatedGrrid);
			success = recipeService.updateRecipe(currentRecipe, updatedRecipe, TableType.GREEK_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("updatedGreekRecipeRowsAffected", success);
		return "Update_Greek_Recipe";
	}

	@RequestMapping(value = "updateGlobalRecipe.ds", method = RequestMethod.POST)
	public String updateGlobalRecipe(@RequestParam("curglrid1") String curglrid,
			@RequestParam("newglrid1") String newglrid, Model model) throws Exception {

		int currentGlrid, updatedGlrid;
		int success = 0;
		try {

			currentGlrid = curglrid.equals("") ? 0 : Integer.parseInt(curglrid);
			updatedGlrid = newglrid.equals("") ? 0 : Integer.parseInt(newglrid);

			Recipe currentRecipe = new Recipe(currentGlrid);
			Recipe updatedRecipe = new Recipe(updatedGlrid);
			success = recipeService.updateRecipe(currentRecipe, updatedRecipe, TableType.GLOBAL_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("updatedGlobalRecipeRowsAffected", success);
		return "Update_Global_Recipe";
	}

	@RequestMapping(value = "updateSpanishRecipe.ds", method = RequestMethod.POST)
	public String updateSpanishRecipe(@RequestParam("cursprid1") String cursprid,
			@RequestParam("newsprid1") String newsprid, Model model) throws Exception {

		int currentSprid, updatedSprid;
		int success = 0;
		try {

			currentSprid = cursprid.equals("") ? 0 : Integer.parseInt(cursprid);
			updatedSprid = newsprid.equals("") ? 0 : Integer.parseInt(newsprid);

			Recipe currentRecipe = new Recipe(currentSprid);
			Recipe updatedRecipe = new Recipe(updatedSprid);
			success = recipeService.updateRecipe(currentRecipe, updatedRecipe, TableType.SPANISH_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("updatedSpanishRecipeRowsAffected", success);
		return "Update_Spanish_Recipe";
	}

	@RequestMapping(value = "updateGreekTranslatedRecipe.ds", method = RequestMethod.POST)
	public String updateTranslatedGreekRecipe(@RequestParam("curtgrrid") String curtgrrid,
			@RequestParam("curgrrid2") String curgrrid, @RequestParam("curtcid") String curtcid,
			@RequestParam("curtmid") String curtmid, @RequestParam("curloc") String curloc,
			@RequestParam("curgrrname") String curgrrname, @RequestParam("newtgrrid") String newtgrrid,
			@RequestParam("newgrrid2") String newgrrid, @RequestParam("newtcid") String newtcid,
			@RequestParam("newtmid") String newtmid, @RequestParam("newloc") String newloc,
			@RequestParam("newgrrname") String newgrrname, Model model) throws Exception {

		int currentTgrrid, updatedTgrrid, currentGrrid, updatedGrrid, currentTmid, updatedTmid, currentTcid,
				updatedTcid;
		int success = 0;
		try {

			currentTgrrid = curtgrrid.equals("") ? 0 : Integer.parseInt(curtgrrid);
			updatedTgrrid = newtgrrid.equals("") ? 0 : Integer.parseInt(newtgrrid);
			currentGrrid = curgrrid.equals("") ? 0 : Integer.parseInt(curgrrid);
			updatedGrrid = newgrrid.equals("") ? 0 : Integer.parseInt(newgrrid);
			currentTmid = curtmid.equals("") ? 0 : Integer.parseInt(curtmid);
			updatedTmid = newtmid.equals("") ? 0 : Integer.parseInt(newtmid);
			currentTcid = curtcid.equals("") ? 0 : Integer.parseInt(curtcid);
			updatedTcid = newtcid.equals("") ? 0 : Integer.parseInt(newtcid);

			Recipe currentRecipe = new Recipe(currentGrrid);
			TranslatedCuisine currentTranslatedCuisine = new TranslatedCuisine(currentTcid);
			TranslatedMethod currentTranslatedMethod = new TranslatedMethod(currentTmid);
			Language currentLanguage = new Language(curloc);
			TranslatedRecipe currentTranslatedRecipe = new TranslatedRecipe(currentTgrrid, currentRecipe,
					currentTranslatedCuisine, currentTranslatedMethod, currentLanguage, curgrrname);

			Recipe updatedRecipe = new Recipe(updatedGrrid);
			TranslatedCuisine updatedTranslatedCuisine = new TranslatedCuisine(updatedTcid);
			TranslatedMethod updatedTranslatedMethod = new TranslatedMethod(updatedTmid);
			Language updatedLanguage = new Language(newloc);
			TranslatedRecipe updatedTranslatedRecipe = new TranslatedRecipe(updatedTgrrid, updatedRecipe,
					updatedTranslatedCuisine, updatedTranslatedMethod, updatedLanguage, newgrrname);

			success = recipeService.updateTranslatedRecipe(currentTranslatedRecipe, updatedTranslatedRecipe,
					TableType.GREEK_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("updatedTranslatedGreekRecipeRowsAffected", success);
		return "Update_Greek_Recipe";
	}

	@RequestMapping(value = "updateGlobalTranslatedRecipe.ds", method = RequestMethod.POST)
	public String updateTranslatedGlobalRecipe(@RequestParam("curtglrid") String curtglrid,
			@RequestParam("curglrid2") String curglrid, @RequestParam("curtcid") String curtcid,
			@RequestParam("curtmid") String curtmid, @RequestParam("curloc") String curloc,
			@RequestParam("curglrname") String curglrname, @RequestParam("newtglrid") String newtglrid,
			@RequestParam("newglrid2") String newglrid, @RequestParam("newtcid") String newtcid,
			@RequestParam("newtmid") String newtmid, @RequestParam("newloc") String newloc,
			@RequestParam("newglrname") String newglrname, Model model) throws Exception {

		int currentTglrid, updatedTglrid, currentGlrid, updatedGlrid, currentTmid, updatedTmid, currentTcid,
				updatedTcid;
		int success = 0;
		try {

			currentTglrid = curtglrid.equals("") ? 0 : Integer.parseInt(curtglrid);
			updatedTglrid = newtglrid.equals("") ? 0 : Integer.parseInt(newtglrid);
			currentGlrid = curglrid.equals("") ? 0 : Integer.parseInt(curglrid);
			updatedGlrid = newglrid.equals("") ? 0 : Integer.parseInt(newglrid);
			currentTmid = curtmid.equals("") ? 0 : Integer.parseInt(curtmid);
			updatedTmid = newtmid.equals("") ? 0 : Integer.parseInt(newtmid);
			currentTcid = curtcid.equals("") ? 0 : Integer.parseInt(curtcid);
			updatedTcid = newtcid.equals("") ? 0 : Integer.parseInt(newtcid);

			Recipe currentRecipe = new Recipe(currentGlrid);
			TranslatedCuisine currentTranslatedCuisine = new TranslatedCuisine(currentTcid);
			TranslatedMethod currentTranslatedMethod = new TranslatedMethod(currentTmid);
			Language currentLanguage = new Language(curloc);
			TranslatedRecipe currentTranslatedRecipe = new TranslatedRecipe(currentTglrid, currentRecipe,
					currentTranslatedCuisine, currentTranslatedMethod, currentLanguage, curglrname);

			Recipe updatedRecipe = new Recipe(updatedGlrid);
			TranslatedCuisine updatedTranslatedCuisine = new TranslatedCuisine(updatedTcid);
			TranslatedMethod updatedTranslatedMethod = new TranslatedMethod(updatedTmid);
			Language updatedLanguage = new Language(newloc);
			TranslatedRecipe updatedTranslatedRecipe = new TranslatedRecipe(updatedTglrid, updatedRecipe,
					updatedTranslatedCuisine, updatedTranslatedMethod, updatedLanguage, newglrname);

			success = recipeService.updateTranslatedRecipe(currentTranslatedRecipe, updatedTranslatedRecipe,
					TableType.GLOBAL_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("updatedTranslatedGlobalRecipeRowsAffected", success);
		return "Update_Global_Recipe";
	}

	@RequestMapping(value = "updateTranslatedSpanishRecipe.ds", method = RequestMethod.POST)
	public String updateTranslatedSpanishRecipe(@RequestParam("curtsprid") String curtsprid,
			@RequestParam("cursprid2") String cursprid, @RequestParam("curtcid") String curtcid,
			@RequestParam("curtmid") String curtmid, @RequestParam("curloc") String curloc,
			@RequestParam("cursprname") String cursprname, @RequestParam("newtsprid") String newtsprid,
			@RequestParam("newsprid2") String newsprid, @RequestParam("newtcid") String newtcid,
			@RequestParam("newtmid") String newtmid, @RequestParam("newloc") String newloc,
			@RequestParam("newsprname") String newsprname, Model model) throws Exception {

		int currentTsprid, updatedTsprid, currentSprid, updatedSprid, currentTmid, updatedTmid, currentTcid,
				updatedTcid;
		int success = 0;
		try {

			currentTsprid = curtsprid.equals("") ? 0 : Integer.parseInt(curtsprid);
			updatedTsprid = newtsprid.equals("") ? 0 : Integer.parseInt(newtsprid);
			currentSprid = cursprid.equals("") ? 0 : Integer.parseInt(cursprid);
			updatedSprid = newsprid.equals("") ? 0 : Integer.parseInt(newsprid);
			currentTmid = curtmid.equals("") ? 0 : Integer.parseInt(curtmid);
			updatedTmid = newtmid.equals("") ? 0 : Integer.parseInt(newtmid);
			currentTcid = curtcid.equals("") ? 0 : Integer.parseInt(curtcid);
			updatedTcid = newtcid.equals("") ? 0 : Integer.parseInt(newtcid);

			Recipe currentRecipe = new Recipe(currentSprid);
			TranslatedCuisine currentTranslatedCuisine = new TranslatedCuisine(currentTcid);
			TranslatedMethod currentTranslatedMethod = new TranslatedMethod(currentTmid);
			Language currentLanguage = new Language(curloc);
			TranslatedRecipe currentTranslatedRecipe = new TranslatedRecipe(currentTsprid, currentRecipe,
					currentTranslatedCuisine, currentTranslatedMethod, currentLanguage, cursprname);

			Recipe updatedRecipe = new Recipe(updatedSprid);
			TranslatedCuisine updatedTranslatedCuisine = new TranslatedCuisine(updatedTcid);
			TranslatedMethod updatedTranslatedMethod = new TranslatedMethod(updatedTmid);
			Language updatedLanguage = new Language(newloc);
			TranslatedRecipe updatedTranslatedRecipe = new TranslatedRecipe(updatedTsprid, updatedRecipe,
					updatedTranslatedCuisine, updatedTranslatedMethod, updatedLanguage, newsprname);

			success = recipeService.updateTranslatedRecipe(currentTranslatedRecipe, updatedTranslatedRecipe,
					TableType.SPANISH_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("updatedTranslatedSpanishRecipeRowsAffected", success);
		return "Update_Spanish_Recipe";
	}

	@RequestMapping("/viewGreekRecipesTable.ds")
	public ModelAndView viewGreekRecipes(Model model) {
		List<Recipe> recipes = null;
		try {
			recipes = recipeService.viewRecipesTable(TableType.GREEK_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("tableName", "Greek Recipes Table");
		model.addAttribute("columnName", "Recipe ID");
		return new ModelAndView("ViewRecipesTable", "recipeList", recipes);
	}

	@RequestMapping("/viewGlobalRecipesTable.ds")
	public ModelAndView viewGlobalRecipes(Model model) {
		List<Recipe> recipes = null;
		try {
			recipes = recipeService.viewRecipesTable(TableType.GLOBAL_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("tableName", "Global Recipes Table");
		model.addAttribute("columnName", "Recipe ID");
		return new ModelAndView("ViewRecipesTable", "recipeList", recipes);
	}

	@RequestMapping("/viewSpanishRecipesTable.ds")
	public ModelAndView viewSpanishRecipes(Model model) {
		List<Recipe> recipes = null;
		try {
			recipes = recipeService.viewRecipesTable(TableType.SPANISH_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("tableName", "Spanish Recipes Table");
		model.addAttribute("columnName", "Recipe ID");
		return new ModelAndView("ViewRecipesTable", "recipeList", recipes);
	}

	@RequestMapping("/viewGreekTranslatedRecipesTable.ds")
	public ModelAndView viewGreekTranslatedRecipes(Model model) {
		List<TranslatedRecipe> recipes = null;
		try {
			recipes = recipeService.viewTranslatedRecipesTable(TableType.GREEK_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("tableName", "Greek Translated Recipes Table");
		model.addAttribute("columnName1", "Translated Recipe ID");
		model.addAttribute("columnName2", "Recipe ID");
		model.addAttribute("columnName3", "Translated Cuisine ID");
		model.addAttribute("columnName4", "Translated Method ID");
		model.addAttribute("columnName5", "Locale");
		model.addAttribute("columnName6", "Translated Recipe Name");
		return new ModelAndView("ViewTranslatedRecipesTable", "translatedRecipeList", recipes);
	}

	@RequestMapping("/viewGlobalTranslatedRecipesTable.ds")
	public ModelAndView viewGlobalTranslatedRecipes(Model model) {
		List<TranslatedRecipe> recipes = null;
		try {
			recipes = recipeService.viewTranslatedRecipesTable(TableType.GLOBAL_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("tableName", "Global Translated Recipes Table");
		model.addAttribute("columnName1", "Translated Recipe ID");
		model.addAttribute("columnName2", "Recipe ID");
		model.addAttribute("columnName3", "Translated Cuisine ID");
		model.addAttribute("columnName4", "Translated Method ID");
		model.addAttribute("columnName5", "Locale");
		model.addAttribute("columnName6", "Translated Recipe Name");
		return new ModelAndView("ViewTranslatedRecipesTable", "translatedRecipeList", recipes);
	}

	@RequestMapping("/viewSpanishTranslatedRecipesTable.ds")
	public ModelAndView viewSpanishTranslatedRecipes(Model model) {
		List<TranslatedRecipe> recipes = null;
		try {
			recipes = recipeService.viewTranslatedRecipesTable(TableType.SPANISH_TABLE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("tableName", "Spanish Translated Recipes Table");
		model.addAttribute("columnName1", "Translated Recipe ID");
		model.addAttribute("columnName2", "Recipe ID");
		model.addAttribute("columnName3", "Translated Cuisine ID");
		model.addAttribute("columnName4", "Translated Method ID");
		model.addAttribute("columnName5", "Locale");
		model.addAttribute("columnName6", "Translated Recipe Name");
		return new ModelAndView("ViewTranslatedRecipesTable", "translatedRecipeList", recipes);
	}

}
