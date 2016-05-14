package services;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import impl.RecipeDescriptionsDAOImpl;
import pojos.RecipeDescription;

@Service
public class DescriptionsService {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	RecipeDescriptionsDAOImpl recipeDescriptionsDAOImpl = (RecipeDescriptionsDAOImpl) context.getBean("recipeDescriptionsDAOImpl");
	
	public int insertGreekRecipeDescription(RecipeDescription rd) throws Exception {
		return recipeDescriptionsDAOImpl.insertGreekRecipeDescription(rd);
	}
	
	public int insertGlobalRecipeDescription(RecipeDescription rd) throws Exception {
		return recipeDescriptionsDAOImpl.insertGlobalRecipeDescription(rd);
	}
	
	public int insertSpanishRecipeDescription(RecipeDescription rd) throws Exception {
		return recipeDescriptionsDAOImpl.insertSpanishRecipeDescription(rd);
	}
	public List<RecipeDescription> findGreekRecipesDescriptionGr() throws Exception {
		return recipeDescriptionsDAOImpl.findGreekRecipesDescriptionGr();
	}
	
	public List<RecipeDescription> findGreekRecipesDescriptionEn() throws Exception {
		return recipeDescriptionsDAOImpl.findGreekRecipesDescriptionEn();
	}
	
	public List<RecipeDescription> findGlobalRecipesDescriptionGr() throws Exception {
		return recipeDescriptionsDAOImpl.findGlobalRecipesDescriptionGr();
	}
	
	public List<RecipeDescription> findGlobalRecipesDescriptionEn() throws Exception {
		return recipeDescriptionsDAOImpl.findGlobalRecipesDescriptionEn();
	}
	
	public List<RecipeDescription> findSpanishRecipesDescriptionGr() throws Exception {
		return recipeDescriptionsDAOImpl.findSpanishRecipesDescriptionGr();
	}
	
	public List<RecipeDescription> findSpanishRecipesDescriptionEn() throws Exception {
		return recipeDescriptionsDAOImpl.findSpanishRecipesDescriptionEn();
	}
	
	public int deleteGreekRecipeDescription(RecipeDescription recipeDescription) throws Exception{
		return recipeDescriptionsDAOImpl.deleteGreekRecipeDescription(recipeDescription);
	}
	
	public int deleteGlobalRecipeDescription(RecipeDescription recipeDescription) throws Exception{
		return recipeDescriptionsDAOImpl.deleteGlobalRecipeDescription(recipeDescription);
	}
	
	public int deleteSpanishRecipeDescription(RecipeDescription recipeDescription) throws Exception{
		return recipeDescriptionsDAOImpl.deleteSpanishRecipeDescription(recipeDescription);
	}
	
	public int updateRecipeDescription(RecipeDescription currentRecipeDescription,
			RecipeDescription updatedRecipeDescription, int tableIdentifier) throws Exception{
		return recipeDescriptionsDAOImpl.updateRecipeDescription(currentRecipeDescription, updatedRecipeDescription, tableIdentifier);
	}
}
