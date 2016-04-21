package pojos;

public class TranslatedCuisine {

	//Fields
	private int tcid;
	private Cuisine cuisine;
	private Locale locale;
	private String cname;

	//Getters & Setters
	public int getTcid() {
		return tcid;
	}

	public Cuisine getCuisine() {
		return cuisine;
	}

	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}

	public void setTcid(int tcid) {
		this.tcid = tcid;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Override
	public String toString() {
		return "TranslatedCuisine [tcid=" + tcid + ", cuisine=" + cuisine + ", locale=" + locale + ", cname=" + cname
				+ "]";
	}

}
