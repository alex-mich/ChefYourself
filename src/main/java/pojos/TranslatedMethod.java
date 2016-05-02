package pojos;

public class TranslatedMethod {

	//Fields
	private int tmid;
	private Language locale;
	private String mname;
	private Method method;
	
	//Constructors
	public TranslatedMethod(){}
	
	public TranslatedMethod(int tmid){
		this.tmid = tmid;
	}
	
	public TranslatedMethod(int tmid, Language locale, Method method, String mname) {
		this.tmid = tmid;
		this.locale = locale;
		this.mname = mname;
		this.method = method;
	}


	//Getters & Setters
	public int getTmid() {
		return tmid;
	}
	
	public void setTmid(int tmid) {
		this.tmid = tmid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public Language getLocale() {
		return locale;
	}

	public void setLocale(Language locale) {
		this.locale = locale;
	}

	public Method getMethod() {
		return method;
	}

	public void setMethod(Method method) {
		this.method = method;
	}

	@Override
	public String toString() {
		return "TranslatedMethod [tmid=" + tmid + ", locale=" + locale + ", mname=" + mname + ", method=" + method
				+ "]";
	}

}
