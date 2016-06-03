
package dao;

import java.util.List;

import enumerations.TableType;
import pojos.RecipeIngredient;

public interface RecipeIngredientsDAO {

	public int insertRecipeIngredient(RecipeIngredient recipeIngredient, TableType tableType) throws Exception;

	public int deleteRecipeIngredient(RecipeIngredient recipeIngredient, TableType tableType) throws Exception;

	public int updateRecipeIngredient(RecipeIngredient currentRecipeIngredient,
			RecipeIngredient updatedRecipeIngredient, TableType tableType) throws Exception;

	public List<RecipeIngredient> viewRecipeIngredientsTable(TableType tableType) throws Exception;

	public List<RecipeIngredient> findIngredientForGreekRecipesGr() throws Exception;

	public List<RecipeIngredient> findIngredientForGreekRecipesEn() throws Exception;

	public List<RecipeIngredient> findIngredientForGlobalRecipesGr() throws Exception;

	public List<RecipeIngredient> findIngredientForGlobalRecipesEn() throws Exception;

	public List<RecipeIngredient> findIngredientForSpanishRecipesGr() throws Exception;

	public List<RecipeIngredient> findIngredientForSpanishRecipesEn() throws Exception;

}
