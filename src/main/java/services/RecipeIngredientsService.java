package services;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import impl.RecipeIngredientsDAOImpl;
import pojos.RecipeIngredient;

@Service
public class RecipeIngredientsService {

	RecipeIngredientsService() {
	}

	public int insertGreekRecipeIngredient(RecipeIngredient ri) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipeIngredientsDAOImpl recipeIngredientsDAOImpl = (RecipeIngredientsDAOImpl) context.getBean("recipeIngredientsDAOImpl");
		return recipeIngredientsDAOImpl.insertGreekRecipeIngredient(ri);
	}

	public int insertGlobalRecipeIngredient(RecipeIngredient ri) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipeIngredientsDAOImpl recipeIngredientsDAOImpl = (RecipeIngredientsDAOImpl) context.getBean("recipeIngredientsDAOImpl");
		return recipeIngredientsDAOImpl.insertGlobalRecipeIngredient(ri);
	}

	public int insertSpanishRecipeIngredient(RecipeIngredient ri) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipeIngredientsDAOImpl recipeIngredientsDAOImpl = (RecipeIngredientsDAOImpl) context.getBean("recipeIngredientsDAOImpl");
		return recipeIngredientsDAOImpl.insertSpanishRecipeIngredient(ri);
	}

	public List<RecipeIngredient> findIngredientForGreekRecipesGr() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipeIngredientsDAOImpl recipeIngredientsDAOImpl = (RecipeIngredientsDAOImpl) context.getBean("recipeIngredientsDAOImpl");
		return recipeIngredientsDAOImpl.findIngredientForGreekRecipesGr();
	}

	public List<RecipeIngredient> findIngredientForGreekRecipesEn() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipeIngredientsDAOImpl recipeIngredientsDAOImpl = (RecipeIngredientsDAOImpl) context.getBean("recipeIngredientsDAOImpl");
		return recipeIngredientsDAOImpl.findIngredientForGreekRecipesEn();
	}

	public List<RecipeIngredient> findIngredientForGlobalRecipesGr() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipeIngredientsDAOImpl recipeIngredientsDAOImpl = (RecipeIngredientsDAOImpl) context.getBean("recipeIngredientsDAOImpl");
		return recipeIngredientsDAOImpl.findIngredientForGlobalRecipesGr();
	}

	public List<RecipeIngredient> findIngredientForGlobalRecipesEn() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipeIngredientsDAOImpl recipeIngredientsDAOImpl = (RecipeIngredientsDAOImpl) context.getBean("recipeIngredientsDAOImpl");
		return recipeIngredientsDAOImpl.findIngredientForGlobalRecipesEn();

	}

	public List<RecipeIngredient> findIngredientForSpanishRecipesGr() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipeIngredientsDAOImpl recipeIngredientsDAOImpl = (RecipeIngredientsDAOImpl) context.getBean("recipeIngredientsDAOImpl");
		return recipeIngredientsDAOImpl.findIngredientForSpanishRecipesGr();
	}

	public List<RecipeIngredient> findIngredientForSpanishRecipesEn() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipeIngredientsDAOImpl recipeIngredientsDAOImpl = (RecipeIngredientsDAOImpl) context.getBean("recipeIngredientsDAOImpl");
		return recipeIngredientsDAOImpl.findIngredientForSpanishRecipesEn();
	}

}
