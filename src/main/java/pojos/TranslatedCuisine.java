package pojos;

public class TranslatedCuisine {

	//Fields
	private int tcid;
	private Cuisine cuisine;
	private Language locale;
	private String cname;
	
	//Constructors
	public TranslatedCuisine() {}
	
	public TranslatedCuisine(int tcid) {
		this.tcid = tcid;
	}
	public TranslatedCuisine(int tcid, Cuisine cuisine, Language locale, String cname) {
		this.tcid = tcid;
		this.cuisine = cuisine;
		this.locale = locale;
		this.cname = cname;
	}
	
	public TranslatedCuisine(String cname) {
		super();
		this.cname = cname;
	}

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

	public Language getLocale() {
		return locale;
	}

	public void setLocale(Language locale) {
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
