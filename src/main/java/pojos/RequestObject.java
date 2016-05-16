package pojos;

import java.util.ArrayList;
import java.util.List;

public class RequestObject {

	private String locale = "en";
	private List<String> methodList = new ArrayList<String>();
	private List<String> cuisineList = new ArrayList<String>();
	
	@Override
	public String toString() {
		return "DataObject [locale=" + locale + ", methodList=" + methodList + ", cuisineList=" + cuisineList + "]";
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public List<String> getMethodList() {
		return methodList;
	}

	public void setMethodList(List<String> methodList) {
		this.methodList = methodList;
	}

	public List<String> getCuisineList() {
		return cuisineList;
	}

	public void setCuisineList(List<String> cuisineList) {
		this.cuisineList = cuisineList;
	}
	
}
