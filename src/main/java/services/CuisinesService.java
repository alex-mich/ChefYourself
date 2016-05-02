package services;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import impl.CuisinesDAOImpl;
import pojos.Cuisine;
import pojos.TranslatedCuisine;

@Service
public class CuisinesService {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	CuisinesDAOImpl cuisinesDAOImpl = (CuisinesDAOImpl) context.getBean("cuisinesDAOImpl");
	
	public int insertCuisine(Cuisine cuisine) throws Exception {
		return cuisinesDAOImpl.insertCuisine(cuisine);	
	}
	
	public int insertTranslatedCuisine(TranslatedCuisine translatedCuisine) throws Exception {
		return cuisinesDAOImpl.insertTranslatedCuisine(translatedCuisine);
	}
	
	public List<Cuisine> findAllCuisines() throws Exception {
		return cuisinesDAOImpl.findAllCuisines();
	}
	
	public List<TranslatedCuisine> findGrCuisines() throws Exception {
		return cuisinesDAOImpl.findGrCuisines();
	}
	
	public List<TranslatedCuisine> findEnCuisines() throws Exception {
		return cuisinesDAOImpl.findEnCuisines();
	}
	
	public int deleteCuisine(Cuisine cuisine) throws Exception {
		return cuisinesDAOImpl.deleteCuisine(cuisine);
	}
	
	public int deleteTranslatedCuisine(TranslatedCuisine translatedCuisine) throws Exception {
		return cuisinesDAOImpl.deleteTranslatedCuisine(translatedCuisine);
	}
}
