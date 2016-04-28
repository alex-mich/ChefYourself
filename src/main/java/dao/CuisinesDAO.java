package dao;

import java.util.List;

import pojos.Cuisine;
import pojos.TranslatedCuisine;

public interface CuisinesDAO {

	public int insertCuisine(Cuisine cui) throws Exception;

	public int insertTranslatedCuisine(TranslatedCuisine tcui) throws Exception;

	public int deleteCuisine(Cuisine cui) throws Exception;

	public int deleteTranslatedCuisine(TranslatedCuisine tcui) throws Exception;

	public List<Cuisine> findAllCuisines() throws Exception;

	public List<TranslatedCuisine> findGrCuisines() throws Exception;

	public List<TranslatedCuisine> findEnCuisines() throws Exception;

}
