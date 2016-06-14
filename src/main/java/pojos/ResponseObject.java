package pojos;

import java.util.ArrayList;

public class ResponseObject {

	private ArrayList<TranslatedRecipe> recipesList = new ArrayList<>();

	public ArrayList<TranslatedRecipe> getRecipesList() {
		return recipesList;
	}

	public void setRecipesList(ArrayList<TranslatedRecipe> recipesList) {
		this.recipesList = recipesList;
	}
	
}
