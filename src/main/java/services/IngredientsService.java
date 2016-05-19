package services;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import impl.IngredientsDAOImpl;
import pojos.Ingredient;
import pojos.TranslatedIngredient;

@Service
public class IngredientsService {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	IngredientsDAOImpl ingredientsDAOImpl = (IngredientsDAOImpl) context.getBean("ingredientsDAOImpl");

	public int insertIngredient(Ingredient ingredient) throws Exception {
		return ingredientsDAOImpl.insertIngredient(ingredient);
	}

	public int insertTranslatedIngredient(TranslatedIngredient translatedIngredient) throws Exception {
		return ingredientsDAOImpl.insertTranslatedIngredient(translatedIngredient);
	}

	public List<Ingredient> findAllIngredients() throws Exception {
		return ingredientsDAOImpl.findAllIngredients();
	}

	public List<TranslatedIngredient> findAllTranslatedIngredients() throws Exception {
		return ingredientsDAOImpl.findAllTranslatedIngredients();
	}

	public List<TranslatedIngredient> findGrIngredients() throws Exception {
		return ingredientsDAOImpl.findGrIngredients();
	}

	public List<TranslatedIngredient> findEnIngredients() throws Exception {
		return ingredientsDAOImpl.findEnIngredients();
	}

	public int deleteIngredient(Ingredient ingredient) throws Exception {
		return ingredientsDAOImpl.deleteIngredient(ingredient);
	}

	public int deleteTranslatedIngredient(TranslatedIngredient translatedIngredient) throws Exception {
		return ingredientsDAOImpl.deleteTranslatedIngredient(translatedIngredient);
	}

	public int updateIngredient(Ingredient currentIngredient, Ingredient updatedIngredient) throws Exception {
		return ingredientsDAOImpl.updateIngredient(currentIngredient, updatedIngredient);
	}

	public int updateTranslatedIngredient(TranslatedIngredient currentTranslatedIngredient,
			TranslatedIngredient updatedTranslatedIngrediente) throws Exception {
		return ingredientsDAOImpl.updateTranslatedIngredient(currentTranslatedIngredient, updatedTranslatedIngrediente);
	}

	public List<Ingredient> viewIngredientsTable() throws Exception {
		return ingredientsDAOImpl.viewIngredientsTable();
	}

	public List<TranslatedIngredient> viewTranslatedIngredientsTable() throws Exception {
		return ingredientsDAOImpl.viewTranslatedIngredientsTable();
	}
}
