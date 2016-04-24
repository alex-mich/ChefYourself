package controllers;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pojos.Recipe;
import services.RecipesService;

@Controller
public class RecipesController {

	@Autowired
	RecipesService recipeService;

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView insertGreekRecipe(@RequestParam("grrid1") int rid) throws Exception{
		
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
	
}
