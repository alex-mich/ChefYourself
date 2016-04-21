package pojos;

public class TranslatedMethod {

	//Fields
	private int tmid;
	private Locale locale;
	private String mname;
	private Method method;

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

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
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
