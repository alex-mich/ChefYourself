package pojos;

public class Ingredient {

	//Fields
	private int inid;
	private String itype;

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
