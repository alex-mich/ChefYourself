package services;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import impl.RecipeIngredientsDAOImpl;
import pojos.RecipeIngredient;

@Service
public class RecipeIngredientsService {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	RecipeIngredientsDAOImpl recipeIngredientsDAOImpl = (RecipeIngredientsDAOImpl) context.getBean("recipeIngredientsDAOImpl");

	public int insertGreekRecipeIngredient(RecipeIngredient ri) throws Exception {
		return recipeIngredientsDAOImpl.insertGreekRecipeIngredient(ri);
	}

	public int insertGlobalRecipeIngredient(RecipeIngredient ri) throws Exception {
		return recipeIngredientsDAOImpl.insertGlobalRecipeIngredient(ri);
	}

	public int insertSpanishRecipeIngredient(RecipeIngredient ri) throws Exception {
		return recipeIngredientsDAOImpl.insertSpanishRecipeIngredient(ri);
	}

	public List<RecipeIngredient> findIngredientForGreekRecipesGr() throws Exception {
		return recipeIngredientsDAOImpl.findIngredientForGreekRecipesGr();
	}

	public List<RecipeIngredient> findIngredientForGreekRecipesEn() throws Exception {
		return recipeIngredientsDAOImpl.findIngredientForGreekRecipesEn();
	}

	public List<RecipeIngredient> findIngredientForGlobalRecipesGr() throws Exception {
		return recipeIngredientsDAOImpl.findIngredientForGlobalRecipesGr();
	}

	public List<RecipeIngredient> findIngredientForGlobalRecipesEn() throws Exception {
		return recipeIngredientsDAOImpl.findIngredientForGlobalRecipesEn();

	}

	public List<RecipeIngredient> findIngredientForSpanishRecipesGr() throws Exception {
		return recipeIngredientsDAOImpl.findIngredientForSpanishRecipesGr();
	}

	public List<RecipeIngredient> findIngredientForSpanishRecipesEn() throws Exception {
		return recipeIngredientsDAOImpl.findIngredientForSpanishRecipesEn();
	}
	
	public int deleteGreekRecipeIngredient(RecipeIngredient recipeIngredient) throws Exception{
		return recipeIngredientsDAOImpl.deleteGreekRecipeIngredient(recipeIngredient);
	}
	
	public int deleteGlobalRecipeIngredient(RecipeIngredient recipeIngredient) throws Exception{
		return recipeIngredientsDAOImpl.deleteGlobalRecipeIngredient(recipeIngredient);
	}
	
	public int deleteSpanishRecipeIngredient(RecipeIngredient recipeIngredient) throws Exception{
		return recipeIngredientsDAOImpl.deleteSpanishRecipeIngredient(recipeIngredient);
	}
	
	public int updateRecipeIngredient(RecipeIngredient currentRecipeIngredient,
			RecipeIngredient updatedRecipeIngredient, int tableIdentifier) throws Exception{
		return recipeIngredientsDAOImpl.updateRecipeIngredient(currentRecipeIngredient, updatedRecipeIngredient, tableIdentifier);
	}

}
