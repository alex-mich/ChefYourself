package dao;

import java.util.List;

import pojos.Language;

public interface LanguagesDAO {

	public int insertLocale(Language locale) throws Exception;

	public int deleteLocale(Language locale) throws Exception;

	public List<Language> findLocales() throws Exception;

}
