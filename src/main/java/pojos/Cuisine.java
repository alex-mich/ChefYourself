package pojos;

public class Cuisine {

	//Fields
	private int cid;

	//Getters & Setters
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "Cuisine [cid=" + cid + "]";
	}

}
