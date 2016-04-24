package services;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import impl.RecipeDescriptionsDAOImpl;
import pojos.RecipeDescription;

@Service
public class DescriptionsService {

	public DescriptionsService(){}
	
	public int insertGreekRecipeDescription(RecipeDescription rd) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipeDescriptionsDAOImpl recipeDescriptionsDAOImpl = (RecipeDescriptionsDAOImpl) context.getBean("recipeDescriptionsDAOImpl");
		return recipeDescriptionsDAOImpl.insertGreekRecipeDescription(rd);
	}
	
	public int insertGlobalRecipeDescription(RecipeDescription rd) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipeDescriptionsDAOImpl recipeDescriptionsDAOImpl = (RecipeDescriptionsDAOImpl) context.getBean("recipeDescriptionsDAOImpl");
		return recipeDescriptionsDAOImpl.insertGlobalRecipeDescription(rd);
	}
	
	public int insertSpanishRecipeDescription(RecipeDescription rd) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipeDescriptionsDAOImpl recipeDescriptionsDAOImpl = (RecipeDescriptionsDAOImpl) context.getBean("recipeDescriptionsDAOImpl");
		return recipeDescriptionsDAOImpl.insertSpanishRecipeDescription(rd);
	}
	public List<RecipeDescription> findGreekRecipesDescriptionGr() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipeDescriptionsDAOImpl recipeDescriptionsDAOImpl = (RecipeDescriptionsDAOImpl) context.getBean("recipeDescriptionsDAOImpl");
		return recipeDescriptionsDAOImpl.findGreekRecipesDescriptionGr();
	}
	public List<RecipeDescription> findGreekRecipesDescriptionEn() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipeDescriptionsDAOImpl recipeDescriptionsDAOImpl = (RecipeDescriptionsDAOImpl) context.getBean("recipeDescriptionsDAOImpl");
		return recipeDescriptionsDAOImpl.findGreekRecipesDescriptionEn();
	}
	public List<RecipeDescription> findGlobalRecipesDescriptionGr() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipeDescriptionsDAOImpl recipeDescriptionsDAOImpl = (RecipeDescriptionsDAOImpl) context.getBean("recipeDescriptionsDAOImpl");
		return recipeDescriptionsDAOImpl.findGlobalRecipesDescriptionGr();
	}
	public List<RecipeDescription> findGlobalRecipesDescriptionEn() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipeDescriptionsDAOImpl recipeDescriptionsDAOImpl = (RecipeDescriptionsDAOImpl) context.getBean("recipeDescriptionsDAOImpl");
		return recipeDescriptionsDAOImpl.findGlobalRecipesDescriptionEn();
	}
	public List<RecipeDescription> findSpanishRecipesDescriptionGr() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipeDescriptionsDAOImpl recipeDescriptionsDAOImpl = (RecipeDescriptionsDAOImpl) context.getBean("recipeDescriptionsDAOImpl");
		return recipeDescriptionsDAOImpl.findSpanishRecipesDescriptionGr();
	}
	public List<RecipeDescription> findSpanishRecipesDescriptionEn() throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		RecipeDescriptionsDAOImpl recipeDescriptionsDAOImpl = (RecipeDescriptionsDAOImpl) context.getBean("recipeDescriptionsDAOImpl");
		return recipeDescriptionsDAOImpl.findSpanishRecipesDescriptionEn();
	}
	
}
