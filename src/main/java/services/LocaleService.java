package services;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import impl.LocaleDAOImpl;
import pojos.Locale;

@Service
public class LocaleService {

	public LocaleService() {
	}

	public int insertLocale(Locale locale) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		LocaleDAOImpl localeDAOImpl = (LocaleDAOImpl) context.getBean("localeDAOImpl");
		return localeDAOImpl.insertLocale(locale);
	}

	public List<Locale> findLocales() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		LocaleDAOImpl localeDAOImpl = (LocaleDAOImpl) context.getBean("localeDAOImpl");
		return localeDAOImpl.findLocales();
	}

}
