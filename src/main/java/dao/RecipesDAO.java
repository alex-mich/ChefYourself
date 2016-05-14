package dao;

import java.util.List;

import pojos.Recipe;
import pojos.TranslatedRecipe;

public interface RecipesDAO {

	public int insertRecipe(Recipe recipe, int tableIdentifier) throws Exception;

	public int insertGreekTranslatedRecipe(TranslatedRecipe translatedRecipe) throws Exception;

	public int insertGlobalTranslatedRecipe(TranslatedRecipe translatedRecipe) throws Exception;

	public int insertSpanishTranslatedRecipe(TranslatedRecipe translatedRecipe) throws Exception;

	public int deleteRecipe(Recipe recipe, int tableIdentifier) throws Exception;
	
	public int deleteTranslatedRecipe(TranslatedRecipe translatedRecipe, int tableIdentifier) throws Exception;
	
	public int updateRecipe(Recipe currentRecipe, Recipe updatedRecipe, int tableIdentifier) throws Exception;

	public int updateTranslatedRecipe(TranslatedRecipe currentTranslatedRecipe, TranslatedRecipe updatedTranslatedRecipe, int tableIdentifier) throws Exception;

	public List<TranslatedRecipe> findGreekRecipesGr() throws Exception;

	public List<TranslatedRecipe> findGreekRecipesEn() throws Exception;

	public List<TranslatedRecipe> findSpanishRecipesGr() throws Exception;

	public List<TranslatedRecipe> findSpanishRecipesEn() throws Exception;

	public List<TranslatedRecipe> findGlobalRecipesGr() throws Exception;

	public List<TranslatedRecipe> findGlobalRecipesEn() throws Exception;

	public List<TranslatedRecipe> findAllRecipesEn() throws Exception;

	public List<TranslatedRecipe> findAllRecipesGr() throws Exception;

}
