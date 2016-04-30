package services;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import impl.LocaleDAOImpl;
import pojos.Locale;

@Service
public class LocaleService {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	LocaleDAOImpl localeDAOImpl = (LocaleDAOImpl) context.getBean("localeDAOImpl");
	
	public int insertLocale(Locale locale) throws Exception {
		return localeDAOImpl.insertLocale(locale);
	}

	public List<Locale> findLocales() throws Exception {
		return localeDAOImpl.findLocales();
	}

}
