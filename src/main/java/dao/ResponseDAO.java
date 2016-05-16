package dao;

import java.util.List;

import pojos.RequestObject;
import pojos.TranslatedRecipe;

public interface ResponseDAO {

	public List<TranslatedRecipe> recipesResponse(RequestObject requestObject);
}
