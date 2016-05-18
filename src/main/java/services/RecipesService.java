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

	public int insertGreekTranslatedRecipe(TranslatedRecipe translatedRecipe) throws Exception {
		return recipesDAOImpl.insertGreekTranslatedRecipe(translatedRecipe);
	}

	public int insertGlobalTranslatedRecipe(TranslatedRecipe translatedRecipe) throws Exception {
		return recipesDAOImpl.insertGlobalTranslatedRecipe(translatedRecipe);
	}

	public int insertSpanishTranslatedRecipe(TranslatedRecipe translatedRecipe) throws Exception {
		return recipesDAOImpl.insertSpanishTranslatedRecipe(translatedRecipe);
	}

	public List<Recipe> viewRecipesTable(TableType tableType) throws Exception {
		return recipesDAOImpl.viewRecipesTable(tableType);
	}

	public List<TranslatedRecipe> findGreekRecipesGr() throws Exception {
		return recipesDAOImpl.findGreekRecipesGr();
	}

	public List<TranslatedRecipe> findGreekRecipesEn() throws Exception {
		return recipesDAOImpl.findGreekRecipesEn();
	}

	public List<TranslatedRecipe> findSpanishRecipesGr() throws Exception {
		return recipesDAOImpl.findSpanishRecipesGr();
	}

	public List<TranslatedRecipe> findSpanishRecipesEn() throws Exception {
		return recipesDAOImpl.findSpanishRecipesEn();
	}

	public List<TranslatedRecipe> findGlobalRecipesGr() throws Exception {
		return recipesDAOImpl.findGlobalRecipesGr();
	}

	public List<TranslatedRecipe> findGlobalRecipesEn() throws Exception {
		return recipesDAOImpl.findGlobalRecipesEn();
	}

	public List<TranslatedRecipe> findAllRecipesEn() throws Exception {
		return recipesDAOImpl.findAllRecipesEn();
	}

	public List<TranslatedRecipe> findAllRecipesGr() throws Exception {
		return recipesDAOImpl.findAllRecipesGr();
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

}
