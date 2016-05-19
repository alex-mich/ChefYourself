package dao;

import java.util.List;

import enumerations.TableType;
import pojos.RecipeDescription;

public interface RecipeDescriptionsDAO {

	public int insertGreekRecipeDescription(RecipeDescription rd) throws Exception;

	public int insertGlobalRecipeDescription(RecipeDescription rd) throws Exception;

	public int insertSpanishRecipeDescription(RecipeDescription rd) throws Exception;

	public int deleteGreekRecipeDescription(RecipeDescription rd) throws Exception;

	public int deleteGlobalRecipeDescription(RecipeDescription rd) throws Exception;

	public int deleteSpanishRecipeDescription(RecipeDescription rd) throws Exception;
	
	public int updateRecipeDescription(RecipeDescription currentRecipeDescription,RecipeDescription updatedRecipeDescription, TableType tableType) throws Exception;

	public List<RecipeDescription> findGreekRecipesDescriptionGr() throws Exception;

	public List<RecipeDescription> findGreekRecipesDescriptionEn() throws Exception;

	public List<RecipeDescription> findGlobalRecipesDescriptionGr() throws Exception;

	public List<RecipeDescription> findGlobalRecipesDescriptionEn() throws Exception;

	public List<RecipeDescription> findSpanishRecipesDescriptionGr() throws Exception;

	public List<RecipeDescription> findSpanishRecipesDescriptionEn() throws Exception;
	
	public List<RecipeDescription> viewRecipeDescriptionsTable(TableType tableType) throws Exception;
}
