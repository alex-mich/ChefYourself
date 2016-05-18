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
import pojos.RecipeDescription;
import pojos.RecipeIngredient;
import pojos.TranslatedCuisine;
import pojos.TranslatedIngredient;
import pojos.TranslatedMethod;
import pojos.TranslatedRecipe;
import services.DescriptionsService;
import services.RecipeIngredientsService;
import services.RecipesService;

@Controller
public class RecipesController {

	@Autowired
	RecipesService recipeService;

	@Autowired
	RecipeIngredientsService recipeIngredientsService;

	@Autowired
	DescriptionsService descriptionsService;

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

	@RequestMapping(value = "insertGreekRecipeIngredients.ds", method = RequestMethod.POST)
	public String insertGreekRecipeIngredient(@RequestParam("griid") int griid, @RequestParam("tgrrid2") int tgrrid,
			@RequestParam("tinid") int tinid, @RequestParam("grriquan") String grriquan, Model model) {

		int success = 0;

		try {
			TranslatedRecipe translatedRecipe = new TranslatedRecipe(tgrrid);
			TranslatedIngredient translatedIngredient = new TranslatedIngredient(tinid);
			RecipeIngredient recipeIngredient = new RecipeIngredient(griid, translatedRecipe, translatedIngredient,
					grriquan);
			success = recipeIngredientsService.insertGreekRecipeIngredient(recipeIngredient);
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
			success = recipeIngredientsService.insertGlobalRecipeIngredient(recipeIngredient);
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
			success = recipeIngredientsService.insertSpanishRecipeIngredient(recipeIngredient);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("spanishRecipeIngredientsRowsAffected", success);
		return "Insert_Spanish_Recipe";
	}

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

	@RequestMapping(value = "deleteGreekRecipeIngredient.ds", method = RequestMethod.POST)
	public String deleteGreekRecipeIngredient(@RequestParam("griid") int griid, Model model) {

		int success = 0;

		try {
			RecipeIngredient recipeIngredient = new RecipeIngredient(griid);
			success = recipeIngredientsService.deleteGreekRecipeIngredient(recipeIngredient);
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
			success = recipeIngredientsService.deleteGlobalRecipeIngredient(recipeIngredient);
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
			success = recipeIngredientsService.deleteSpanishRecipeIngredient(recipeIngredient);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("deletedSpanishRecipeIngredientsRowsAffected", success);
		return "Delete_Spanish_Recipe";
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

}
