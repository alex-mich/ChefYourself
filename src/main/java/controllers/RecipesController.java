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
import pojos.TranslatedCuisine;
import pojos.TranslatedMethod;
import pojos.TranslatedRecipe;
import services.RecipesService;

@Controller
public class RecipesController {

	@Autowired
	RecipesService recipeService;

	@RequestMapping(value = "insertGreekRecipe.ds", method = RequestMethod.GET)
	public ModelAndView insertGreekRecipe(@RequestParam("grrid1") int rid) throws Exception {

		int success = 0;
		try {
			Recipe recipe = new Recipe(rid);
			success = recipeService.insertGrRecipe(recipe);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, String> m = new HashMap<String, String>();
		m.put("msg", "Hello: " + rid);
		ModelAndView mav = new ModelAndView("fail", m);

		return mav;
	}

	@RequestMapping(value = "insertGlobalRecipe.ds", method = RequestMethod.GET)
	public ModelAndView insertGlobalRecipe(@RequestParam("glrid1") int rid) throws Exception {

		int success = 0;
		try {
			Recipe recipe = new Recipe(rid);
			success = recipeService.insertGlRecipe(recipe);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, String> m = new HashMap<String, String>();
		m.put("msg", "Hello: " + rid);
		ModelAndView mav = new ModelAndView("fail", m);

		return mav;
	}

	@RequestMapping(value = "insertSpanishRecipe.ds", method = RequestMethod.GET)
	public ModelAndView insertSpanishRecipe(@RequestParam("sprid1") int rid) throws Exception {

		int success = 0;
		try {
			Recipe recipe = new Recipe(rid);
			success = recipeService.insertSpRecipe(recipe);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, String> m = new HashMap<String, String>();
		m.put("msg", "Hello: " + success);
		ModelAndView mav = new ModelAndView("fail", m);

		return mav;
	}

	@RequestMapping(value = "insertGreekRecipeTrans.ds", method = RequestMethod.GET)
	public ModelAndView insertGreekRecipeTrans(@RequestParam("tgrrid") int trid, @RequestParam("grrid2") int rid,
			@RequestParam("tcid") int tcid, @RequestParam("tmid") int tmid, @RequestParam("loc") String loc,
			@RequestParam("grrname") String grrname) throws Exception {

		int success = 0;
		try {
			TranslatedRecipe transRecipe = new TranslatedRecipe();
			transRecipe.setTrid(trid);
			
			Recipe recipe = new Recipe();
			recipe.setRid(rid);
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
			
			success = recipeService.insertGreekRecipe(transRecipe);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, String> m = new HashMap<String, String>();
		m.put("msg", "Hello: " + grrname);
		ModelAndView mav = new ModelAndView("fail", m);

		return mav;
	}
	
	@RequestMapping(value = "insertGlobalRecipeTrans.ds", method = RequestMethod.GET)
	public ModelAndView insertGlobalRecipeTrans(@RequestParam("tglrid") int trid, @RequestParam("glrid2") int rid,
			@RequestParam("tcid") int tcid, @RequestParam("tmid") int tmid, @RequestParam("loc") String loc,
			@RequestParam("glrname") String grrname) throws Exception {

		int success = 0;
		try {
			TranslatedRecipe transRecipe = new TranslatedRecipe();
			transRecipe.setTrid(trid);
			
			Recipe recipe = new Recipe();
			recipe.setRid(rid);
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
			
			success = recipeService.insertGreekRecipe(transRecipe);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, String> m = new HashMap<String, String>();
		m.put("msg", "Hello: " + grrname);
		ModelAndView mav = new ModelAndView("fail", m);

		return mav;
	}
	
	@RequestMapping(value = "insertSpanishRecipeTrans.ds", method = RequestMethod.GET)
	public ModelAndView insertSpanishRecipeTrans(@RequestParam("tsprid") int trid, @RequestParam("sprid2") int rid,
			@RequestParam("tcid") int tcid, @RequestParam("tmid") int tmid, @RequestParam("loc") String loc,
			@RequestParam("sprname") String grrname) throws Exception {

		int success = 0;
		try {
			TranslatedRecipe transRecipe = new TranslatedRecipe();
			transRecipe.setTrid(trid);
			
			Recipe recipe = new Recipe();
			recipe.setRid(rid);
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
			
			success = recipeService.insertGreekRecipe(transRecipe);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String, String> m = new HashMap<String, String>();
		m.put("msg", "Hello: " + grrname);
		ModelAndView mav = new ModelAndView("fail", m);

		return mav;
	}

}
