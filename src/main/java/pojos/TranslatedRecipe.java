package pojos;

import java.util.List;

public class TranslatedRecipe {

	//Fields
	private int trid;
	private Recipe recipe;
	private TranslatedCuisine transCuisine;
	private TranslatedMethod transMethod;
	private Language locale;
	private String rname;
	
	//SecondaryFields
	private double suitability;
	private List<RecipeIngredient> recipeIngredients;
	private String description;
	
	//Constructor
	public TranslatedRecipe(){}
	
	public TranslatedRecipe(int trid) {
		this.trid = trid;
	}
	
	public TranslatedRecipe(int trid, Recipe recipe, TranslatedCuisine transCuisine, TranslatedMethod transMethod,
			Language locale, String rname) {
		this.trid = trid;
		this.recipe = recipe;
		this.transCuisine = transCuisine;
		this.transMethod = transMethod;
		this.locale = locale;
		this.rname = rname;
	}

	//Getters & Setters
	public void setTrid(int trid) {
		this.trid = trid;
	}
	
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	
	public TranslatedCuisine getTransCuisine() {
		return transCuisine;
	}
	public void setTransCuisine(TranslatedCuisine transCuisine) {
		this.transCuisine = transCuisine;
	}
	public TranslatedMethod getTransMethod() {
		return transMethod;
	}
	public void setTransMethod(TranslatedMethod transMethod) {
		this.transMethod = transMethod;
	}
	public Language getLocale() {
		return locale;
	}
	public void setLocale(Language locale) {
		this.locale = locale;
	}
	public int getTrid() {
		return trid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	@Override
	public String toString() {
		return "TranslatedRecipe [trid=" + trid + ", recipe=" + recipe + ", transCuisine=" + transCuisine
				+ ", transMethod=" + transMethod + ", locale=" + locale + ", rname=" + rname + "]";
	}

	public double getSuitability() {
		return suitability;
	}

	public void setSuitability(double suitability) {
		this.suitability = suitability;
	}

	public List<RecipeIngredient> getRecipeIngredients() {
		return recipeIngredients;
	}

	public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
		this.recipeIngredients = recipeIngredients;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
