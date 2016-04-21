
package dao;

import java.util.List;

import pojos.RecipeIngredient;

public interface RecipeIngredientsDAO {
	
	public int insertGrRecipeIngredient(RecipeIngredient ri) throws Exception;
	
	public int insertGlRecipeIngredient(RecipeIngredient ri) throws Exception;
	
	public int insertSpRecipeIngredient(RecipeIngredient ri) throws Exception;
	
	public List<RecipeIngredient> findIngredientForGrRecipesGr() throws Exception;
	
	public List<RecipeIngredient> findIngredientForGrRecipesEn() throws Exception;
	
	public List<RecipeIngredient> findIngredientForGlRecipesGr() throws Exception;
	
	public List<RecipeIngredient> findIngredientForGlRecipesEn() throws Exception;
	
	public List<RecipeIngredient> findIngredientForSpRecipesGr() throws Exception;
	
	public List<RecipeIngredient> findIngredientForSpRecipesEn() throws Exception;

}
