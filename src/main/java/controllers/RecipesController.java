package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pojos.Locale;
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
			success = recipeService.insertGreekRecipe(recipe);
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
			success = recipeService.insertGlobalRecipe(recipe);
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
			success = recipeService.insertSpanishRecipe(recipe);
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
			TranslatedRecipe transRecipe = new TranslatedRecipe();
			transRecipe.setTrid(tgrrid);

			Recipe recipe = new Recipe();
			recipe.setRid(grrid);
			transRecipe.setRecipe(recipe);

			TranslatedCuisine transCuisine = new TranslatedCuisine();
			transCuisine.setTcid(tcid);
			transRecipe.setTransCuisine(transCuisine);

			TranslatedMethod transMethod = new TranslatedMethod();
			transMethod.setTmid(tmid);
			transRecipe.setTransMethod(transMethod);

			Locale locale = new Locale();
			locale.setLoc(loc);
			transRecipe.setLocale(locale);

			transRecipe.setRname(grrname);

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
			TranslatedRecipe transRecipe = new TranslatedRecipe();
			transRecipe.setTrid(tglrid);

			Recipe recipe = new Recipe();
			recipe.setRid(glrid);
			transRecipe.setRecipe(recipe);

			TranslatedCuisine transCuisine = new TranslatedCuisine();
			transCuisine.setTcid(tcid);
			transRecipe.setTransCuisine(transCuisine);

			TranslatedMethod transMethod = new TranslatedMethod();
			transMethod.setTmid(tmid);
			transRecipe.setTransMethod(transMethod);

			Locale locale = new Locale();
			locale.setLoc(loc);
			transRecipe.setLocale(locale);

			transRecipe.setRname(glrname);

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
			TranslatedRecipe transRecipe = new TranslatedRecipe();
			transRecipe.setTrid(tsprid);

			Recipe recipe = new Recipe();
			recipe.setRid(sprid);
			transRecipe.setRecipe(recipe);

			TranslatedCuisine transCuisine = new TranslatedCuisine();
			transCuisine.setTcid(tcid);
			transRecipe.setTransCuisine(transCuisine);

			TranslatedMethod transMethod = new TranslatedMethod();
			transMethod.setTmid(tmid);
			transRecipe.setTransMethod(transMethod);

			Locale locale = new Locale();
			locale.setLoc(loc);
			transRecipe.setLocale(locale);

			transRecipe.setRname(sprname);

			success = recipeService.insertSpanishTranslatedRecipe(transRecipe);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("spanishTranslatedRecipesRowsAffected", success);
		return "Insert_Spanish_Recipe";
	}

	@RequestMapping(value = "insertGreekRecipeIngredients.ds", method = RequestMethod.POST)
	public String insertGreekRecipeIngredient(@RequestParam("griid") int griid,
			@RequestParam("tgrrid2") int tgrrid, @RequestParam("tinid") int tinid,
			@RequestParam("grriquan") String grriquan, Model model) {

		int success = 0;

		try {
			RecipeIngredient recipeIngredient = new RecipeIngredient();
			recipeIngredient.setRiid(griid);

			TranslatedRecipe translatedRecipe = new TranslatedRecipe(tgrrid);
			recipeIngredient.setTrRecipe(translatedRecipe);

			TranslatedIngredient translatedIngredient = new TranslatedIngredient(tinid);
			recipeIngredient.setTrIngredient(translatedIngredient);

			recipeIngredient.setQuan(grriquan);

			success = recipeIngredientsService.insertGreekRecipeIngredient(recipeIngredient);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("greekRecipeIngredientsRowsAffected", success);
		return "Insert_Greek_Recipe";
	}

	@RequestMapping(value = "insertGlobalRecipeIngredients.ds", method = RequestMethod.POST)
	public String insertGlobalRecipeIngredient(@RequestParam("gliid") int gliid,
			@RequestParam("tglrid2") int tglrid, @RequestParam("tinid") int tinid,
			@RequestParam("glriquan") String glriquan, Model model) {

		int success = 0;

		try {
			RecipeIngredient recipeIngredient = new RecipeIngredient();
			recipeIngredient.setRiid(gliid);

			TranslatedRecipe translatedRecipe = new TranslatedRecipe(tglrid);
			recipeIngredient.setTrRecipe(translatedRecipe);

			TranslatedIngredient translatedIngredient = new TranslatedIngredient(tinid);
			recipeIngredient.setTrIngredient(translatedIngredient);

			recipeIngredient.setQuan(glriquan);

			success = recipeIngredientsService.insertGlobalRecipeIngredient(recipeIngredient);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("globalRecipeIngredientsRowsAffected", success);
		return "Insert_Global_Recipe";
	}

	@RequestMapping(value = "insertSpanishRecipeIngredients.ds", method = RequestMethod.POST)
	public String insertSpanishRecipeIngredient(@RequestParam("spiid") int spiid,
			@RequestParam("tsprid2") int tsprid, @RequestParam("tinid") int tinid,
			@RequestParam("spriquan") String spriquan, Model model) {

		int success = 0;

		try {
			RecipeIngredient recipeIngredient = new RecipeIngredient();
			recipeIngredient.setRiid(spiid);

			TranslatedRecipe translatedRecipe = new TranslatedRecipe(tsprid);
			recipeIngredient.setTrRecipe(translatedRecipe);

			TranslatedIngredient translatedIngredient = new TranslatedIngredient(tinid);
			recipeIngredient.setTrIngredient(translatedIngredient);

			recipeIngredient.setQuan(spriquan);

			success = recipeIngredientsService.insertSpanishRecipeIngredient(recipeIngredient);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("spanishRecipeIngredientsRowsAffected", success);
		return "Insert_Spanish_Recipe";
	}

	@RequestMapping(value = "/insertGreekRecipeDescription.ds", method = RequestMethod.POST)
	public String insertGreekRecipeDescription(@RequestParam("grrdid") int grrdid,
			@RequestParam("tgrrid3") int tgrrid, @RequestParam("grrdesc") String grrdesc, Model model) {

		int success = 0;

		try {
			RecipeDescription recipeDescription = new RecipeDescription();
			recipeDescription.setRdid(grrdid);

			TranslatedRecipe translatedRecipe = new TranslatedRecipe(tgrrid);
			recipeDescription.setTrRecipe(translatedRecipe);

			recipeDescription.setDesc(grrdesc);

			success = descriptionsService.insertGreekRecipeDescription(recipeDescription);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("greekDescriptionRowsAffected", success);
		return "Insert_Greek_Recipe";
	}

	@RequestMapping(value = "insertGlobalRecipeDescription.ds", method = RequestMethod.POST)
	public String insertGlobalRecipeDescription(@RequestParam("glrdid") int glrdid,
			@RequestParam("tglrid3") int tglrid, @RequestParam("glrdesc") String glrdesc, Model model) {

		int success = 0;

		try {
			RecipeDescription recipeDescription = new RecipeDescription();
			recipeDescription.setRdid(glrdid);

			TranslatedRecipe translatedRecipe = new TranslatedRecipe(tglrid);
			recipeDescription.setTrRecipe(translatedRecipe);

			recipeDescription.setDesc(glrdesc);

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
			RecipeDescription recipeDescription = new RecipeDescription();
			recipeDescription.setRdid(sprdid);

			TranslatedRecipe translatedRecipe = new TranslatedRecipe(tsprid);
			recipeDescription.setTrRecipe(translatedRecipe);

			recipeDescription.setDesc(sprdesc);

			success = descriptionsService.insertSpanishRecipeDescription(recipeDescription);
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("spanishDescriptionRowsAffected", success);
		return "Insert_Spanish_Recipe";
	}
	
	@RequestMapping(value = "deleteGreekRecipe.ds", method = RequestMethod.POST)
	public String deleteGreekRecipe(@RequestParam("grrid1") int grrid, Model model){
		
		int success = 0;
		
		try{
			Recipe recipe = new Recipe(grrid);
			success = recipeService.deleteGreekRecipe(recipe);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		model.addAttribute("deletedGreekRecipesRowsAffected", success);
		return "Delete_Greek_Recipe";
	}
	
	@RequestMapping(value = "deleteGlobalRecipe.ds", method = RequestMethod.POST)
	public String deleteGlobalRecipe(@RequestParam("glrid1") int glrid, Model model){
		
		int success = 0;
		
		try{
			Recipe recipe = new Recipe(glrid);
			success = recipeService.deleteGlobalRecipe(recipe);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		model.addAttribute("deletedGlobalRecipesRowsAffected", success);
		return "Delete_Global_Recipe";
	}
	
	@RequestMapping(value = "deleteSpanishRecipe.ds", method = RequestMethod.POST)
	public String deleteSpanishRecipe(@RequestParam("sprid1") int sprid, Model model){
		
		int success = 0;
		
		try{
			Recipe recipe = new Recipe(sprid);
			success = recipeService.deleteSpanishRecipe(recipe);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		model.addAttribute("deletedSpanishRecipesRowsAffected", success);
		return "Delete_Spanish_Recipe";
	}
	
	@RequestMapping(value = "deleteGreekRecipeTrans.ds", method = RequestMethod.POST)
	public String deleteGreekTranslatedRecipe(@RequestParam("tgrrid") int tgrrid, Model model){
		
		int success = 0;
		
		try{
			TranslatedRecipe trRecipe = new TranslatedRecipe(tgrrid);
			success = recipeService.deleteGreekTranslatedRecipe(trRecipe);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		model.addAttribute("deletedGreekTranslatedRecipesRowsAffected", success);
		return "Delete_Greek_Recipe";
	}
	
	@RequestMapping(value = "deleteGlobalRecipeTrans.ds", method = RequestMethod.POST)
	public String deleteGlobalTranslatedRecipe(@RequestParam("tglrid") int tglrid, Model model){
		
		int success = 0;
		
		try{
			TranslatedRecipe trRecipe = new TranslatedRecipe(tglrid);
			success = recipeService.deleteGlobalTranslatedRecipe(trRecipe);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		model.addAttribute("deletedGlobalTranslatedRecipesRowsAffected", success);
		return "Delete_Global_Recipe";
	}
	
	@RequestMapping(value = "deleteSpanishRecipeTrans.ds", method = RequestMethod.POST)
	public String deleteSpanishTranslatedRecipe(@RequestParam("tsprid") int tsprid, Model model){
		
		int success = 0;
		
		try{
			TranslatedRecipe trRecipe = new TranslatedRecipe(tsprid);
			success = recipeService.deleteSpanishTranslatedRecipe(trRecipe);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		model.addAttribute("deletedSpanishTranslatedRecipesRowsAffected", success);
		return "Delete_Spanish_Recipe";
	}
	
	@RequestMapping(value = "deleteGreekRecipeIngredient.ds", method = RequestMethod.POST)
	public String deleteGreekRecipeIngredient(@RequestParam("griid") int griid, Model model){
		
		int success = 0;
		
		try{
			RecipeIngredient recipeIngredient = new RecipeIngredient(griid);
			success = recipeIngredientsService.deleteGreekRecipeIngredient(recipeIngredient);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		model.addAttribute("deletedGreekRecipeIngredientsRowsAffected", success);
		return "Delete_Greek_Recipe";
	}
	
	@RequestMapping(value = "deleteGlobalRecipeIngredient.ds", method = RequestMethod.POST)
	public String deleteGlobalRecipeIngredient(@RequestParam("gliid") int gliid, Model model){
		
		int success = 0;
		
		try{
			RecipeIngredient recipeIngredient = new RecipeIngredient(gliid);
			success = recipeIngredientsService.deleteGlobalRecipeIngredient(recipeIngredient);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		model.addAttribute("deletedGlobalRecipeIngredientsRowsAffected", success);
		return "Delete_Global_Recipe";
	}
	
	@RequestMapping(value = "deleteSpanishRecipeIngredient.ds", method = RequestMethod.POST)
	public String deleteSpanishRecipeIngredient(@RequestParam("spiid") int spiid, Model model){
		
		int success = 0;
		
		try{
			RecipeIngredient recipeIngredient = new RecipeIngredient(spiid);
			success = recipeIngredientsService.deleteSpanishRecipeIngredient(recipeIngredient);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		model.addAttribute("deletedSpanishRecipeIngredientsRowsAffected", success);
		return "Delete_Spanish_Recipe";
	}
	
	@RequestMapping(value = "deleteGreekRecipeDescription.ds", method = RequestMethod.POST)
	public String deleteGreekRecipeDescription(@RequestParam("grrdid") int grrdid, Model model){
		
		int success = 0;
		
		try{
			RecipeDescription recipeDescription = new RecipeDescription(grrdid);
			success = descriptionsService.deleteGreekRecipeDescription(recipeDescription);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		model.addAttribute("deletedGreekRecipeDescriptionRowsAffected", success);
		return "Delete_Greek_Recipe";
	}
	
	@RequestMapping(value = "deleteGlobalRecipeDescription.ds", method = RequestMethod.POST)
	public String deleteGlobalRecipeDescription(@RequestParam("glrdid") int glrdid, Model model){
		
		int success = 0;
		
		try{
			RecipeDescription recipeDescription = new RecipeDescription(glrdid);
			success = descriptionsService.deleteGlobalRecipeDescription(recipeDescription);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		model.addAttribute("deletedGlobalRecipeDescriptionRowsAffected", success);
		return "Delete_Global_Recipe";
	}
	
	@RequestMapping(value = "deleteSpanishRecipeDescription.ds", method = RequestMethod.POST)
	public String deleteSpanishRecipeDescription(@RequestParam("sprdid") int sprdid, Model model){
		
		int success = 0;
		
		try{
			RecipeDescription recipeDescription = new RecipeDescription(sprdid);
			success = descriptionsService.deleteSpanishRecipeDescription(recipeDescription);
		}catch (Exception e){
			e.printStackTrace();
		}
		
		model.addAttribute("deletedSpanishRecipeDescriptionRowsAffected", success);
		return "Delete_Spanish_Recipe";
	}
	
}
	
