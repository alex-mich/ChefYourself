package pojos;

public class TranslatedIngredient {

	//Fields
	private int tinid;
	private Ingredient ingredient;
	private Locale locale;
	private String iname;

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

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
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
