package pojos;

public class Language {

	// Fields
	private int lid;
	private String loc;
	private String language;

	//Constructors
	public Language(){}
	
	public Language(String loc){
		this.loc = loc;
	}
	
	public Language(int lid){
		this.lid = lid;
	}
	
	public Language(int lid, String loc, String language) {
		this.lid = lid;
		this.loc = loc;
		this.language = language;
	}

	// Getters & Setters
	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "Locale [lid=" + lid + ", loc=" + loc + ", language=" + language + "]";
	}

}
