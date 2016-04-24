package services;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import impl.IngredientsDAOImpl;
import impl.MethodsDAOImpl;
import pojos.Ingredient;
import pojos.Method;
import pojos.TranslatedIngredient;
import pojos.TranslatedMethod;

@Service
public class IngredientsService {

public IngredientsService(){}
	
	public int insertIngredient(Ingredient in) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		IngredientsDAOImpl ingredientsDAOImpl = (IngredientsDAOImpl) context.getBean("ingredientsDAOImpl");
		return ingredientsDAOImpl.insertIngredient(in);	
	}
	
	public int insertTranslatedIngredient(TranslatedIngredient tin) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		IngredientsDAOImpl ingredientsDAOImpl = (IngredientsDAOImpl) context.getBean("ingredientsDAOImpl");
		return ingredientsDAOImpl.insertTranslatedIngredient(tin);
	}
	
	public List<Ingredient> findAllIngredients() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		IngredientsDAOImpl ingredientsDAOImpl = (IngredientsDAOImpl) context.getBean("ingredientsDAOImpl");
		return ingredientsDAOImpl.findAllIngredients();
	}
	
	public List<TranslatedIngredient> findGrIngredients() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		IngredientsDAOImpl ingredientsDAOImpl = (IngredientsDAOImpl) context.getBean("ingredientsDAOImpl");
		return ingredientsDAOImpl.findGrIngredients();
	}
	
	public List<TranslatedIngredient> findEnIngredients() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		IngredientsDAOImpl ingredientsDAOImpl = (IngredientsDAOImpl) context.getBean("ingredientsDAOImpl");
		return ingredientsDAOImpl.findEnIngredients();
	}
}
