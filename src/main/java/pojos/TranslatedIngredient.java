package pojos;

public class TranslatedIngredient {

	//Fields
	private int tinid;
	private Ingredient ingredient;
	private Language locale;
	private String iname;
	
	//Constructors
	public TranslatedIngredient(){}
	
	public TranslatedIngredient(int tinid) {
		this.tinid = tinid;
	}

	public TranslatedIngredient(int tinid, Ingredient ingredient, Language locale, String iname) {
		this.tinid = tinid;
		this.ingredient = ingredient;
		this.locale = locale;
		this.iname = iname;
	}

	//Getters & Setters
	public int getTinid() {
		return tinid;
	}

	public void setTinid(int tinid) {
		this.tinid = tinid;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Language getLocale() {
		return locale;
	}

	public void setLocale(Language locale) {
		this.locale = locale;
	}

	public String getIname() {
		return iname;
	}

	public void setIname(String iname) {
		this.iname = iname;
	}

	@Override
	public String toString() {
		return "TranslatedIngredient [tinid=" + tinid + ", ingredient=" + ingredient + ", locale=" + locale + ", iname="
				+ iname + "]";
	}

}
