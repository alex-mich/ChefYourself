package impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import dao.ResponseDAO;
import pojos.RequestObject;
import pojos.TranslatedRecipe;

@Repository
public class ResponseDAOImpl implements ResponseDAO {

	private RecipesDAOImpl trdi;
	
	public void setTrdi(RecipesDAOImpl trdi) {
		this.trdi = trdi;
	}

	@Override
	public List<TranslatedRecipe> recipesResponse(RequestObject requestObject) {
		
		List<TranslatedRecipe> firstStep = new ArrayList<TranslatedRecipe>();
		try {
			if (requestObject.getLocale().equals("en"))
				firstStep = trdi.findAllRecipesEn();
			else
				firstStep = trdi.findAllRecipesGr();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List<TranslatedRecipe> secondStep = new ArrayList<TranslatedRecipe>();
		for (int j = 0; j < requestObject.getCuisineList().size(); j++) {
			for (int i = 0; i < firstStep.size(); i++) {
				if (firstStep.get(i).getTransCuisine().getCname().equals(requestObject.getCuisineList().get(j))) {
					secondStep.add(firstStep.get(i));
				}
			}
		}

		List<TranslatedRecipe> thirdStep = new ArrayList<TranslatedRecipe>();
		for (int j = 0; j < requestObject.getMethodList().size(); j++) {
			for (int i = 0; i < secondStep.size(); i++) {
				if (secondStep.get(i).getTransMethod().getMname().equals(requestObject.getMethodList().get(j))) {
					thirdStep.add(secondStep.get(i));
				}
			}
		}

		return thirdStep;
	}
	
	
}
