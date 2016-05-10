package services;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import impl.LanguagesDAOImpl;
import pojos.Language;

@Service
public class LanguagesService {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	LanguagesDAOImpl localeDAOImpl = (LanguagesDAOImpl) context.getBean("localeDAOImpl");
	
	public int insertLocale(Language locale) throws Exception {
		return localeDAOImpl.insertLocale(locale);
	}

	public List<Language> findLocales() throws Exception {
		return localeDAOImpl.findLocales();
	}

	public int deleteLocale(Language language) throws Exception {
		return localeDAOImpl.deleteLocale(language);
	}
	
	public int updateLocale(Language currentLanguage, Language updatedLanguage) throws Exception {
		return localeDAOImpl.updateLocale(currentLanguage,updatedLanguage);
	}
}
