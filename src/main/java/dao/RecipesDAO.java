package dao;

import java.util.List;

import pojos.Recipe;
import pojos.TranslatedRecipe;

public interface RecipesDAO {
	
	public int insertGrRecipe(Recipe recipe) throws Exception;
	
	public int insertGlRecipe(Recipe recipe) throws Exception;
	
	public int insertSpRecipe(Recipe recipe) throws Exception;
	
	public int insertGreekRecipe(TranslatedRecipe trRecipe) throws Exception;
	
	public int insertGlobalRecipe(TranslatedRecipe trRecipe) throws Exception;
	
	public int insertSpanishRecipe(TranslatedRecipe trRecipe) throws Exception;

	public List<TranslatedRecipe> findGreekRecipesGr() throws Exception;
	
	public List<TranslatedRecipe> findGreekRecipesEn() throws Exception;
	
	public List<TranslatedRecipe> findSpanishRecipesGr() throws Exception;
	
	public List<TranslatedRecipe> findSpanishRecipesEn() throws Exception;
	
	public List<TranslatedRecipe> findGlobalRecipesGr() throws Exception;
	
	public List<TranslatedRecipe> findGlobalRecipesEn() throws Exception;
	
	public List<TranslatedRecipe> findAllRecipesEn() throws Exception;
	
	public List<TranslatedRecipe> findAllRecipesGr() throws Exception;
	
}
