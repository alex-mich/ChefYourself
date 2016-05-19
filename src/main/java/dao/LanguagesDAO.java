package dao;

import java.util.List;

import pojos.Language;

public interface LanguagesDAO {

	public int insertLocale(Language language) throws Exception;

	public int deleteLocale(Language language) throws Exception;
	
	public int updateLocale(Language currentLanguage, Language updatedLanguage) throws Exception;

	public List<Language> findLocales() throws Exception;
	
	public List<Language> viewLanguagesTable() throws Exception;
	
}
