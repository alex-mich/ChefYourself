package Helpers;

import pojos.TranslatedRecipe;

public class DescriptionsQueryHelper {

	public static String contstuctRecipeDescriptionsByTranslatedRecipeQuery(TranslatedRecipe translatedRecipe) {
		String query = "";
		switch (translatedRecipe.getTransCuisine().getCname()) {
		case "Greek Menu":
			query = "SELECT grrdesc FROM app_greek_recipes_description WHERE tgrrid = (?)";
			break;
		case "Global Menu":
			query = "SELECT glrdesc FROM app_global_recipes_description WHERE tglrid = (?)";
			break;
		case "Spanish Menu":
			query = "SELECT sprdesc FROM app_spanish_recipes_description WHERE tsprid = (?)";
			break;
		case "Ελληνική Κουζίνα":
			query = "SELECT grrdesc FROM app_greek_recipes_description WHERE tgrrid = (?)";
			break;
		case "Παγκόσμια Κουζίνα":
			query = "SELECT glrdesc FROM app_global_recipes_description WHERE tglrid = (?)";
			break;
		case "Ισπανική Κουζίνα":
			query = "SELECT sprdesc FROM app_spanish_recipes_description WHERE tsprid = (?)";
			break;
		}
		return query;
	}
	
}
