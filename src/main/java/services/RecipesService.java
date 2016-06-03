package services;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import enumerations.TableType;
import impl.RecipesDAOImpl;
import pojos.Recipe;
import pojos.TranslatedRecipe;

@Service
public class RecipesService {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	RecipesDAOImpl recipesDAOImpl = (RecipesDAOImpl) context.getBean("recipesDAOImpl");

	public int insertRecipe(Recipe recipe, TableType tableType) throws Exception {
		return recipesDAOImpl.insertRecipe(recipe, tableType);
	}

	public int insertTranslatedRecipe(TranslatedRecipe translatedRecipe, TableType tabletype) throws Exception {
		return recipesDAOImpl.insertTranslatedRecipe(translatedRecipe, tabletype);
	}

	public int deleteRecipe(Recipe recipe, TableType tabletype) throws Exception {
		return recipesDAOImpl.deleteRecipe(recipe, tabletype);
	}

	public int deleteTranslatedRecipe(TranslatedRecipe translatedRecipe, TableType tabletype) throws Exception {
		return recipesDAOImpl.deleteTranslatedRecipe(translatedRecipe, tabletype);
	}

	public int updateRecipe(Recipe currentRecipe, Recipe updatedRecipe, TableType tabletype) throws Exception {
		return recipesDAOImpl.updateRecipe(currentRecipe, updatedRecipe, tabletype);
	}

	public int updateTranslatedRecipe(TranslatedRecipe currentTranslatedRecipe,
			TranslatedRecipe updatedTranslatedRecipe, TableType tabletype) throws Exception {
		return recipesDAOImpl.updateTranslatedRecipe(currentTranslatedRecipe, updatedTranslatedRecipe, tabletype);
	}

	public List<Recipe> viewRecipesTable(TableType tableType) throws Exception {
		return recipesDAOImpl.viewRecipesTable(tableType);
	}

	public List<TranslatedRecipe> viewTranslatedRecipesTable(TableType tableType) throws Exception {
		return recipesDAOImpl.viewTranslatedRecipesTable(tableType);
	}
}
