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

import Helpers.RecipeIngredientsQueryHelper;
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
		final String grSQL = RecipeIngredientsQueryHelper.constuctInsertRecipeIngredientsQuery(tableType);
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
		final String recipeIngredientsTableQuery = RecipeIngredientsQueryHelper.contstuctViewRecipeIngredientsTableQuery(tableType);
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
		String sql = RecipeIngredientsQueryHelper.constructDeleteRecipeIngredientsQuery(tableType);
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
		String updateRecipeIngredientQuery = RecipeIngredientsQueryHelper.constructTranslatedRecipeUpdateQuery(currentRecipeIngredient,
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
	
	public List<RecipeIngredient> findRecipeIngredientsByTranslatedRecipe(TranslatedRecipe translatedRecipe) throws Exception {
		final String recipeIngredientsTableQuery = RecipeIngredientsQueryHelper.contstuctRecipeIngredientsByTranslatedRecipeQuery(translatedRecipe);
		List<RecipeIngredient> recipeIngredientsList = new ArrayList<RecipeIngredient>();
		List<TranslatedIngredient> translatedIngredientsList = tidi.findTranslatedIngredientsByLanguage(translatedRecipe.getLocale().getLoc());
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		try {
			con = DriverManager.getConnection(url, username, password);
			pstmt = con.prepareStatement(recipeIngredientsTableQuery);
			pstmt.setInt(1, translatedRecipe.getTrid());
			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				RecipeIngredient recipeIngredient = new RecipeIngredient();

				recipeIngredient.setRiid(resultSet.getInt(1));
				for (int i = 0; i < translatedIngredientsList.size(); i++)
					if (resultSet.getInt(3) == (translatedIngredientsList.get(i).getTinid())) {
						recipeIngredient.setTrIngredient(translatedIngredientsList.get(i));
					}
				recipeIngredient.setQuan(resultSet.getString(4));
				recipeIngredientsList.add(recipeIngredient);
			}
			pstmt.close();
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
			if (pstmt != null)
				try {
					pstmt.close();
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

}
