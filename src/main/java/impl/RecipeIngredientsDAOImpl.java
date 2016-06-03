package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import dao.RecipeIngredientsDAO;
import enumerations.TableType;
import impl.RecipesDAOImpl;
import pojos.RecipeIngredient;
import pojos.TranslatedIngredient;
import pojos.TranslatedRecipe;

@Repository
public class RecipeIngredientsDAOImpl implements RecipeIngredientsDAO {

	private RecipesDAOImpl trdi;
	private IngredientsDAOImpl tidi;

	private String driver, url, username, password;
	List<TranslatedRecipe> transRecipesList;
	List<TranslatedIngredient> transIngredientsList;

	public void setTrdi(RecipesDAOImpl trdi) {
		this.trdi = trdi;
	}

	public void setTidi(IngredientsDAOImpl tidi) {
		this.tidi = tidi;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int insertRecipeIngredient(RecipeIngredient recipeIngredient, TableType tableType) throws Exception {
		final String grSQL = constuctInsertRecipeIngredientsQuery(tableType);
		Class.forName(driver);
		Connection con = null;
		PreparedStatement pstmt = null;
		int i = 0;

		try {
			con = DriverManager.getConnection(url, username, password);
			pstmt = con.prepareStatement(grSQL);
			pstmt.setInt(1, recipeIngredient.getRiid());
			pstmt.setInt(2, recipeIngredient.getTrRecipe().getTrid());
			pstmt.setInt(3, recipeIngredient.getTrIngredient().getTinid());
			pstmt.setString(4, recipeIngredient.getQuan());
			i = pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return i;
	}

	@Override
	public List<RecipeIngredient> findIngredientForGreekRecipesGr() throws Exception {
		final String allGrSQL = "SELECT * FROM app_greek_recipes_ingredients WHERE tgrrid % 2 = 1";
		List<RecipeIngredient> recipeIngredientsList = new ArrayList<RecipeIngredient>();
		transRecipesList = trdi.findGreekRecipesGr();
		transIngredientsList = tidi.findGrIngredients();
		Connection con = DriverManager.getConnection(url, username, password);

		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(allGrSQL);

			while (rs.next()) {
				RecipeIngredient rin = new RecipeIngredient();

				rin.setRiid(rs.getInt(1));
				for (int i = 0; i < transRecipesList.size(); i++)
					if (rs.getInt(2) == transRecipesList.get(i).getTrid()) {
						rin.setTrRecipe(transRecipesList.get(i));
					}
				for (int i = 0; i < transIngredientsList.size(); i++)
					if (rs.getInt(3) == (transIngredientsList.get(i).getTinid())) {
						rin.setTrIngredient(transIngredientsList.get(i));
					}
				rin.setQuan(rs.getString(4));
				recipeIngredientsList.add(rin);
			}
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return recipeIngredientsList;
	}

	@Override
	public List<RecipeIngredient> findIngredientForGreekRecipesEn() throws Exception {
		final String allGrSQL = "SELECT * FROM app_greek_recipes_ingredients WHERE tgrrid % 2 = 0";
		List<RecipeIngredient> recipeIngredientsList = new ArrayList<RecipeIngredient>();
		transRecipesList = trdi.findGreekRecipesEn();
		transIngredientsList = tidi.findEnIngredients();
		Connection con = DriverManager.getConnection(url, username, password);

		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(allGrSQL);

			while (rs.next()) {
				RecipeIngredient rin = new RecipeIngredient();

				rin.setRiid(rs.getInt(1));
				for (int i = 0; i < transRecipesList.size(); i++)
					if (rs.getInt(2) == transRecipesList.get(i).getTrid()) {
						rin.setTrRecipe(transRecipesList.get(i));
					}
				for (int i = 0; i < transIngredientsList.size(); i++)
					if (rs.getInt(3) == (transIngredientsList.get(i).getTinid())) {
						rin.setTrIngredient(transIngredientsList.get(i));
					}
				rin.setQuan(rs.getString(4));
				recipeIngredientsList.add(rin);
			}
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return recipeIngredientsList;
	}

	@Override
	public List<RecipeIngredient> findIngredientForGlobalRecipesGr() throws Exception {
		final String allGlSQL = "SELECT * FROM app_global_recipes_ingredients WHERE tglrid % 2 = 1";
		List<RecipeIngredient> recipeIngredientsList = new ArrayList<RecipeIngredient>();
		transRecipesList = trdi.findGlobalRecipesGr();
		transIngredientsList = tidi.findGrIngredients();
		Connection con = DriverManager.getConnection(url, username, password);

		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(allGlSQL);

			while (rs.next()) {
				RecipeIngredient rin = new RecipeIngredient();

				rin.setRiid(rs.getInt(1));
				for (int i = 0; i < transRecipesList.size(); i++)
					if (rs.getInt(2) == transRecipesList.get(i).getTrid()) {
						rin.setTrRecipe(transRecipesList.get(i));
					}
				for (int i = 0; i < transIngredientsList.size(); i++)
					if (rs.getInt(3) == (transIngredientsList.get(i).getTinid())) {
						rin.setTrIngredient(transIngredientsList.get(i));
					}
				rin.setQuan(rs.getString(4));
				recipeIngredientsList.add(rin);
			}
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return recipeIngredientsList;
	}

	@Override
	public List<RecipeIngredient> findIngredientForGlobalRecipesEn() throws Exception {
		final String allGlSQL = "SELECT * FROM app_global_recipes_ingredients WHERE tglrid % 2 = 0";
		List<RecipeIngredient> recipeIngredientsList = new ArrayList<RecipeIngredient>();
		transRecipesList = trdi.findGlobalRecipesEn();
		transIngredientsList = tidi.findEnIngredients();
		Connection con = DriverManager.getConnection(url, username, password);

		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(allGlSQL);

			while (rs.next()) {
				RecipeIngredient rin = new RecipeIngredient();

				rin.setRiid(rs.getInt(1));
				for (int i = 0; i < transRecipesList.size(); i++)
					if (rs.getInt(2) == transRecipesList.get(i).getTrid()) {
						rin.setTrRecipe(transRecipesList.get(i));
					}
				for (int i = 0; i < transIngredientsList.size(); i++)
					if (rs.getInt(3) == (transIngredientsList.get(i).getTinid())) {
						rin.setTrIngredient(transIngredientsList.get(i));
					}
				rin.setQuan(rs.getString(4));
				recipeIngredientsList.add(rin);
			}
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return recipeIngredientsList;
	}

	@Override
	public List<RecipeIngredient> findIngredientForSpanishRecipesGr() throws Exception {
		final String allSpSQL = "SELECT * FROM app_spanish_recipes_ingredients WHERE tsprid % 2 = 1";
		List<RecipeIngredient> recipeIngredientsList = new ArrayList<RecipeIngredient>();
		transRecipesList = trdi.findSpanishRecipesGr();
		transIngredientsList = tidi.findGrIngredients();
		Connection con = DriverManager.getConnection(url, username, password);

		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(allSpSQL);

			while (rs.next()) {
				RecipeIngredient rin = new RecipeIngredient();

				rin.setRiid(rs.getInt(1));
				for (int i = 0; i < transRecipesList.size(); i++)
					if (rs.getInt(2) == transRecipesList.get(i).getTrid()) {
						rin.setTrRecipe(transRecipesList.get(i));
					}
				for (int i = 0; i < transIngredientsList.size(); i++)
					if (rs.getInt(3) == (transIngredientsList.get(i).getTinid())) {
						rin.setTrIngredient(transIngredientsList.get(i));
					}
				rin.setQuan(rs.getString(4));
				recipeIngredientsList.add(rin);
			}
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return recipeIngredientsList;
	}

	@Override
	public List<RecipeIngredient> findIngredientForSpanishRecipesEn() throws Exception {
		final String allSpSQL = "SELECT * FROM app_spanish_recipes_ingredients WHERE tsprid % 2 = 0";
		List<RecipeIngredient> recipeIngredientsList = new ArrayList<RecipeIngredient>();
		transRecipesList = trdi.findSpanishRecipesEn();
		transIngredientsList = tidi.findEnIngredients();
		Connection con = DriverManager.getConnection(url, username, password);

		try {

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(allSpSQL);

			while (rs.next()) {
				RecipeIngredient rin = new RecipeIngredient();

				rin.setRiid(rs.getInt(1));
				for (int i = 0; i < transRecipesList.size(); i++)
					if (rs.getInt(2) == transRecipesList.get(i).getTrid()) {
						rin.setTrRecipe(transRecipesList.get(i));
					}
				for (int i = 0; i < transIngredientsList.size(); i++)
					if (rs.getInt(3) == (transIngredientsList.get(i).getTinid())) {
						rin.setTrIngredient(transIngredientsList.get(i));
					}
				rin.setQuan(rs.getString(4));
				recipeIngredientsList.add(rin);
			}
			stmt.close();
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return recipeIngredientsList;
	}

	@Override
	public List<RecipeIngredient> viewRecipeIngredientsTable(TableType tableType) throws Exception {
		final String recipeIngredientsTableQuery = contstuctRecipeIngredientsTable(tableType);
		List<RecipeIngredient> recipeIngredientsList = new ArrayList<RecipeIngredient>();
		List<TranslatedRecipe> translatedRecipesList = trdi.findAllTranslatedRecipesByCuisine(tableType);
		List<TranslatedIngredient> translatedIngredientsList = tidi.findAllTranslatedIngredients();
		Connection con = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(recipeIngredientsTableQuery);

			while (resultSet.next()) {
				RecipeIngredient recipeIngredient = new RecipeIngredient();

				recipeIngredient.setRiid(resultSet.getInt(1));
				for (int i = 0; i < translatedRecipesList.size(); i++)
					if (resultSet.getInt(2) == translatedRecipesList.get(i).getTrid()) {
						recipeIngredient.setTrRecipe(translatedRecipesList.get(i));
					}
				for (int i = 0; i < translatedIngredientsList.size(); i++)
					if (resultSet.getInt(3) == (translatedIngredientsList.get(i).getTinid())) {
						recipeIngredient.setTrIngredient(translatedIngredientsList.get(i));
					}
				recipeIngredient.setQuan(resultSet.getString(4));
				recipeIngredientsList.add(recipeIngredient);
			}
			stmt.close();
			resultSet.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null)
				try {
					resultSet.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return recipeIngredientsList;
	}

	@Override
	public int deleteRecipeIngredient(RecipeIngredient recipeIngredient, TableType tableType) throws Exception {
		String sql = constructDeleteRecipeIngredientsQuery(tableType);
		Class.forName(driver);
		Connection con = null;
		PreparedStatement pstmt = null;
		int i = 0;
		try {
			con = DriverManager.getConnection(url, username, password);
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, recipeIngredient.getRiid());
			i = pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updateRecipeIngredient(RecipeIngredient currentRecipeIngredient,
			RecipeIngredient updatedRecipeIngredient, TableType tableType) throws Exception {
		String updateRecipeIngredientQuery = constructTranslatedRecipeUpdateQuery(currentRecipeIngredient,
				updatedRecipeIngredient, tableType);
		System.out.println(updateRecipeIngredientQuery);
		Class.forName(driver);
		Connection con = null;
		Statement stmt = null;
		int i = 0;
		try {
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			i = stmt.executeUpdate(updateRecipeIngredientQuery);
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stmt != null)
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return i;
	}

	public String contstuctRecipeIngredientsTable(TableType tableType) {
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

	public String constructTranslatedRecipeUpdateQuery(RecipeIngredient currentRecipeIngredient,
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

	public String constuctInsertRecipeIngredientsQuery(TableType tableType) {
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

	public String constructDeleteRecipeIngredientsQuery(TableType tableType) {
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

}
