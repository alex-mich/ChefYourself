package pojos;

public class Method {

	//Fields
	private int mid;

	//Constructors
	
	public Method(){}
	
	public Method(int mid){
		this.mid = mid;
	}
	
	//Getters & Setters
	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "Method [mid=" + mid + "]";
	}

}
