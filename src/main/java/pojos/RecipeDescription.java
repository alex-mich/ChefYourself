package pojos;

public class RecipeDescription {

	//Fields
	private int rdid;
	private TranslatedRecipe trRecipe;
	private String desc;

	//Getters & Setters
	public int getRdid() {
		return rdid;
	}

	public void setRdid(int rdid) {
		this.rdid = rdid;
	}

	public TranslatedRecipe getTrRecipe() {
		return trRecipe;
	}

	public void setTrRecipe(TranslatedRecipe trRecipe) {
		this.trRecipe = trRecipe;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "RecipeDescription [rdid=" + rdid + ", trRecipe=" + trRecipe + ", desc=" + desc + "]";
	}

}
