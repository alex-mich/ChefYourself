package pojos;

public class Recipe {

	//Fields
	private int rid;
	
	//Constructors
	public Recipe(){
		
	}
	
	public Recipe(int rid){
		this.rid = rid;
	}

	//Getters & Setters
	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	@Override
	public String toString() {
		return "Recipe [rid=" + rid + "]";
	}

}
