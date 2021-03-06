package services;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import impl.MethodsDAOImpl;
import pojos.Method;
import pojos.TranslatedMethod;

@Service
public class MethodsService {
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	MethodsDAOImpl methodsDAOImpl = (MethodsDAOImpl) context.getBean("methodsDAOImpl");
	
	public int insertMethod(Method method) throws Exception {
		return methodsDAOImpl.insertMethod(method);	
	}
	
	public int insertTranslatedMethod(TranslatedMethod tMethod) throws Exception {
		return methodsDAOImpl.insertTranslatedMethod(tMethod);
	}
	
	public int deleteMethod(Method method) throws Exception {
		return methodsDAOImpl.deleteMethod(method);	
	}
	
	public int deleteTranslatedMethod(TranslatedMethod tMethod) throws Exception {
		return methodsDAOImpl.deleteTranslatedMethod(tMethod);
	}
	
	public int updateMethod(Method currentMethod, Method updatedMethod) throws Exception {
		return methodsDAOImpl.updateMethod(currentMethod,updatedMethod);
	}
	
	public int updateTranslatedMethod(TranslatedMethod currentTranslatedMethod, TranslatedMethod updatedTranslatedMethod) throws Exception {
		return methodsDAOImpl.updateTranslatedMethod(currentTranslatedMethod,updatedTranslatedMethod);
	}
	
	public List<Method> viewMethodsTable() throws Exception {
		return methodsDAOImpl.viewMethodsTable();	
	}
	
	public List<TranslatedMethod> viewTranslatedMethodsTable() throws Exception {
		return methodsDAOImpl.viewTranslatedMethodsTable();	
	}
	
}
