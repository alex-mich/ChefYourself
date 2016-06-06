package Helpers;

import enumerations.TableType;
import pojos.RecipeIngredient;
import pojos.TranslatedRecipe;

public class RecipeIngredientsQueryHelper {

	public static String constuctInsertRecipeIngredientsQuery(TableType tableType) {
		String query = "";
		switch (tableType) {
		case GREEK_TABLE:
			query = "INSERT INTO app_greek_recipes_ingredients (griid,tgrrid,tinid,grquan) VALUES (?,?,?,?)";
			break;
		case GLOBAL_TABLE:
			query = "INSERT INTO app_global_recipes_ingredients (gliid,tglrid,tinid,glquan) VALUES (?,?,?,?)";
			break;
		case SPANISH_TABLE:
			query = "INSERT INTO app_spanish_recipes_ingredients (spiid,tsprid,tinid,srquan) VALUES (?,?,?,?)";
			break;
		}
		return query;
	}

	public static String constructDeleteRecipeIngredientsQuery(TableType tableType) {
		String query = "";
		switch (tableType) {
		case GREEK_TABLE:
			query = "DELETE FROM app_greek_recipes_ingredients WHERE griid = (?)";
			break;
		case GLOBAL_TABLE:
			query = "DELETE FROM app_global_recipes_ingredients WHERE gliid = (?)";
			break;
		case SPANISH_TABLE:
			query = "DELETE FROM app_spanish_recipes_ingredients WHERE spiid = (?)";
			break;
		}
		return query;
	}

	public static String constructTranslatedRecipeUpdateQuery(RecipeIngredient currentRecipeIngredient,
			RecipeIngredient updatedRecipeIngredient, TableType tableType) {
		String query = "";
		String set, where;
		switch (tableType) {
		case GREEK_TABLE:

			query = "UPDATE app_greek_recipes_ingredients ";
			set = "SET ";
			if (updatedRecipeIngredient.getRiid() != 0)
				set += "griid=" + updatedRecipeIngredient.getRiid() + ", ";
			if (updatedRecipeIngredient.getTrRecipe().getTrid() != 0)
				set += "tgrrid=" + updatedRecipeIngredient.getTrRecipe().getTrid() + ", ";
			if (updatedRecipeIngredient.getTrIngredient().getTinid() != 0)
				set += "tinid=" + updatedRecipeIngredient.getTrIngredient().getTinid() + ", ";
			if (!updatedRecipeIngredient.getQuan().equals(""))
				set += "grquan='" + updatedRecipeIngredient.getQuan() + "', ";
			set = (String) set.substring(0, set.length() - 2);
			query += set;
			where = " WHERE ";
			if (currentRecipeIngredient.getRiid() != 0)
				where += "griid=" + currentRecipeIngredient.getRiid() + " AND ";
			if (currentRecipeIngredient.getTrRecipe().getTrid() != 0)
				where += "tgrrid=" + currentRecipeIngredient.getTrRecipe().getTrid() + " AND ";
			if (currentRecipeIngredient.getTrIngredient().getTinid() != 0)
				where += "tinid=" + currentRecipeIngredient.getTrIngredient().getTinid() + " AND ";
			if (!currentRecipeIngredient.getQuan().equals(""))
				where += "grquan='" + currentRecipeIngredient.getQuan() + "' AND ";
			where = (String) where.substring(0, where.length() - 5);
			query += where + ";";
			break;
		case GLOBAL_TABLE:

			query = "UPDATE app_global_recipes_ingredients ";
			set = "SET ";
			if (updatedRecipeIngredient.getRiid() != 0)
				set += "gliid=" + updatedRecipeIngredient.getRiid() + ", ";
			if (updatedRecipeIngredient.getTrRecipe().getTrid() != 0)
				set += "tglrid=" + updatedRecipeIngredient.getTrRecipe().getTrid() + ", ";
			if (updatedRecipeIngredient.getTrIngredient().getTinid() != 0)
				set += "tinid=" + updatedRecipeIngredient.getTrIngredient().getTinid() + ", ";
			if (!updatedRecipeIngredient.getQuan().equals(""))
				set += "glquan='" + updatedRecipeIngredient.getQuan() + "', ";
			set = (String) set.substring(0, set.length() - 2);
			query += set;
			where = " WHERE ";
			if (currentRecipeIngredient.getRiid() != 0)
				where += "gliid=" + currentRecipeIngredient.getRiid() + " AND ";
			if (currentRecipeIngredient.getTrRecipe().getTrid() != 0)
				where += "tglrid=" + currentRecipeIngredient.getTrRecipe().getTrid() + " AND ";
			if (currentRecipeIngredient.getTrIngredient().getTinid() != 0)
				where += "tinid=" + currentRecipeIngredient.getTrIngredient().getTinid() + " AND ";
			if (!currentRecipeIngredient.getQuan().equals(""))
				where += "glquan='" + currentRecipeIngredient.getQuan() + "' AND ";
			where = (String) where.substring(0, where.length() - 5);
			query += where + ";";
			break;
		case SPANISH_TABLE:

			query = "UPDATE app_spanish_recipes_ingredients ";
			set = "SET ";
			if (updatedRecipeIngredient.getRiid() != 0)
				set += "spiid=" + updatedRecipeIngredient.getRiid() + ", ";
			if (updatedRecipeIngredient.getTrRecipe().getTrid() != 0)
				set += "tsprid=" + updatedRecipeIngredient.getTrRecipe().getTrid() + ", ";
			if (updatedRecipeIngredient.getTrIngredient().getTinid() != 0)
				set += "tinid=" + updatedRecipeIngredient.getTrIngredient().getTinid() + ", ";
			if (!updatedRecipeIngredient.getQuan().equals(""))
				set += "srquan='" + updatedRecipeIngredient.getQuan() + "', ";
			set = (String) set.substring(0, set.length() - 2);
			query += set;
			where = " WHERE ";
			if (currentRecipeIngredient.getRiid() != 0)
				where += "spiid=" + currentRecipeIngredient.getRiid() + " AND ";
			if (currentRecipeIngredient.getTrRecipe().getTrid() != 0)
				where += "tsprid=" + currentRecipeIngredient.getTrRecipe().getTrid() + " AND ";
			if (currentRecipeIngredient.getTrIngredient().getTinid() != 0)
				where += "tinid=" + currentRecipeIngredient.getTrIngredient().getTinid() + " AND ";
			if (!currentRecipeIngredient.getQuan().equals(""))
				where += "srquan='" + currentRecipeIngredient.getQuan() + "' AND ";
			where = (String) where.substring(0, where.length() - 5);
			query += where + ";";
			break;
		}
		return query;
	}

	public static String contstuctViewRecipeIngredientsTableQuery(TableType tableType) {
		String query = "";
		switch (tableType) {
		case GREEK_TABLE:
			query = "SELECT * FROM app_greek_recipes_ingredients ORDER BY griid";
			break;
		case GLOBAL_TABLE:
			query = "SELECT * FROM app_global_recipes_ingredients ORDER BY gliid";
			break;
		case SPANISH_TABLE:
			query = "SELECT * FROM app_spanish_recipes_ingredients ORDER BY spiid";
			break;
		}
		return query;
	}
	
	public static String contstuctRecipeIngredientsByTranslatedRecipeQuery(TranslatedRecipe translatedRecipe) {
		String query = "";
		switch (translatedRecipe.getTransCuisine().getCname()) {
		case "Greek Menu":
			query = "SELECT * FROM app_greek_recipes_ingredients WHERE tgrrid = (?) ORDER BY griid";
			break;
		case "Global Menu":
			query = "SELECT * FROM app_global_recipes_ingredients WHERE tglrid = (?) ORDER BY gliid";
			break;
		case "Spanish Menu":
			query = "SELECT * FROM app_spanish_recipes_ingredients WHERE tsprid = (?) ORDER BY spiid";
			break;
		case "Ελληνική Κουζίνα":
			query = "SELECT * FROM app_greek_recipes_ingredients WHERE tgrrid = (?) ORDER BY griid";
			break;
		case "Παγκόσμια Κουζίνα":
			query = "SELECT * FROM app_global_recipes_ingredients WHERE tglrid = (?) ORDER BY gliid";
			break;
		case "Ισπανική Κουζίνα":
			query = "SELECT * FROM app_spanish_recipes_ingredients WHERE tsprid = (?) ORDER BY spiid";
			break;
		}
		return query;
	}
	

}
