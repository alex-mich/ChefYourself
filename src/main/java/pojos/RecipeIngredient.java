package pojos;

public class RecipeIngredient {

	//Fields
	private int riid;
	private TranslatedRecipe trRecipe;
	private TranslatedIngredient trIngredient;
	private String quan;

	//Constructors
	public RecipeIngredient(){}
	
	public RecipeIngredient(int riid){this.riid = riid;}
	
	
	//Getters & Setters
	public int getRiid() {
		return riid;
	}

	public void setRiid(int riid) {
		this.riid = riid;
	}

	public TranslatedRecipe getTrRecipe() {
		return trRecipe;
	}

	public void setTrRecipe(TranslatedRecipe trRecipe) {
		this.trRecipe = trRecipe;
	}

	public TranslatedIngredient getTrIngredient() {
		return trIngredient;
	}

	public void setTrIngredient(TranslatedIngredient trIngredient) {
		this.trIngredient = trIngredient;
	}

	public String getQuan() {
		return quan;
	}

	public void setQuan(String quan) {
		this.quan = quan;
	}

	@Override
	public String toString() {
		return "RecipeIngredient [riid=" + riid + ", trRecipe=" + trRecipe + ", trIngredient=" + trIngredient
				+ ", quan=" + quan + "]";
	}

}
