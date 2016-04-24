package pojos;

public class TranslatedRecipe {

	//Fields
	private int trid;
	private Recipe recipe;
	private TranslatedCuisine transCuisine;
	private TranslatedMethod transMethod;
	private Locale locale;
	private String rname;
	
	//Constructor
	public TranslatedRecipe(){}
	
	public TranslatedRecipe(int trid) {
		this.trid = trid;
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
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
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
	
}
