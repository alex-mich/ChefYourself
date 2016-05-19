package dao;

import java.util.List;

import pojos.Cuisine;
import pojos.TranslatedCuisine;

public interface CuisinesDAO {

	public int insertCuisine(Cuisine cuisine) throws Exception;

	public int insertTranslatedCuisine(TranslatedCuisine translatedCuisine) throws Exception;

	public int deleteCuisine(Cuisine cuisine) throws Exception;

	public int deleteTranslatedCuisine(TranslatedCuisine translatedCuisine) throws Exception;
	
	public int updateCuisine(Cuisine currentCuisine,Cuisine updatedCuisine) throws Exception;

	public int updateTranslatedCuisine(TranslatedCuisine currentTranslatedCuisine,TranslatedCuisine updatedTranslatedCuisine) throws Exception;

	public List<Cuisine> viewCuisinesTable() throws Exception;
	
	public List<TranslatedCuisine> viewTranslatedCuisinesTable() throws Exception;
	
	public List<Cuisine> findAllCuisines() throws Exception;

	public List<TranslatedCuisine> findGrCuisines() throws Exception;

	public List<TranslatedCuisine> findEnCuisines() throws Exception;
}
