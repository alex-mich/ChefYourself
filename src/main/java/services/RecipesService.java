package services;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import impl.RecipesDAOImpl;
import pojos.Recipe;
import pojos.TranslatedRecipe;

@Service
public class RecipesService {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	RecipesDAOImpl recipesDAOImpl = (RecipesDAOImpl) context.getBean("recipesDAOImpl");
	
	public int insertGreekRecipe(Recipe recipe) throws Exception{
		return recipesDAOImpl.insertGreekRecipe(recipe);
	}
	
	public int insertGlobalRecipe(Recipe recipe) throws Exception{
		return recipesDAOImpl.insertGlobalRecipe(recipe);
	}
	
	public int insertSpanishRecipe(Recipe recipe) throws Exception{
		return recipesDAOImpl.insertSpanishRecipe(recipe);
	}
	
	public int insertGreekTranslatedRecipe(TranslatedRecipe trRecipe) throws Exception{
		return recipesDAOImpl.insertGreekTranslatedRecipe(trRecipe);
	}
	
	public int insertGlobalTranslatedRecipe(TranslatedRecipe trRecipe) throws Exception{
		return recipesDAOImpl.insertGlobalTranslatedRecipe(trRecipe);
	}
	
	public int insertSpanishTranslatedRecipe(TranslatedRecipe trRecipe) throws Exception{
		return recipesDAOImpl.insertSpanishTranslatedRecipe(trRecipe);
	}

	public List<TranslatedRecipe> findGreekRecipesGr() throws Exception{
		return recipesDAOImpl.findGreekRecipesGr();
	}
	
	public List<TranslatedRecipe> findGreekRecipesEn() throws Exception{
		return recipesDAOImpl.findGreekRecipesEn();
	}
	
	public List<TranslatedRecipe> findSpanishRecipesGr() throws Exception{
		return recipesDAOImpl.findSpanishRecipesGr();
	}
	
	public List<TranslatedRecipe> findSpanishRecipesEn() throws Exception{
		return recipesDAOImpl.findSpanishRecipesEn();
	}
	
	public List<TranslatedRecipe> findGlobalRecipesGr() throws Exception{
		return recipesDAOImpl.findGlobalRecipesGr();
	}
	
	public List<TranslatedRecipe> findGlobalRecipesEn() throws Exception{
		return recipesDAOImpl.findGlobalRecipesEn();
	}
	
	public List<TranslatedRecipe> findAllRecipesEn() throws Exception{
		return recipesDAOImpl.findAllRecipesEn();
	}
	
	public List<TranslatedRecipe> findAllRecipesGr() throws Exception{
		return recipesDAOImpl.findAllRecipesGr();
	}
	
	public int deleteGreekRecipe(Recipe recipe) throws Exception{
		return recipesDAOImpl.deleteGreekRecipe(recipe);
	}
	
	public int deleteGlobalRecipe(Recipe recipe) throws Exception{
		return recipesDAOImpl.deleteGlobalRecipe(recipe);
	}
	
	public int deleteSpanishRecipe(Recipe recipe) throws Exception{
		return recipesDAOImpl.deleteSpanishRecipe(recipe);
	}
	
	public int deleteGreekTranslatedRecipe(TranslatedRecipe trRecipe) throws Exception{
		return recipesDAOImpl.deleteGreekTranslatedRecipe(trRecipe);
	}
	
	public int deleteGlobalTranslatedRecipe(TranslatedRecipe trRecipe) throws Exception{
		return recipesDAOImpl.deleteGlobalTranslatedRecipe(trRecipe);
	}
	
	public int deleteSpanishTranslatedRecipe(TranslatedRecipe trRecipe) throws Exception{
		return recipesDAOImpl.deleteSpanishTranslatedRecipe(trRecipe);
	}
}
