package services;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import impl.ResponseDAOImpl;
import pojos.Language;
import pojos.RequestObject;
import pojos.ResponseObject;
import pojos.TranslatedIngredient;

@Service
public class ResponseService {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	ResponseDAOImpl  responseDAOImpl = (ResponseDAOImpl) context.getBean("responseDAOImpl");
	
	public ResponseObject recipesResponse(RequestObject requestObject) {
		return responseDAOImpl.recipesResponse(requestObject);
	}
	
	public List<TranslatedIngredient> ingredientsResponse(Language language) {
		return responseDAOImpl.ingredientsResponse(language);
	}
	
}
