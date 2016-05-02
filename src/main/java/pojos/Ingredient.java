package pojos;

public class Ingredient {

	//Fields
	private int inid;
	private String itype;

	//Constructors
	public Ingredient(){}
	
	public Ingredient(int inid) {
		this.inid = inid;
	}

	public Ingredient(int inid, String itype) {
		this.inid = inid;
		this.itype = itype;
	}

	//Getters & Setters
	public int getInid() {
		return inid;
	}

	public void setInid(int inid) {
		this.inid = inid;
	}

	public String getItype() {
		return itype;
	}

	public void setItype(String itype) {
		this.itype = itype;
	}

	@Override
	public String toString() {
		return "Ingredient [inid=" + inid + ", itype=" + itype + "]";
	}

}
