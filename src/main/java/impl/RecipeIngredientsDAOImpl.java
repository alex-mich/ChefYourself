package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.RecipeIngredientsDAO;
import impl.RecipesDAOImpl;
import pojos.RecipeIngredient;
import pojos.TranslatedIngredient;
import pojos.TranslatedRecipe;

public class RecipeIngredientsDAOImpl implements RecipeIngredientsDAO {

	private RecipesDAOImpl trdi;
	private IngredientsDAOImpl tidi;
	
	private String driver, url, username, password;
	List<TranslatedRecipe> transRecipesList;
	List<TranslatedIngredient> transIngredientsList;
	List<RecipeIngredient> recipeIngredientsList;
	
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
	public int insertGrRecipeIngredient(RecipeIngredient ri) throws Exception {
		final String grSQL = "INSERT INTO app_greek_recipes_ingredients (griid,tgrrid,tinid,grquan) VALUES (?,?,?,?)";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt;
		int i = 0;

		try {

			pstmt = con.prepareStatement(grSQL);
			pstmt.setInt(1, ri.getRiid());
			pstmt.setInt(2, ri.getTrRecipe().getTrid());
			pstmt.setInt(3, ri.getTrIngredient().getTinid());
			pstmt.setString(4, ri.getQuan());
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
	public int insertGlRecipeIngredient(RecipeIngredient ri) throws Exception {
		final String glSQL = "INSERT INTO app_global_recipes_ingredients (gliid,tglrid,tinid,glquan) VALUES (?,?,?,?)";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt;
		int i = 0;

		try {

			pstmt = con.prepareStatement(glSQL);
			pstmt.setInt(1, ri.getRiid());
			pstmt.setInt(2, ri.getTrRecipe().getTrid());
			pstmt.setInt(3, ri.getTrIngredient().getTinid());
			pstmt.setString(4, ri.getQuan());
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
	public int insertSpRecipeIngredient(RecipeIngredient ri) throws Exception {
		final String spSQL = "INSERT INTO app_spanish_recipes_ingredients (spiid,tsprid,tinid,srquan) VALUES (?,?,?,?)";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt;
		int i = 0;

		try {

			pstmt = con.prepareStatement(spSQL);
			pstmt.setInt(1, ri.getRiid());
			pstmt.setInt(2, ri.getTrRecipe().getTrid());
			pstmt.setInt(3, ri.getTrIngredient().getTinid());
			pstmt.setString(4, ri.getQuan());
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
	public List<RecipeIngredient> findIngredientForGrRecipesGr() throws Exception {
		final String allGrSQL = "SELECT * FROM app_greek_recipes_ingredients WHERE tgrrid % 2 = 1";
		recipeIngredientsList = new ArrayList<RecipeIngredient>();
		transRecipesList = trdi.findGreekRecipesGr();
		transIngredientsList = tidi.returnAllGrIngredients();
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
	public List<RecipeIngredient> findIngredientForGrRecipesEn() throws Exception {
		final String allGrSQL = "SELECT * FROM app_greek_recipes_ingredients WHERE tgrrid % 2 = 0";
		recipeIngredientsList = new ArrayList<RecipeIngredient>();
		transRecipesList = trdi.findGreekRecipesEn();
		transIngredientsList = tidi.returnAllEnIngredients();
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
	public List<RecipeIngredient> findIngredientForGlRecipesGr() throws Exception {
		final String allGlSQL = "SELECT * FROM app_global_recipes_ingredients WHERE tglrid % 2 = 1";
		recipeIngredientsList = new ArrayList<RecipeIngredient>();
		transRecipesList = trdi.findGlobalRecipesGr();
		transIngredientsList = tidi.returnAllGrIngredients();
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
	public List<RecipeIngredient> findIngredientForGlRecipesEn() throws Exception {
		final String allGlSQL = "SELECT * FROM app_global_recipes_ingredients WHERE tglrid % 2 = 0";
		recipeIngredientsList = new ArrayList<RecipeIngredient>();
		transRecipesList = trdi.findGlobalRecipesEn();
		transIngredientsList = tidi.returnAllEnIngredients();
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
	public List<RecipeIngredient> findIngredientForSpRecipesGr() throws Exception {
		final String allSpSQL = "SELECT * FROM app_spanish_recipes_ingredients WHERE tsprid % 2 = 1";
		recipeIngredientsList = new ArrayList<RecipeIngredient>();
		transRecipesList = trdi.findSpanishRecipesGr();
		transIngredientsList = tidi.returnAllGrIngredients();
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
	public List<RecipeIngredient> findIngredientForSpRecipesEn() throws Exception {
		final String allSpSQL = "SELECT * FROM app_spanish_recipes_ingredients WHERE tsprid % 2 = 0";
		recipeIngredientsList = new ArrayList<RecipeIngredient>();
		transRecipesList = trdi.findSpanishRecipesEn();
		transIngredientsList = tidi.returnAllEnIngredients();
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
	
	

}
