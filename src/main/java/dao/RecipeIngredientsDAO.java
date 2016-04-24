
package dao;

import java.util.List;

import pojos.RecipeIngredient;

public interface RecipeIngredientsDAO {
	
	public int insertGreekRecipeIngredient(RecipeIngredient ri) throws Exception;
	
	public int insertGlobalRecipeIngredient(RecipeIngredient ri) throws Exception;
	
	public int insertSpanishRecipeIngredient(RecipeIngredient ri) throws Exception;
	
	public List<RecipeIngredient> findIngredientForGreekRecipesGr() throws Exception;
	
	public List<RecipeIngredient> findIngredientForGreekRecipesEn() throws Exception;
	
	public List<RecipeIngredient> findIngredientForGlobalRecipesGr() throws Exception;
	
	public List<RecipeIngredient> findIngredientForGlobalRecipesEn() throws Exception;
	
	public List<RecipeIngredient> findIngredientForSpanishRecipesGr() throws Exception;
	
	public List<RecipeIngredient> findIngredientForSpanishRecipesEn() throws Exception;

}
