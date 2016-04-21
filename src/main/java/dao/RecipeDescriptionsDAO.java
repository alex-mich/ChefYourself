package dao;

import java.util.List;

import pojos.RecipeDescription;

public interface RecipeDescriptionsDAO {

	public int insertGrRecipeDescription(RecipeDescription rd) throws Exception;

	public int insertGlRecipeDescription(RecipeDescription rd) throws Exception;

	public int insertSpRecipeDescription(RecipeDescription rd) throws Exception;

	public List<RecipeDescription> findGreekRecipesDescriptionGr() throws Exception;

	public List<RecipeDescription> findGreekRecipesDescriptionEn() throws Exception;

	public List<RecipeDescription> findGlobalRecipesDescriptionGr() throws Exception;

	public List<RecipeDescription> findGlobalRecipesDescriptionEn() throws Exception;

	public List<RecipeDescription> findSpanishRecipesDescriptionGr() throws Exception;

	public List<RecipeDescription> findSpanishRecipesDescriptionEn() throws Exception;
}
