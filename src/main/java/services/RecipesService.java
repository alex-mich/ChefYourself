package services;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import impl.RecipesDAOImpl;
import pojos.Recipe;
import pojos.TranslatedRecipe;

@Service
public class RecipesService {

	public RecipesService(){}
	
	public int insertGrRecipe(Recipe recipe) throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipesDAOImpl recipesDAOImpl = (RecipesDAOImpl) context.getBean("recipesDAOImpl");
		return recipesDAOImpl.insertGrRecipe(recipe);
	}
	
	public int insertGlRecipe(Recipe recipe) throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipesDAOImpl recipesDAOImpl = (RecipesDAOImpl) context.getBean("recipesDAOImpl");
		return recipesDAOImpl.insertGlRecipe(recipe);
	}
	
	public int insertSpRecipe(Recipe recipe) throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipesDAOImpl recipesDAOImpl = (RecipesDAOImpl) context.getBean("recipesDAOImpl");
		return recipesDAOImpl.insertSpRecipe(recipe);
	}
	
	public int insertGreekRecipe(TranslatedRecipe trRecipe) throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipesDAOImpl recipesDAOImpl = (RecipesDAOImpl) context.getBean("recipesDAOImpl");
		return recipesDAOImpl.insertGreekRecipe(trRecipe);
	}
	
	public int insertGlobalRecipe(TranslatedRecipe trRecipe) throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipesDAOImpl recipesDAOImpl = (RecipesDAOImpl) context.getBean("recipesDAOImpl");
		return recipesDAOImpl.insertGlobalRecipe(trRecipe);
	}
	
	public int insertSpanishRecipe(TranslatedRecipe trRecipe) throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipesDAOImpl recipesDAOImpl = (RecipesDAOImpl) context.getBean("recipesDAOImpl");
		return recipesDAOImpl.insertSpanishRecipe(trRecipe);
	}

	public List<TranslatedRecipe> findGreekRecipesGr() throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipesDAOImpl recipesDAOImpl = (RecipesDAOImpl) context.getBean("recipesDAOImpl");
		return recipesDAOImpl.findGreekRecipesGr();
	}
	
	public List<TranslatedRecipe> findGreekRecipesEn() throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipesDAOImpl recipesDAOImpl = (RecipesDAOImpl) context.getBean("recipesDAOImpl");
		return recipesDAOImpl.findGreekRecipesEn();
	}
	
	public List<TranslatedRecipe> findSpanishRecipesGr() throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipesDAOImpl recipesDAOImpl = (RecipesDAOImpl) context.getBean("recipesDAOImpl");
		return recipesDAOImpl.findSpanishRecipesGr();
	}
	
	public List<TranslatedRecipe> findSpanishRecipesEn() throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipesDAOImpl recipesDAOImpl = (RecipesDAOImpl) context.getBean("recipesDAOImpl");
		return recipesDAOImpl.findSpanishRecipesEn();
	}
	
	public List<TranslatedRecipe> findGlobalRecipesGr() throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipesDAOImpl recipesDAOImpl = (RecipesDAOImpl) context.getBean("recipesDAOImpl");
		return recipesDAOImpl.findGlobalRecipesGr();
	}
	
	public List<TranslatedRecipe> findGlobalRecipesEn() throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipesDAOImpl recipesDAOImpl = (RecipesDAOImpl) context.getBean("recipesDAOImpl");
		return recipesDAOImpl.findGlobalRecipesEn();
	}
	
	public List<TranslatedRecipe> findAllRecipesEn() throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipesDAOImpl recipesDAOImpl = (RecipesDAOImpl) context.getBean("recipesDAOImpl");
		return recipesDAOImpl.findAllRecipesEn();
	}
	
	public List<TranslatedRecipe> findAllRecipesGr() throws Exception{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipesDAOImpl recipesDAOImpl = (RecipesDAOImpl) context.getBean("recipesDAOImpl");
		return recipesDAOImpl.findAllRecipesGr();
	}
	
}
