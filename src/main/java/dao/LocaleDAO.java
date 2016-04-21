package dao;

import java.util.List;

import pojos.Locale;

public interface LocaleDAO {
	
	public int insertLocale(Locale locale) throws Exception;
	
	public List<Locale> findLocales() throws Exception;

}
