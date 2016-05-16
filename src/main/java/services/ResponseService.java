package services;

import java.util.List;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import impl.ResponseDAOImpl;
import pojos.RequestObject;
import pojos.TranslatedRecipe;

@Service
public class ResponseService {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	ResponseDAOImpl  responseDAOImpl = (ResponseDAOImpl) context.getBean("responseDAOImpl");
	
	public List<TranslatedRecipe> recipesResponse(RequestObject requestObject) {
		return responseDAOImpl.recipesResponse(requestObject);
	}
	
}
