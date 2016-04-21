package pojos;

public class Locale {

	//Fields
	public int lid;
	public String loc;
	public String language;

	//Getters & Setters
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
