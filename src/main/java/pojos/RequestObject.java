package pojos;

import java.util.ArrayList;
import java.util.List;

public class RequestObject {

	//{"locale":"en","tm":{"tmid":0,"mname":"Fried"},"tc":{"tcid":0,"cname":"Greek Menu"},"methodList":[{"tmid":0,"mname":"Fried"}],"cuisineList":[{"tcid":0,"cname":"Greek Menu"}]}
	
	private String locale = "en";
	private List<TranslatedMethod> methodList = new ArrayList<TranslatedMethod>();
	private List<TranslatedCuisine> cuisineList = new ArrayList<TranslatedCuisine>();
	/*private List<TranslatedIngredient> ingredientsList = new ArrayList<TranslatedIngredient>();
	private int suitabilityPercentage;*/
	
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
	
	/*public List<TranslatedIngredient> getIngredientsList() {
		return ingredientsList;
	}
	public void setIngredientsList(List<TranslatedIngredient> ingredientsList) {
		this.ingredientsList = ingredientsList;
	}
	public int getSuitabilityPercentage() {
		return suitabilityPercentage;
	}
	public void setSuitabilityPercentage(int suitabilityPercentage) {
		this.suitabilityPercentage = suitabilityPercentage;
	}*/
	
	
	
}
