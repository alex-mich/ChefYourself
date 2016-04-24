package services;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import impl.CuisinesDAOImpl;
import pojos.Cuisine;
import pojos.TranslatedCuisine;

@Service
public class CuisinesService {
	
	public CuisinesService(){}
	
	public int insertCuisine(Cuisine cui) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		CuisinesDAOImpl cuisinesDAOImpl = (CuisinesDAOImpl) context.getBean("cuisinesDAOImpl");
		return cuisinesDAOImpl.insertCuisine(cui);	
	}
	
	public int insertTranslatedCuisine(TranslatedCuisine tcui) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		CuisinesDAOImpl cuisinesDAOImpl = (CuisinesDAOImpl) context.getBean("cuisinesDAOImpl");
		return cuisinesDAOImpl.insertTranslatedCuisine(tcui);
	}
	
	public List<Cuisine> findAllCuisines() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		CuisinesDAOImpl cuisinesDAOImpl = (CuisinesDAOImpl) context.getBean("cuisinesDAOImpl");
		return cuisinesDAOImpl.findAllCuisines();
	}
	
	public List<TranslatedCuisine> findGrCuisines() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		CuisinesDAOImpl cuisinesDAOImpl = (CuisinesDAOImpl) context.getBean("cuisinesDAOImpl");
		return cuisinesDAOImpl.findGrCuisines();
	}
	
	public List<TranslatedCuisine> findEnCuisines() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		CuisinesDAOImpl cuisinesDAOImpl = (CuisinesDAOImpl) context.getBean("cuisinesDAOImpl");
		return cuisinesDAOImpl.findEnCuisines();
	}

}
