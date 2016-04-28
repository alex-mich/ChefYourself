package dao;

import java.util.List;

import pojos.Recipe;
import pojos.TranslatedRecipe;

public interface RecipesDAO {

	public int insertGreekRecipe(Recipe recipe) throws Exception;

	public int insertGlobalRecipe(Recipe recipe) throws Exception;

	public int insertSpanishRecipe(Recipe recipe) throws Exception;

	public int insertGreekTranslatedRecipe(TranslatedRecipe trRecipe) throws Exception;

	public int insertGlobalTranslatedRecipe(TranslatedRecipe trRecipe) throws Exception;

	public int insertSpanishTranslatedRecipe(TranslatedRecipe trRecipe) throws Exception;

	public int deleteGreekRecipe(Recipe recipe) throws Exception;

	public int deleteGlobalRecipe(Recipe recipe) throws Exception;

	public int deleteSpanishRecipe(Recipe recipe) throws Exception;

	public int deleteGreekTranslatedRecipe(TranslatedRecipe trRecipe) throws Exception;

	public int deleteGlobalTranslatedRecipe(TranslatedRecipe trRecipe) throws Exception;

	public int deleteSpanishTranslatedRecipe(TranslatedRecipe trRecipe) throws Exception;

	public List<TranslatedRecipe> findGreekRecipesGr() throws Exception;

	public List<TranslatedRecipe> findGreekRecipesEn() throws Exception;

	public List<TranslatedRecipe> findSpanishRecipesGr() throws Exception;

	public List<TranslatedRecipe> findSpanishRecipesEn() throws Exception;

	public List<TranslatedRecipe> findGlobalRecipesGr() throws Exception;

	public List<TranslatedRecipe> findGlobalRecipesEn() throws Exception;

	public List<TranslatedRecipe> findAllRecipesEn() throws Exception;

	public List<TranslatedRecipe> findAllRecipesGr() throws Exception;

}
