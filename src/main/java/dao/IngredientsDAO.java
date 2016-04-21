package dao;

import java.util.List;

import pojos.Ingredient;
import pojos.TranslatedIngredient;

public interface IngredientsDAO {

	public int insertIngredient(Ingredient ti) throws Exception;
	
	public int insertTranslatedIngredient(TranslatedIngredient tin) throws Exception;
	
	public List<Ingredient> findAllIngredients() throws Exception;
	
	public List<TranslatedIngredient> returnAllGrIngredients() throws Exception;
	
	public List<TranslatedIngredient> returnAllEnIngredients() throws Exception;
	
}
