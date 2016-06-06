package pojos;

import java.util.ArrayList;
import java.util.List;

public class RequestObject {
	
	private String locale;
	private List<TranslatedMethod> methodList = new ArrayList<TranslatedMethod>();
	private List<TranslatedCuisine> cuisineList = new ArrayList<TranslatedCuisine>();
	private List<TranslatedIngredient> ingredientsList = new ArrayList<TranslatedIngredient>();
	private double desiredSuitability;
	
	public String getLocale() {
		return locale;
	}
	
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
	public List<TranslatedMethod> getMethodList() {
		return methodList;
	}
	
	public void setMethodList(List<TranslatedMethod> methodList) {
		this.methodList = methodList;
	}
	
	public List<TranslatedCuisine> getCuisineList() {
		return cuisineList;
	}
	
	public void setCuisineList(List<TranslatedCuisine> cuisineList) {
		this.cuisineList = cuisineList;
	}

	public List<TranslatedIngredient> getIngredientsList() {
		return ingredientsList;
	}

	public void setIngredientsList(List<TranslatedIngredient> ingredientsList) {
		this.ingredientsList = ingredientsList;
	}

	public double getDesiredSuitability() {
		return desiredSuitability;
	}

	public void setDesiredSuitability(double desiredSuitability) {
		this.desiredSuitability = desiredSuitability;
	}
	
}
