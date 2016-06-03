package services;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import enumerations.TableType;
import impl.RecipeDescriptionsDAOImpl;
import pojos.RecipeDescription;

@Service
public class DescriptionsService {

	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
	RecipeDescriptionsDAOImpl recipeDescriptionsDAOImpl = (RecipeDescriptionsDAOImpl) context
			.getBean("recipeDescriptionsDAOImpl");

	public int insertGreekRecipeDescription(RecipeDescription recipeDescription) throws Exception {
		return recipeDescriptionsDAOImpl.insertGreekRecipeDescription(recipeDescription);
	}

	public int insertGlobalRecipeDescription(RecipeDescription recipeDescription) throws Exception {
		return recipeDescriptionsDAOImpl.insertGlobalRecipeDescription(recipeDescription);
	}

	public int insertSpanishRecipeDescription(RecipeDescription recipeDescription) throws Exception {
		return recipeDescriptionsDAOImpl.insertSpanishRecipeDescription(recipeDescription);
	}

	public int deleteGreekRecipeDescription(RecipeDescription recipeDescription) throws Exception {
		return recipeDescriptionsDAOImpl.deleteGreekRecipeDescription(recipeDescription);
	}

	public int deleteGlobalRecipeDescription(RecipeDescription recipeDescription) throws Exception {
		return recipeDescriptionsDAOImpl.deleteGlobalRecipeDescription(recipeDescription);
	}

	public int deleteSpanishRecipeDescription(RecipeDescription recipeDescription) throws Exception {
		return recipeDescriptionsDAOImpl.deleteSpanishRecipeDescription(recipeDescription);
	}

	public int updateRecipeDescription(RecipeDescription currentRecipeDescription,
			RecipeDescription updatedRecipeDescription, TableType tableType) throws Exception {
		return recipeDescriptionsDAOImpl.updateRecipeDescription(currentRecipeDescription, updatedRecipeDescription,
				tableType);
	}

	public List<RecipeDescription> viewRecipeDescriptionTable(TableType tableType) throws Exception {
		return recipeDescriptionsDAOImpl.viewRecipeDescriptionsTable(tableType);
	}
}
