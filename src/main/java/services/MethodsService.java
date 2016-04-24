package services;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import impl.MethodsDAOImpl;
import pojos.Method;
import pojos.TranslatedMethod;

@Service
public class MethodsService {

	public MethodsService(){}
	
	public int insertMethod(Method method) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		MethodsDAOImpl methodsDAOImpl = (MethodsDAOImpl) context.getBean("methodsDAOImpl");
		return methodsDAOImpl.insertMethod(method);	
	}
	
	public int insertTranslatedMethod(TranslatedMethod tMethod) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		MethodsDAOImpl methodsDAOImpl = (MethodsDAOImpl) context.getBean("methodsDAOImpl");
		return methodsDAOImpl.insertTranslatedMethod(tMethod);
	}
	
	public List<Method> findAllMethods() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		MethodsDAOImpl methodsDAOImpl = (MethodsDAOImpl) context.getBean("methodsDAOImpl");
		return methodsDAOImpl.findAllMethods();
	}
	
	public List<TranslatedMethod> findGrMethods() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		MethodsDAOImpl methodsDAOImpl = (MethodsDAOImpl) context.getBean("methodsDAOImpl");
		return methodsDAOImpl.findGrMethods();
	}
	
	public List<TranslatedMethod> findEnMethods() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		MethodsDAOImpl methodsDAOImpl = (MethodsDAOImpl) context.getBean("methodsDAOImpl");
		return methodsDAOImpl.findEnMethods();
	}
}
