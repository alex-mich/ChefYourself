package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pojos.RequestObject;
import pojos.TranslatedRecipe;
import services.ResponseService;

@Controller
public class ResponseController {

	@Autowired
	ResponseService responseService;
	
	 @RequestMapping(value = "test.ds", method = RequestMethod.POST)
	 public @ResponseBody List<TranslatedRecipe> recipeResponse(@RequestBody RequestObject requestObject) {
		 return responseService.recipesResponse(requestObject);
	 }
		 
}
