package services;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import enumerations.TableType;
import impl.RecipeIngredientsDAOImpl;
import pojos.RecipeIngredient;

@Service
public class RecipeIngredientsService {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	RecipeIngredientsDAOImpl recipeIngredientsDAOImpl = (RecipeIngredientsDAOImpl) context
			.getBean("recipeIngredientsDAOImpl");

	public int insertRecipeIngredient(RecipeIngredient recipeIngredient, TableType tableType) throws Exception {
		return recipeIngredientsDAOImpl.insertRecipeIngredient(recipeIngredient, tableType);
	}

	public int deleteRecipeIngredient(RecipeIngredient recipeIngredient, TableType tableType) throws Exception {
		return recipeIngredientsDAOImpl.deleteRecipeIngredient(recipeIngredient, tableType);
	}

	public int updateRecipeIngredient(RecipeIngredient currentRecipeIngredient,
			RecipeIngredient updatedRecipeIngredient, TableType tableType) throws Exception {
		return recipeIngredientsDAOImpl.updateRecipeIngredient(currentRecipeIngredient, updatedRecipeIngredient,
				tableType);
	}

	public List<RecipeIngredient> viewRecipeIngredientsTable(TableType tableType) throws Exception {
		return recipeIngredientsDAOImpl.viewRecipeIngredientsTable(tableType);
	}

}
