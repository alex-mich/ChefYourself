package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import pojos.RequestObject;
import pojos.ResponseObject;
import services.ResponseService;

@Controller
public class ResponseController {

	@Autowired
	ResponseService responseService;
	
	 @RequestMapping(value="/android.ds", method = RequestMethod.POST)
	 public @ResponseBody ResponseObject recipeResponse(@RequestBody String requestObject) {
		 Gson gson = new Gson();
		 RequestObject requestObject1 = gson.fromJson(requestObject, RequestObject.class);
		 ResponseObject responseObject = responseService.recipesResponse(requestObject1);
		 return responseObject;
	 }
		 
}
