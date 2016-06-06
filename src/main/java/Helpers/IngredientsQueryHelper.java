package Helpers;

import pojos.Ingredient;
import pojos.TranslatedIngredient;

public class IngredientsQueryHelper {
	
	public static String constructIngredientUpdateQuery(Ingredient currentIngredient, Ingredient updatedIngredient) {
		String query = "UPDATE app_ingredients ";

		String set = "SET ";
		if (updatedIngredient.getInid() != 0)
			set += "inid=" + updatedIngredient.getInid() + ", ";
		if (!updatedIngredient.getItype().equals(""))
			set += "itype='" + updatedIngredient.getItype() + "', ";
		set = (String) set.substring(0, set.length() - 2);

		String where = "WHERE ";
		if (currentIngredient.getInid() != 0)
			where += "inid=" + currentIngredient.getInid() + " AND ";
		if (!currentIngredient.getItype().equals(""))
			where += "itype='" + currentIngredient.getItype() + "' AND ";
		where = (String) where.substring(0, where.length() - 5);

		set += where;
		query += set + ";";

		return query;
	}

	public static String constructTranslatedIngredientUpdateQuery(TranslatedIngredient currentTranslatedIngredient,
			TranslatedIngredient updatedTranslatedIngredient) {
		String query = "UPDATE app_ingredients_trans ";

		String set = "SET ";
		if (updatedTranslatedIngredient.getTinid() != 0)
			set += "tinid=" + updatedTranslatedIngredient.getTinid() + ", ";
		if (updatedTranslatedIngredient.getIngredient().getInid() != 0)
			set += "inid=" + updatedTranslatedIngredient.getIngredient().getInid() + ", ";
		if (!updatedTranslatedIngredient.getLocale().getLoc().equals(""))
			set += "locale='" + updatedTranslatedIngredient.getLocale().getLoc() + "', ";
		if (!updatedTranslatedIngredient.getIname().equals(""))
			set += "iname='" + updatedTranslatedIngredient.getIname() + "', ";
		set = (String) set.substring(0, set.length() - 2);

		String where = "WHERE ";
		if (currentTranslatedIngredient.getTinid() != 0)
			where += "tinid=" + currentTranslatedIngredient.getTinid() + " AND ";
		if (currentTranslatedIngredient.getIngredient().getInid() != 0)
			where += "inid=" + currentTranslatedIngredient.getIngredient().getInid() + " AND ";
		if (!currentTranslatedIngredient.getLocale().getLoc().equals(""))
			where += "locale='" + currentTranslatedIngredient.getLocale().getLoc() + "' AND ";
		if (!currentTranslatedIngredient.getIname().equals(""))
			where += "iname='" + currentTranslatedIngredient.getIname() + "' AND ";
		where = (String) where.substring(0, where.length() - 5);

		set += where;
		query += set + ";";

		return query;
	}
	
}
