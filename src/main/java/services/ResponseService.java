package services;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import impl.ResponseDAOImpl;
import pojos.RequestObject;
import pojos.ResponseObject;

@Service
public class ResponseService {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	ResponseDAOImpl  responseDAOImpl = (ResponseDAOImpl) context.getBean("responseDAOImpl");
	
	public ResponseObject recipesResponse(RequestObject requestObject) {
		return responseDAOImpl.recipesResponse(requestObject);
	}
	
}
