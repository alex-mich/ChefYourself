package services;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import impl.RecipesDAOImpl;
import pojos.Recipe;
import pojos.TranslatedRecipe;

@Service
public class RecipesService {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	RecipesDAOImpl recipesDAOImpl = (RecipesDAOImpl) context.getBean("recipesDAOImpl");

	public int insertGreekRecipe(Recipe recipe) throws Exception {
		return recipesDAOImpl.insertGreekRecipe(recipe);
	}

	public int insertGlobalRecipe(Recipe recipe) throws Exception {
		return recipesDAOImpl.insertGlobalRecipe(recipe);
	}

	public int insertSpanishRecipe(Recipe recipe) throws Exception {
		return recipesDAOImpl.insertSpanishRecipe(recipe);
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

	public int deleteGreekRecipe(Recipe recipe) throws Exception {
		return recipesDAOImpl.deleteGreekRecipe(recipe);
	}

	public int deleteGlobalRecipe(Recipe recipe) throws Exception {
		return recipesDAOImpl.deleteGlobalRecipe(recipe);
	}

	public int deleteSpanishRecipe(Recipe recipe) throws Exception {
		return recipesDAOImpl.deleteSpanishRecipe(recipe);
	}

	public int deleteGreekTranslatedRecipe(TranslatedRecipe translatedRecipe) throws Exception {
		return recipesDAOImpl.deleteGreekTranslatedRecipe(translatedRecipe);
	}

	public int deleteGlobalTranslatedRecipe(TranslatedRecipe translatedRecipe) throws Exception {
		return recipesDAOImpl.deleteGlobalTranslatedRecipe(translatedRecipe);
	}

	public int deleteSpanishTranslatedRecipe(TranslatedRecipe translatedRecipe) throws Exception {
		return recipesDAOImpl.deleteSpanishTranslatedRecipe(translatedRecipe);
	}

	public int updateRecipe(Recipe currentRecipe, Recipe updatedRecipe, int tableIdentifier) throws Exception {
		return recipesDAOImpl.updateRecipe(currentRecipe, updatedRecipe, tableIdentifier);
	}

	public int updateTranslatedRecipe(TranslatedRecipe currentTranslatedRecipe,
			TranslatedRecipe updatedTranslatedRecipe, int tableIdentifier) throws Exception {
		return recipesDAOImpl.updateTranslatedRecipe(currentTranslatedRecipe, updatedTranslatedRecipe, tableIdentifier);
	}

}
