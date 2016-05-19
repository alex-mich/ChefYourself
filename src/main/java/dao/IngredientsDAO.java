package dao;

import java.util.List;

import pojos.Ingredient;
import pojos.TranslatedIngredient;

public interface IngredientsDAO {

	public int insertIngredient(Ingredient ingredient) throws Exception;

	public int insertTranslatedIngredient(TranslatedIngredient translatedIngredient) throws Exception;

	public int deleteIngredient(Ingredient ingredient) throws Exception;

	public int deleteTranslatedIngredient(TranslatedIngredient translatedIngredient) throws Exception;
	
	public int updateIngredient(Ingredient currentIngredient, Ingredient updatedIngredient) throws Exception;

	public int updateTranslatedIngredient(TranslatedIngredient currentTranslatedIngredient, TranslatedIngredient updatedTranslatedIngredient) throws Exception;
	
	public List<Ingredient> viewIngredientsTable() throws Exception;
	
	public List<TranslatedIngredient> viewTranslatedIngredientsTable() throws Exception;
	
	public List<Ingredient> findAllIngredients() throws Exception;

	public List<TranslatedIngredient> findGrIngredients() throws Exception;

	public List<TranslatedIngredient> findEnIngredients() throws Exception;
}
