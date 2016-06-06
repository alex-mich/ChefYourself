package Helpers;

import enumerations.TableType;
import pojos.Recipe;
import pojos.TranslatedRecipe;

public class RecipesQueryHelper {

	public static String constructRecipeInsertQuery(Recipe recipe, TableType tableType) {
		String query = "";
		switch (tableType) {
		case GREEK_TABLE:
			query = "INSERT INTO app_greek_recipes (grrid) VALUES (" + recipe.getRid() + ");";
			break;
		case GLOBAL_TABLE:
			query = "INSERT INTO app_global_recipes (glrid) VALUES (" + recipe.getRid() + ");";
			break;
		case SPANISH_TABLE:
			query = "INSERT INTO app_spanish_recipes (sprid) VALUES (" + recipe.getRid() + ");";
			break;
		}
		return query;
	}

	public static String constructRecipeDeleteQuery(Recipe recipe, TableType tableType) {
		String query = "";
		switch (tableType) {
		case GREEK_TABLE:
			query = "DELETE FROM app_greek_recipes WHERE grrid = " + recipe.getRid() + ";";
			break;
		case GLOBAL_TABLE:
			query = "DELETE FROM app_global_recipes WHERE glrid = " + recipe.getRid() + ";";
			break;
		case SPANISH_TABLE:
			query = "DELETE FROM app_spanish_recipes WHERE sprid = " + recipe.getRid() + ";";
			break;
		}
		return query;
	}

	public static String constructRecipeUpdateQuery(Recipe currentRecipe, Recipe updatedRecipe, TableType tableType) {
		String query = "";
		switch (tableType) {
		case GREEK_TABLE:
			query = "UPDATE app_greek_recipes SET grrid = " + updatedRecipe.getRid() + " WHERE grrid = "
					+ currentRecipe.getRid() + ";";
			break;
		case GLOBAL_TABLE:
			query = "UPDATE app_global_recipes SET glrid = " + updatedRecipe.getRid() + " WHERE glrid = "
					+ currentRecipe.getRid() + ";";
			break;
		case SPANISH_TABLE:
			query = "UPDATE app_spanish_recipes SET sprid = " + updatedRecipe.getRid() + " WHERE sprid = "
					+ currentRecipe.getRid() + ";";
			break;
		}
		return query;
	}

	public static String constructRecipeViewTableQuery(TableType tableType) {
		String query = "";
		switch (tableType) {
		case GREEK_TABLE:
			query = "SELECT * FROM app_greek_recipes ORDER BY grrid";
			break;
		case GLOBAL_TABLE:
			query = "SELECT * FROM app_global_recipes ORDER BY glrid";
			break;
		case SPANISH_TABLE:
			query = "SELECT * FROM app_spanish_recipes ORDER BY sprid";
			break;
		}
		return query;
	}

	public static String constructTranslatedRecipeInsertQuery(TableType tableType) {
		String query = "";
		switch (tableType) {
		case GREEK_TABLE:
			query = "INSERT INTO app_greek_recipes_trans (tgrrid,grrid,tcid,tmid,locale,grrname) VALUES (?,?,?,?,?,?)";
			break;
		case GLOBAL_TABLE:
			query = "INSERT INTO app_global_recipes_trans (tglrid,glrid,tcid,tmid,locale,glrname) VALUES (?,?,?,?,?,?)";
			break;
		case SPANISH_TABLE:
			query = "INSERT INTO app_spanish_recipes_trans (tsprid,sprid,tcid,tmid,locale,sprname) VALUES (?,?,?,?,?,?)";
			break;
		}
		return query;
	}

	public static String constructTranslatedRecipeDeleteQuery(TranslatedRecipe translatedRecipe, TableType tableType) {
		String query = "";
		switch (tableType) {
		case GREEK_TABLE:
			query = " DELETE FROM app_greek_recipes_trans WHERE tgrrid = " + translatedRecipe.getTrid() + ";";
			break;
		case GLOBAL_TABLE:
			query = " DELETE FROM app_global_recipes_trans WHERE tglrid = " + translatedRecipe.getTrid() + ";";
			break;
		case SPANISH_TABLE:
			query = " DELETE FROM app_spanish_recipes_trans WHERE tsprid = " + translatedRecipe.getTrid() + ";";
			break;
		}
		return query;
	}

	public static String constructTranslatedRecipeUpdateQuery(TranslatedRecipe currentTranslatedRecipe,
			TranslatedRecipe updatedTranslatedRecipe, TableType tableType) {
		String query = "";
		String set, where;
		switch (tableType) {
		case GREEK_TABLE:
			query = "UPDATE app_greek_recipes_trans ";

			set = "SET ";
			if (updatedTranslatedRecipe.getTrid() != 0)
				set += "tgrrid=" + updatedTranslatedRecipe.getTrid() + ", ";
			if (updatedTranslatedRecipe.getRecipe().getRid() != 0)
				set += "grrid=" + updatedTranslatedRecipe.getRecipe().getRid() + ", ";
			if (updatedTranslatedRecipe.getTransCuisine().getTcid() != 0)
				set += "tcid=" + updatedTranslatedRecipe.getTransCuisine().getTcid() + ", ";
			if (updatedTranslatedRecipe.getTransMethod().getTmid() != 0)
				set += "tmid=" + updatedTranslatedRecipe.getTransMethod().getTmid() + ", ";
			if (!updatedTranslatedRecipe.getLocale().getLoc().equals(""))
				set += "locale='" + updatedTranslatedRecipe.getLocale().getLoc() + "', ";
			if (!updatedTranslatedRecipe.getRname().equals(""))
				set += "grrname='" + updatedTranslatedRecipe.getRname() + "', ";
			set = (String) set.substring(0, set.length() - 2);
			query += set;
			where = " WHERE ";
			if (currentTranslatedRecipe.getTrid() != 0)
				where += "tgrrid=" + currentTranslatedRecipe.getTrid() + " AND ";
			if (currentTranslatedRecipe.getRecipe().getRid() != 0)
				where += "grrid=" + currentTranslatedRecipe.getRecipe().getRid() + " AND ";
			if (currentTranslatedRecipe.getTransCuisine().getTcid() != 0)
				where += "tcid=" + currentTranslatedRecipe.getTransCuisine().getTcid() + " AND ";
			if (currentTranslatedRecipe.getTransMethod().getTmid() != 0)
				where += "tmid=" + currentTranslatedRecipe.getTransMethod().getTmid() + " AND ";
			if (!currentTranslatedRecipe.getLocale().getLoc().equals(""))
				where += "locale='" + currentTranslatedRecipe.getLocale().getLoc() + "' AND ";
			if (!currentTranslatedRecipe.getRname().equals(""))
				where += "grrname='" + currentTranslatedRecipe.getRname() + "' AND ";
			where = (String) where.substring(0, where.length() - 5);
			query += where + ";";
			break;
		case GLOBAL_TABLE:
			query = "UPDATE app_global_recipes_trans ";
			set = "SET ";
			if (updatedTranslatedRecipe.getTrid() != 0)
				set += "tglrid=" + updatedTranslatedRecipe.getTrid() + ", ";
			if (updatedTranslatedRecipe.getRecipe().getRid() != 0)
				set += "glrid=" + updatedTranslatedRecipe.getRecipe().getRid() + ", ";
			if (updatedTranslatedRecipe.getTransCuisine().getTcid() != 0)
				set += "tcid=" + updatedTranslatedRecipe.getTransCuisine().getTcid() + ", ";
			if (updatedTranslatedRecipe.getTransMethod().getTmid() != 0)
				set += "tmid=" + updatedTranslatedRecipe.getTransMethod().getTmid() + ", ";
			if (!updatedTranslatedRecipe.getLocale().getLoc().equals(""))
				set += "locale='" + updatedTranslatedRecipe.getLocale().getLoc() + "', ";
			if (!updatedTranslatedRecipe.getRname().equals(""))
				set += "glrname='" + updatedTranslatedRecipe.getRname() + "', ";
			set = (String) set.substring(0, set.length() - 2);
			query += set;
			where = " WHERE ";
			if (currentTranslatedRecipe.getTrid() != 0)
				where += "tglrid=" + currentTranslatedRecipe.getTrid() + " AND ";
			if (currentTranslatedRecipe.getRecipe().getRid() != 0)
				where += "glrid=" + currentTranslatedRecipe.getRecipe().getRid() + " AND ";
			if (currentTranslatedRecipe.getTransCuisine().getTcid() != 0)
				where += "tcid=" + currentTranslatedRecipe.getTransCuisine().getTcid() + " AND ";
			if (currentTranslatedRecipe.getTransMethod().getTmid() != 0)
				where += "tmid=" + currentTranslatedRecipe.getTransMethod().getTmid() + " AND ";
			if (!currentTranslatedRecipe.getLocale().getLoc().equals(""))
				where += "locale='" + currentTranslatedRecipe.getLocale().getLoc() + "' AND ";
			if (!currentTranslatedRecipe.getRname().equals(""))
				where += "glrname='" + currentTranslatedRecipe.getRname() + "' AND ";
			where = (String) where.substring(0, where.length() - 5);
			query += where + ";";
			break;
		case SPANISH_TABLE:
			query = "UPDATE app_spanish_recipes_trans ";
			set = "SET ";
			if (updatedTranslatedRecipe.getTrid() != 0)
				set += "tsprid=" + updatedTranslatedRecipe.getTrid() + ", ";
			if (updatedTranslatedRecipe.getRecipe().getRid() != 0)
				set += "sprid=" + updatedTranslatedRecipe.getRecipe().getRid() + ", ";
			if (updatedTranslatedRecipe.getTransCuisine().getTcid() != 0)
				set += "tcid=" + updatedTranslatedRecipe.getTransCuisine().getTcid() + ", ";
			if (updatedTranslatedRecipe.getTransMethod().getTmid() != 0)
				set += "tmid=" + updatedTranslatedRecipe.getTransMethod().getTmid() + ", ";
			if (!updatedTranslatedRecipe.getLocale().getLoc().equals(""))
				set += "locale='" + updatedTranslatedRecipe.getLocale().getLoc() + "', ";
			if (!updatedTranslatedRecipe.getRname().equals(""))
				set += "sprname='" + updatedTranslatedRecipe.getRname() + "', ";
			set = (String) set.substring(0, set.length() - 2);
			query += set;
			where = " WHERE ";
			if (currentTranslatedRecipe.getTrid() != 0)
				where += "tsprid=" + currentTranslatedRecipe.getTrid() + " AND ";
			if (currentTranslatedRecipe.getRecipe().getRid() != 0)
				where += "sprid=" + currentTranslatedRecipe.getRecipe().getRid() + " AND ";
			if (currentTranslatedRecipe.getTransCuisine().getTcid() != 0)
				where += "tcid=" + currentTranslatedRecipe.getTransCuisine().getTcid() + " AND ";
			if (currentTranslatedRecipe.getTransMethod().getTmid() != 0)
				where += "tmid=" + currentTranslatedRecipe.getTransMethod().getTmid() + " AND ";
			if (!currentTranslatedRecipe.getLocale().getLoc().equals(""))
				where += "locale='" + currentTranslatedRecipe.getLocale().getLoc() + "' AND ";
			if (!currentTranslatedRecipe.getRname().equals(""))
				where += "sprname='" + currentTranslatedRecipe.getRname() + "' AND ";
			where = (String) where.substring(0, where.length() - 5);
			query += where + ";";
			break;
		}

		return query;
	}

	public static String constructTranslatedRecipeViewTableQuery(TableType tableType) {
		String query = "";
		switch (tableType) {
		case GREEK_TABLE:
			query = "SELECT * FROM app_greek_recipes_trans ORDER BY tgrrid";
			break;
		case GLOBAL_TABLE:
			query = "SELECT * FROM app_global_recipes_trans ORDER BY tglrid";
			break;
		case SPANISH_TABLE:
			query = "SELECT * FROM app_spanish_recipes_trans ORDER BY tsprid";
			break;
		}
		return query;
	}
	
	public static String constructTranslatedRecipeByTranslatedCuisineQuery(TranslatedRecipe translatedRecipe) {
		String query = "";
		switch (translatedRecipe.getTransCuisine().getCname()) {
		case "Greek Menu":
			query = "SELECT * FROM app_greek_recipes_trans ORDER BY tgrrid";
			break;
		case "Global Menu":
			query = "SELECT * FROM app_global_recipes_trans ORDER BY tglrid";
			break;
		case "Spanish Menu":
			query = "SELECT * FROM app_spanish_recipes_trans ORDER BY tsprid";
			break;
		case "Ελληνική Κουζίνα":
			query = "SELECT * FROM app_greek_recipes_trans ORDER BY tgrrid";
			break;
		case "Παγκόσμια Κουζίνα":
			query = "SELECT * FROM app_global_recipes_trans ORDER BY tglrid";
			break;
		case "Ισπανική Κουζίνα":
			query = "SELECT * FROM app_spanish_recipes_trans ORDER BY tsprid";
			break;
		}
		return query;
	}
	
}
