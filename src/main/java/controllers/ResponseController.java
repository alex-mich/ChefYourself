package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import pojos.RequestObject;
import pojos.TranslatedRecipe;
import services.ResponseService;

@Controller
public class ResponseController {

	@Autowired
	ResponseService responseService;
	
	 @RequestMapping(value = "test1.ds", method = RequestMethod.POST, produces = {
             "application/json;charset=UTF-8", "text/xml;charset=UTF-8",
             "application/x-www-form-urlencoded;charset=UTF-8"})
	 public @ResponseBody List<TranslatedRecipe> recipeResponse(@RequestBody String requestObject) {
		 Gson gson = new Gson();
		 RequestObject requestObject1 = gson.fromJson(requestObject, RequestObject.class);
		 return responseService.recipesResponse(requestObject1);
	 }
		 
}
