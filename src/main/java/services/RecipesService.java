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

	public int insertRecipe(Recipe recipe, int tableIdentifier) throws Exception {
		return recipesDAOImpl.insertRecipe(recipe, tableIdentifier);
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

	public int deleteRecipe(Recipe recipe, int tableIdentifier) throws Exception {
		return recipesDAOImpl.deleteRecipe(recipe,tableIdentifier);
	}

	public int deleteTranslatedRecipe(TranslatedRecipe translatedRecipe, int tableIdentifier) throws Exception {
		return recipesDAOImpl.deleteTranslatedRecipe(translatedRecipe, tableIdentifier);
	}

	public int updateRecipe(Recipe currentRecipe, Recipe updatedRecipe, int tableIdentifier) throws Exception {
		return recipesDAOImpl.updateRecipe(currentRecipe, updatedRecipe, tableIdentifier);
	}

	public int updateTranslatedRecipe(TranslatedRecipe currentTranslatedRecipe,
			TranslatedRecipe updatedTranslatedRecipe, int tableIdentifier) throws Exception {
		return recipesDAOImpl.updateTranslatedRecipe(currentTranslatedRecipe, updatedTranslatedRecipe, tableIdentifier);
	}

}
