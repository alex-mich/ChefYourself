package impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import dao.ResponseDAO;
import pojos.RecipeIngredient;
import pojos.RequestObject;
import pojos.TranslatedIngredient;
import pojos.TranslatedRecipe;

@Repository
public class ResponseDAOImpl implements ResponseDAO {

	private RecipesDAOImpl trdi;
	private IngredientsDAOImpl tidi;
	private RecipeIngredientsDAOImpl recipeIngredientsDAOImpl;
	private RecipeDescriptionsDAOImpl recipeDescriptionsDAOImpl;
	
	public void setRecipeDescriptionsDAOImpl(RecipeDescriptionsDAOImpl recipeDescriptionsDAOImpl) {
		this.recipeDescriptionsDAOImpl = recipeDescriptionsDAOImpl;
	}

	public RecipeIngredientsDAOImpl getRecipeIngredientsDAOImpl() {
		return recipeIngredientsDAOImpl;
	}

	public void setRecipeIngredientsDAOImpl(RecipeIngredientsDAOImpl recipeIngredientsDAOImpl) {
		this.recipeIngredientsDAOImpl = recipeIngredientsDAOImpl;
	}

	double suitabilityPercentage;
	double suitableIngredientsCounter;

	public void setTrdi(RecipesDAOImpl trdi) {
		this.trdi = trdi;
	}

	// {"locale":"en","methodList":[{"tmid":0,"mname":"Fried"}],"cuisineList":[{"tcid":0,"cname":"Greek
	// Menu"},{"tcid":0,"cname":"Spanish
	// Menu"}],"ingredientsList":[{"tinid":0,"iname":"Salt"},{"tinid":0,"iname":"Oregano"},{"tinid":0,"iname":"Egg"},{"tinid":0,"iname":"Tomato"}],"desiredSuitability":"30"}

	public IngredientsDAOImpl getTidi() {
		return tidi;
	}

	public void setTidi(IngredientsDAOImpl tidi) {
		this.tidi = tidi;
	}

	@Override
	public List<TranslatedRecipe> recipesResponse(RequestObject requestObject) {

		List<TranslatedRecipe> firstStep = new ArrayList<TranslatedRecipe>();
		try {
			if (requestObject.getLocale().equals(requestObject.getLocale()))
				firstStep = trdi.findAllRecipesEn();
			else
				firstStep = trdi.findAllRecipesGr();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<TranslatedRecipe> secondStep = new ArrayList<TranslatedRecipe>();
		for (int j = 0; j < requestObject.getCuisineList().size(); j++) {
			for (int i = 0; i < firstStep.size(); i++) {
				if (firstStep.get(i).getTransCuisine().getCname()
						.equals(requestObject.getCuisineList().get(j).getCname())) {
					secondStep.add(firstStep.get(i));
				}
			}
		}

		List<TranslatedRecipe> thirdStep = new ArrayList<TranslatedRecipe>();
		for (int j = 0; j < requestObject.getMethodList().size(); j++) {
			for (int i = 0; i < secondStep.size(); i++) {
				if (secondStep.get(i).getTransMethod().getMname()
						.equals(requestObject.getMethodList().get(j).getMname())) {
					thirdStep.add(secondStep.get(i));
				}
			}
		}

		for (int i = 0; i < thirdStep.size(); i++) {
			try {
				TranslatedRecipe translatedRecipe = thirdStep.get(i);
				List<RecipeIngredient> recipeIngredientsList = recipeIngredientsDAOImpl
						.findRecipeIngredientsByTranslatedRecipe(translatedRecipe);
				translatedRecipe.setRecipeIngredients(recipeIngredientsList);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < thirdStep.size(); i++) {
			try {
				TranslatedRecipe translatedRecipe = thirdStep.get(i);
				String recipeDescription = recipeDescriptionsDAOImpl
						.findRecipeDescriptionByTranslatedRecipe(translatedRecipe);
				translatedRecipe.setDescription(recipeDescription);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		List<TranslatedRecipe> finalList = new ArrayList<TranslatedRecipe>();
		finalList = ingredientsSuitability(thirdStep, requestObject.getDesiredSuitability(),
				requestObject.getLocale(), requestObject.getIngredientsList());
		return finalList;
	}

	public List<TranslatedRecipe> ingredientsSuitability(List<TranslatedRecipe> recipesList,
			double desiredSuitabilityPercentage, String locale, List<TranslatedIngredient> ingredientsList) {
		for (int i = 0; i < recipesList.size(); i++) {
			TranslatedRecipe translatedRecipe = recipesList.get(i);
			suitabilityPercentage = 0;
			suitableIngredientsCounter = 0;
			for (int j = 0; j < translatedRecipe.getRecipeIngredients().size(); j++) {
				for (int k = 0; k < ingredientsList.size(); k++) {
					if (translatedRecipe.getRecipeIngredients().get(j).getTrIngredient().getIname()
							.equals(ingredientsList.get(k).getIname())) {
						suitableIngredientsCounter++;
					}
				}

			}
			suitabilityPercentage = (double) suitableIngredientsCounter / translatedRecipe.getRecipeIngredients().size()
					* 100;
			translatedRecipe.setSuitability(suitabilityPercentage);
		}

		List<TranslatedRecipe> tobereturned = new ArrayList<>();
		for (int i = 0; i < recipesList.size(); i++) {
			if (recipesList.get(i).getSuitability() > desiredSuitabilityPercentage) {
				tobereturned.add(recipesList.get(i));
			}
		}
		return tobereturned;
	}

}
