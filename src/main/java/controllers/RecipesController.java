package controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "insertGreekRecipe.ds", method = RequestMethod.GET)
	public ModelAndView insertGreekRecipe(@RequestParam("grrid1") int grrid) throws Exception {

		int success = 0;
		try {
			Recipe recipe = new Recipe(grrid);
			success = recipeService.insertGreekRecipe(recipe);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("msg", success);
		ModelAndView mav = new ModelAndView("returnRows1.ds", m);

		return mav;
	}

	@RequestMapping(value = "insertGlobalRecipe.ds", method = RequestMethod.GET)
	public ModelAndView insertGlobalRecipe(@RequestParam("glrid1") int glrid) throws Exception {

		int success = 0;
		try {
			Recipe recipe = new Recipe(glrid);
			success = recipeService.insertGlobalRecipe(recipe);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, String> m = new HashMap<String, String>();
		m.put("msg", "Hello: " + success);
		ModelAndView mav = new ModelAndView("fail", m);

		return mav;
	}

	@RequestMapping(value = "insertSpanishRecipe.ds", method = RequestMethod.GET)
	public ModelAndView insertSpanishRecipe(@RequestParam("sprid1") int sprid) throws Exception {

		int success = 0;
		try {
			Recipe recipe = new Recipe(sprid);
			success = recipeService.insertSpanishRecipe(recipe);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, String> m = new HashMap<String, String>();
		m.put("msg", "Hello: " + success);
		ModelAndView mav = new ModelAndView("fail", m);

		return mav;
	}

	@RequestMapping(value = "insertGreekRecipeTrans.ds", method = RequestMethod.GET)
	public ModelAndView insertGreekRecipeTrans(@RequestParam("tgrrid") int tgrrid, @RequestParam("grrid2") int grrid,
			@RequestParam("tcid") int tcid, @RequestParam("tmid") int tmid, @RequestParam("loc") String loc,
			@RequestParam("grrname") String grrname) throws Exception {

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

		Map<String, String> m = new HashMap<String, String>();
		m.put("msg", "Hello: " + success);
		ModelAndView mav = new ModelAndView("fail", m);

		return mav;
	}

	@RequestMapping(value = "insertGlobalRecipeTrans.ds", method = RequestMethod.GET)
	public ModelAndView insertGlobalRecipeTrans(@RequestParam("tglrid") int tglrid, @RequestParam("glrid2") int glrid,
			@RequestParam("tcid") int tcid, @RequestParam("tmid") int tmid, @RequestParam("loc") String loc,
			@RequestParam("glrname") String glrname) throws Exception {

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

		Map<String, String> m = new HashMap<String, String>();
		m.put("msg", "Hello: " + success);
		ModelAndView mav = new ModelAndView("fail", m);

		return mav;
	}

	@RequestMapping(value = "insertSpanishRecipeTrans.ds", method = RequestMethod.GET)
	public ModelAndView insertSpanishRecipeTrans(@RequestParam("tsprid") int tsprid, @RequestParam("sprid2") int sprid,
			@RequestParam("tcid") int tcid, @RequestParam("tmid") int tmid, @RequestParam("loc") String loc,
			@RequestParam("sprname") String sprname) throws Exception {

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

		Map<String, String> m = new HashMap<String, String>();
		m.put("msg", "Hello: " + success);
		ModelAndView mav = new ModelAndView("fail", m);

		return mav;
	}

	@RequestMapping(value = "insertGreekRecipeIngredients.ds", method = RequestMethod.GET)
	public ModelAndView insertGreekRecipeIngredient(@RequestParam("griid") int griid,
			@RequestParam("tgrrid2") int tgrrid, @RequestParam("tinid") int tinid,
			@RequestParam("grriquan") String grriquan) {

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

		Map<String, String> m = new HashMap<String, String>();
		m.put("msg", "Hello: " + success);
		ModelAndView mav = new ModelAndView("fail", m);

		return mav;
	}

	@RequestMapping(value = "insertGlobalRecipeIngredients.ds", method = RequestMethod.GET)
	public ModelAndView insertGlobalRecipeIngredient(@RequestParam("gliid") int gliid,
			@RequestParam("tglrid2") int tglrid, @RequestParam("tinid") int tinid,
			@RequestParam("glriquan") String glriquan) {

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

		Map<String, String> m = new HashMap<String, String>();
		m.put("msg", "Hello: " + success);
		ModelAndView mav = new ModelAndView("fail", m);

		return mav;
	}

	@RequestMapping(value = "insertSpanishRecipeIngredients.ds", method = RequestMethod.GET)
	public ModelAndView insertSpanishRecipeIngredient(@RequestParam("spiid") int spiid,
			@RequestParam("tsprid2") int tsprid, @RequestParam("tinid") int tinid,
			@RequestParam("spriquan") String spriquan) {

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

		Map<String, String> m = new HashMap<String, String>();
		m.put("msg", "Hello: " + success);
		ModelAndView mav = new ModelAndView("fail", m);

		return mav;
	}

	@RequestMapping(value = "/insertGreekRecipeDescription.ds", method = RequestMethod.GET)
	public ModelAndView insertGreekRecipeDescription(@RequestParam("grrdid") int grrdid,
			@RequestParam("tgrrid3") int tgrrid, @RequestParam("grrdesc") String grrdesc) {
		
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

		Map<String, String> m = new HashMap<String, String>();
		m.put("msg", "Hello: " + success);
		ModelAndView mav = new ModelAndView("fail", m);

		return mav;
	}

	@RequestMapping(value = "/insertGlobalRecipeDescription.ds", method = RequestMethod.GET)
	public ModelAndView insertGlobalRecipeDescription(@RequestParam("glrdid") int glrdid,
			@RequestParam("tglrid3") int tglrid, @RequestParam("glrdesc") String glrdesc) {
		
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

		Map<String, String> m = new HashMap<String, String>();
		m.put("msg", "Hello: " + success);
		ModelAndView mav = new ModelAndView("fail", m);

		return mav;
	}

	@RequestMapping(value = "/insertSpanishRecipeDescription.ds", method = RequestMethod.GET)
	public ModelAndView insertSpanishRecipeDescription(@RequestParam("sprdid") int sprdid,
			@RequestParam("tsprid3") int tsprid, @RequestParam("sprdesc") String sprdesc) {
		
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

		Map<String, String> m = new HashMap<String, String>();
		m.put("msg", "Hello: " + success);
		ModelAndView mav = new ModelAndView("fail", m);

		return mav;
	}
}
