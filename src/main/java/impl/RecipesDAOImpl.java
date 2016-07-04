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

import Helpers.RecipesQueryHelper;
import dao.RecipesDAO;
import enumerations.TableType;
import pojos.Language;
import pojos.Recipe;
import pojos.TranslatedCuisine;
import pojos.TranslatedMethod;
import pojos.TranslatedRecipe;

@Repository
public class RecipesDAOImpl implements RecipesDAO {

	private LanguagesDAOImpl ldi;
	private CuisinesDAOImpl tcdi;
	private MethodsDAOImpl tmdi;

	private String driver, url, username, password;

	private List<Language> localeList;
	private List<Recipe> recipesList;
	private List<TranslatedMethod> transMethodsList;
	private List<TranslatedCuisine> transCuisinesList;
	private List<TranslatedRecipe> translatedRecipesList;

	public void setLdi(LanguagesDAOImpl ldi) {
		this.ldi = ldi;
	}

	public void setTcdi(CuisinesDAOImpl tcdi) {
		this.tcdi = tcdi;
	}

	public void setTmdi(MethodsDAOImpl tmdi) {
		this.tmdi = tmdi;
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
	public int insertRecipe(Recipe recipe, TableType tableType) throws Exception {
		String insertRecipeQuery = RecipesQueryHelper.constructRecipeInsertQuery(recipe, tableType);
		Class.forName(driver);
		Connection con = null;
		Statement stmt = null;
		int i = 0;
		try {
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			i = stmt.executeUpdate(insertRecipeQuery);
		} catch (SQLException e) {
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

	@Override
	public int insertTranslatedRecipe(TranslatedRecipe trRecipe, TableType tableType) throws Exception {
		final String grSQL = RecipesQueryHelper.constructTranslatedRecipeInsertQuery(tableType);
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt;
		int i = 0;

		try {

			pstmt = con.prepareStatement(grSQL);
			pstmt.setInt(1, trRecipe.getTrid());
			pstmt.setInt(2, trRecipe.getRecipe().getRid());
			pstmt.setInt(3, trRecipe.getTransCuisine().getTcid());
			pstmt.setInt(4, trRecipe.getTransMethod().getTmid());
			pstmt.setString(5, trRecipe.getLocale().getLoc());
			pstmt.setString(6, trRecipe.getRname());
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
	public List<Recipe> viewRecipesTable(TableType tableType) throws Exception {
		String viewTranslatedRecipeTableQuery = RecipesQueryHelper.constructRecipeViewTableQuery(tableType);
		recipesList = new ArrayList<Recipe>();
		Class.forName(driver);
		Connection con = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(viewTranslatedRecipeTableQuery);
			while (resultSet.next()) {
				Recipe recipe = new Recipe(resultSet.getInt(1));
				recipesList.add(recipe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null)
				try {
					stmt.close();
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
		return recipesList;
	}

	@Override
	public List<TranslatedRecipe> viewTranslatedRecipesTable(TableType tableType) throws Exception {
		String viewTranslatedRecipeTableQuery = RecipesQueryHelper.constructTranslatedRecipeViewTableQuery(tableType);
		List<TranslatedRecipe> translatedRecipesList = new ArrayList<TranslatedRecipe>();
		List<Language> localeList = ldi.findLocales();
		List<TranslatedMethod> translatedMethodsList = tmdi.findAllTranslatedMethods();
		List<TranslatedCuisine> translatedCuisinesList = tcdi.findAllTranslatedCuisines();
		Class.forName(driver);
		Connection con = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(viewTranslatedRecipeTableQuery);
			while (resultSet.next()) {
				Recipe recipe = new Recipe(resultSet.getInt(2));
				TranslatedCuisine translatedCuisine = new TranslatedCuisine();
				TranslatedMethod translatedMethod = new TranslatedMethod();
				Language locale = new Language();
				for (int i = 0; i < translatedCuisinesList.size(); i++)
					if (resultSet.getInt(3) == translatedCuisinesList.get(i).getTcid()) {
						translatedCuisine.setTcid(resultSet.getInt(3));
					}
				for (int i = 0; i < translatedMethodsList.size(); i++)
					if (resultSet.getInt(4) == translatedMethodsList.get(i).getTmid()) {
						translatedMethod.setTmid(resultSet.getInt(4));
					}
				for (int i = 0; i < localeList.size(); i++)
					if (resultSet.getString(5).equals(localeList.get(i).getLoc())) {
						locale.setLoc(resultSet.getString(5));
					}
				TranslatedRecipe translatedRecipe = new TranslatedRecipe(resultSet.getInt(1), recipe, translatedCuisine,
						translatedMethod, locale, resultSet.getString(6));
				translatedRecipesList.add(translatedRecipe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null)
				try {
					stmt.close();
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
		return translatedRecipesList;
	}

	@Override
	public List<TranslatedRecipe> findGreekRecipesGr() throws Exception {
		final String allGrSQL = "SELECT * FROM app_greek_recipes_trans WHERE locale = 'el' ORDER BY tgrrid";
		localeList = ldi.findLocales();
		transMethodsList = tmdi.findGrMethods();
		transCuisinesList = tcdi.findGrCuisines();
		translatedRecipesList = new ArrayList<TranslatedRecipe>();
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);

		try {

			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allGrSQL);
			while (rs.next()) {
				Recipe rec = new Recipe();
				TranslatedRecipe trRecipe = new TranslatedRecipe();

				trRecipe.setTrid(rs.getInt(1));
				rec.setRid(rs.getInt(2));
				trRecipe.setRecipe(rec);
				for (int i = 0; i < transCuisinesList.size(); i++)
					if (rs.getInt(3) == transCuisinesList.get(i).getTcid()) {
						trRecipe.setTransCuisine(transCuisinesList.get(i));
					}
				for (int i = 0; i < transMethodsList.size(); i++)
					if (rs.getInt(4) == transMethodsList.get(i).getTmid()) {
						trRecipe.setTransMethod(transMethodsList.get(i));
					}
				for (int i = 0; i < localeList.size(); i++)
					if (rs.getString(5).equals(localeList.get(i).getLoc())) {
						trRecipe.setLocale(localeList.get(i));
					}
				trRecipe.setRname(rs.getString(6));
				translatedRecipesList.add(trRecipe);
			}
			ps.close();
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
		return translatedRecipesList;
	}

	@Override
	public List<TranslatedRecipe> findGreekRecipesEn() throws Exception {
		final String allGrSQL = "SELECT * FROM app_greek_recipes_trans WHERE locale = 'en' ORDER BY tgrrid";
		localeList = ldi.findLocales();
		transMethodsList = tmdi.findEnMethods();
		transCuisinesList = tcdi.findEnCuisines();
		translatedRecipesList = new ArrayList<TranslatedRecipe>();

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);

		try {

			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allGrSQL);
			while (rs.next()) {
				Recipe rec = new Recipe();
				TranslatedRecipe trRecipe = new TranslatedRecipe();

				trRecipe.setTrid(rs.getInt(1));
				rec.setRid(rs.getInt(2));
				trRecipe.setRecipe(rec);
				for (int i = 0; i < transCuisinesList.size(); i++)
					if (rs.getInt(3) == transCuisinesList.get(i).getTcid()) {
						trRecipe.setTransCuisine(transCuisinesList.get(i));
					}
				for (int i = 0; i < transMethodsList.size(); i++)
					if (rs.getInt(4) == transMethodsList.get(i).getTmid()) {
						trRecipe.setTransMethod(transMethodsList.get(i));
					}
				for (int i = 0; i < localeList.size(); i++)
					if (rs.getString(5).equals(localeList.get(i).getLoc())) {
						trRecipe.setLocale(localeList.get(i));
					}
				trRecipe.setRname(rs.getString(6));
				translatedRecipesList.add(trRecipe);
			}
			ps.close();
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
		return translatedRecipesList;
	}

	@Override
	public List<TranslatedRecipe> findSpanishRecipesGr() throws Exception {

		final String allGrSQL = "SELECT * FROM app_spanish_recipes_trans WHERE locale = 'el'";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		localeList = ldi.findLocales();
		transMethodsList = tmdi.findGrMethods();
		transCuisinesList = tcdi.findGrCuisines();
		translatedRecipesList = new ArrayList<TranslatedRecipe>();

		try {
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allGrSQL);
			while (rs.next()) {
				Recipe rec = new Recipe();
				TranslatedRecipe trRecipe = new TranslatedRecipe();

				trRecipe.setTrid(rs.getInt(1));
				rec.setRid(rs.getInt(2));
				trRecipe.setRecipe(rec);
				for (int i = 0; i < transCuisinesList.size(); i++)
					if (rs.getInt(3) == transCuisinesList.get(i).getTcid()) {
						trRecipe.setTransCuisine(transCuisinesList.get(i));
					}
				for (int i = 0; i < transMethodsList.size(); i++)
					if (rs.getInt(4) == transMethodsList.get(i).getTmid()) {
						trRecipe.setTransMethod(transMethodsList.get(i));
					}
				for (int i = 0; i < localeList.size(); i++)
					if (rs.getString(5).equals(localeList.get(i).getLoc())) {
						trRecipe.setLocale(localeList.get(i));
					}
				trRecipe.setRname(rs.getString(6));
				translatedRecipesList.add(trRecipe);
			}
			ps.close();
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
		return translatedRecipesList;
	}

	@Override
	public List<TranslatedRecipe> findSpanishRecipesEn() throws Exception {
		final String allEnSQL = "SELECT * FROM app_spanish_recipes_trans WHERE locale = 'en'";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		transMethodsList = tmdi.findEnMethods();
		transCuisinesList = tcdi.findEnCuisines();
		localeList = ldi.findLocales();
		translatedRecipesList = new ArrayList<TranslatedRecipe>();

		try {
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allEnSQL);
			while (rs.next()) {
				Recipe rec = new Recipe();
				TranslatedRecipe trRecipe = new TranslatedRecipe();

				trRecipe.setTrid(rs.getInt(1));
				rec.setRid(rs.getInt(2));
				trRecipe.setRecipe(rec);
				for (int i = 0; i < transCuisinesList.size(); i++)
					if (rs.getInt(3) == transCuisinesList.get(i).getTcid()) {
						trRecipe.setTransCuisine(transCuisinesList.get(i));
					}
				for (int i = 0; i < transMethodsList.size(); i++)
					if (rs.getInt(4) == transMethodsList.get(i).getTmid()) {
						trRecipe.setTransMethod(transMethodsList.get(i));
					}
				for (int i = 0; i < localeList.size(); i++)
					if (rs.getString(5).equals(localeList.get(i).getLoc())) {
						trRecipe.setLocale(localeList.get(i));
					}
				trRecipe.setRname(rs.getString(6));
				translatedRecipesList.add(trRecipe);
			}
			ps.close();
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
		return translatedRecipesList;
	}

	@Override
	public List<TranslatedRecipe> findGlobalRecipesGr() throws Exception {
		final String allGrSQL = "SELECT * FROM app_global_recipes_trans WHERE locale = 'el'";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);

		localeList = ldi.findLocales();
		transMethodsList = tmdi.findGrMethods();
		transCuisinesList = tcdi.findGrCuisines();
		translatedRecipesList = new ArrayList<TranslatedRecipe>();

		try {
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allGrSQL);
			while (rs.next()) {
				Recipe rec = new Recipe();
				TranslatedRecipe trRecipe = new TranslatedRecipe();

				trRecipe.setTrid(rs.getInt(1));
				rec.setRid(rs.getInt(2));
				trRecipe.setRecipe(rec);
				for (int i = 0; i < transCuisinesList.size(); i++)
					if (rs.getInt(3) == transCuisinesList.get(i).getTcid()) {
						trRecipe.setTransCuisine(transCuisinesList.get(i));
					}
				for (int i = 0; i < transMethodsList.size(); i++)
					if (rs.getInt(4) == transMethodsList.get(i).getTmid()) {
						trRecipe.setTransMethod(transMethodsList.get(i));
					}
				for (int i = 0; i < localeList.size(); i++)
					if (rs.getString(5).equals(localeList.get(i).getLoc())) {
						trRecipe.setLocale(localeList.get(i));
					}
				trRecipe.setRname(rs.getString(6));
				translatedRecipesList.add(trRecipe);
			}
			ps.close();
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
		return translatedRecipesList;
	}

	@Override
	public List<TranslatedRecipe> findGlobalRecipesEn() throws Exception {
		final String allEnSQL = "SELECT * FROM app_global_recipes_trans WHERE locale = 'en'";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		localeList = ldi.findLocales();
		transMethodsList = tmdi.findEnMethods();
		transCuisinesList = tcdi.findEnCuisines();
		translatedRecipesList = new ArrayList<TranslatedRecipe>();

		try {
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allEnSQL);
			while (rs.next()) {
				Recipe rec = new Recipe();
				TranslatedRecipe trRecipe = new TranslatedRecipe();

				trRecipe.setTrid(rs.getInt(1));
				rec.setRid(rs.getInt(2));
				trRecipe.setRecipe(rec);
				for (int i = 0; i < transCuisinesList.size(); i++)
					if (rs.getInt(3) == transCuisinesList.get(i).getTcid()) {
						trRecipe.setTransCuisine(transCuisinesList.get(i));
					}
				for (int i = 0; i < transMethodsList.size(); i++)
					if (rs.getInt(4) == transMethodsList.get(i).getTmid()) {
						trRecipe.setTransMethod(transMethodsList.get(i));
					}
				for (int i = 0; i < localeList.size(); i++)
					if (rs.getString(5).equals(localeList.get(i).getLoc())) {
						trRecipe.setLocale(localeList.get(i));
					}
				trRecipe.setRname(rs.getString(6));
				translatedRecipesList.add(trRecipe);
			}
			ps.close();
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
		return translatedRecipesList;
	}

	@Override
	public List<TranslatedRecipe> findAllRecipesEn() throws Exception {
		final String allEnSQL = "SELECT * FROM app_greek_recipes_trans WHERE locale = 'en'" + " UNION"
				+ " SELECT * FROM app_global_recipes_trans WHERE locale = 'en'" + " UNION"
				+ " SELECT * FROM app_spanish_recipes_trans WHERE locale = 'en'";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		localeList = ldi.findLocales();
		transMethodsList = tmdi.findEnMethods();
		transCuisinesList = tcdi.findEnCuisines();
		translatedRecipesList = new ArrayList<TranslatedRecipe>();

		try {
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allEnSQL);
			while (rs.next()) {
				Recipe rec = new Recipe();
				TranslatedRecipe trRecipe = new TranslatedRecipe();

				trRecipe.setTrid(rs.getInt(1));
				rec.setRid(rs.getInt(2));
				trRecipe.setRecipe(rec);
				for (int i = 0; i < transCuisinesList.size(); i++)
					if (rs.getInt(3) == transCuisinesList.get(i).getTcid()) {
						trRecipe.setTransCuisine(transCuisinesList.get(i));
					}
				for (int i = 0; i < transMethodsList.size(); i++)
					if (rs.getInt(4) == transMethodsList.get(i).getTmid()) {
						trRecipe.setTransMethod(transMethodsList.get(i));
					}
				for (int i = 0; i < localeList.size(); i++)
					if (rs.getString(5).equals(localeList.get(i).getLoc())) {
						trRecipe.setLocale(localeList.get(i));
					}
				trRecipe.setRname(rs.getString(6));
				translatedRecipesList.add(trRecipe);
			}
			ps.close();
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
		return translatedRecipesList;
	}

	@Override
	public List<TranslatedRecipe> findAllRecipesGr() throws Exception {
		final String allGrSQL = "SELECT * FROM app_greek_recipes_trans WHERE locale = 'el'" + " UNION"
				+ " SELECT * FROM app_global_recipes_trans WHERE locale = 'el'" + " UNION"
				+ " SELECT * FROM app_spanish_recipes_trans WHERE locale = 'el'";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		localeList = ldi.findLocales();
		transMethodsList = tmdi.findGrMethods();
		transCuisinesList = tcdi.findGrCuisines();
		translatedRecipesList = new ArrayList<TranslatedRecipe>();

		try {
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allGrSQL);
			while (rs.next()) {
				Recipe rec = new Recipe();
				TranslatedRecipe trRecipe = new TranslatedRecipe();

				trRecipe.setTrid(rs.getInt(1));
				rec.setRid(rs.getInt(2));
				trRecipe.setRecipe(rec);
				for (int i = 0; i < transCuisinesList.size(); i++)
					if (rs.getInt(3) == transCuisinesList.get(i).getTcid()) {
						trRecipe.setTransCuisine(transCuisinesList.get(i));
					}
				for (int i = 0; i < transMethodsList.size(); i++)
					if (rs.getInt(4) == transMethodsList.get(i).getTmid()) {
						trRecipe.setTransMethod(transMethodsList.get(i));
					}
				for (int i = 0; i < localeList.size(); i++)
					if (rs.getString(5).equals(localeList.get(i).getLoc())) {
						trRecipe.setLocale(localeList.get(i));
					}
				trRecipe.setRname(rs.getString(6));
				translatedRecipesList.add(trRecipe);
			}
			ps.close();
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
		return translatedRecipesList;
	}

	public List<TranslatedRecipe> findAllTranslatedRecipesByCuisine(TableType tableType) throws Exception {
		final String allGrSQL = RecipesQueryHelper.constructTranslatedRecipeViewTableQuery(tableType);
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		localeList = ldi.findLocales();
		transMethodsList = tmdi.findAllTranslatedMethods();
		transCuisinesList = tcdi.findAllTranslatedCuisines();
		translatedRecipesList = new ArrayList<TranslatedRecipe>();

		try {
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allGrSQL);
			while (rs.next()) {
				Recipe rec = new Recipe();
				TranslatedRecipe trRecipe = new TranslatedRecipe();

				trRecipe.setTrid(rs.getInt(1));
				rec.setRid(rs.getInt(2));
				trRecipe.setRecipe(rec);
				for (int i = 0; i < transCuisinesList.size(); i++)
					if (rs.getInt(3) == transCuisinesList.get(i).getTcid()) {
						trRecipe.setTransCuisine(transCuisinesList.get(i));
					}
				for (int i = 0; i < transMethodsList.size(); i++)
					if (rs.getInt(4) == transMethodsList.get(i).getTmid()) {
						trRecipe.setTransMethod(transMethodsList.get(i));
					}
				for (int i = 0; i < localeList.size(); i++)
					if (rs.getString(5).equals(localeList.get(i).getLoc())) {
						trRecipe.setLocale(localeList.get(i));
					}
				trRecipe.setRname(rs.getString(6));
				translatedRecipesList.add(trRecipe);
			}
			ps.close();
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
		return translatedRecipesList;
	}
	
	public List<TranslatedRecipe> findAllTranslatedRecipesByCuisine(TranslatedRecipe translatedRecipe) throws Exception {
		final String allGrSQL = RecipesQueryHelper.constructTranslatedRecipeByTranslatedCuisineQuery(translatedRecipe);
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		localeList = ldi.findLocales();
		transMethodsList = tmdi.findAllTranslatedMethods();
		transCuisinesList = tcdi.findAllTranslatedCuisines();
		translatedRecipesList = new ArrayList<TranslatedRecipe>();

		try {
			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allGrSQL);
			while (rs.next()) {
				Recipe rec = new Recipe();
				TranslatedRecipe trRecipe = new TranslatedRecipe();

				trRecipe.setTrid(rs.getInt(1));
				rec.setRid(rs.getInt(2));
				trRecipe.setRecipe(rec);
				for (int i = 0; i < transCuisinesList.size(); i++)
					if (rs.getInt(3) == transCuisinesList.get(i).getTcid()) {
						trRecipe.setTransCuisine(transCuisinesList.get(i));
					}
				for (int i = 0; i < transMethodsList.size(); i++)
					if (rs.getInt(4) == transMethodsList.get(i).getTmid()) {
						trRecipe.setTransMethod(transMethodsList.get(i));
					}
				for (int i = 0; i < localeList.size(); i++)
					if (rs.getString(5).equals(localeList.get(i).getLoc())) {
						trRecipe.setLocale(localeList.get(i));
					}
				trRecipe.setRname(rs.getString(6));
				translatedRecipesList.add(trRecipe);
			}
			ps.close();
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
		return translatedRecipesList;
	}

	@Override
	public int deleteRecipe(Recipe recipe, TableType tabletype) throws Exception {
		String deleteRecipeQuery = RecipesQueryHelper.constructRecipeDeleteQuery(recipe, tabletype);
		Class.forName(driver);
		Connection con = null;
		Statement stmt = null;
		int i = 0;
		try {
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			i = stmt.executeUpdate(deleteRecipeQuery);
		} catch (SQLException e) {
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

	@Override
	public int deleteTranslatedRecipe(TranslatedRecipe translatedRecipe, TableType tabletype) throws Exception {
		String deleteTranslatedRecipeQuery = RecipesQueryHelper.constructTranslatedRecipeDeleteQuery(translatedRecipe,
				tabletype);
		Class.forName(driver);
		Connection con = null;
		Statement stmt = null;
		int i = 0;
		try {
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			i += stmt.executeUpdate(deleteTranslatedRecipeQuery);
		} catch (SQLException e) {
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

	@Override
	public int updateRecipe(Recipe currentRecipe, Recipe updatedRecipe, TableType tabletype) throws Exception {
		String recipeQuery = RecipesQueryHelper.constructRecipeUpdateQuery(currentRecipe, updatedRecipe, tabletype);
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		Statement stmt;
		int i = 0;
		try {
			stmt = con.createStatement();
			i = stmt.executeUpdate(recipeQuery);
			stmt.close();
		} catch (Exception e) {
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
	public int updateTranslatedRecipe(TranslatedRecipe currentTranslatedRecipe,
			TranslatedRecipe updatedTranslatedRecipe, TableType tabletype) throws Exception {
		String translatedRecipeQuery = RecipesQueryHelper.constructTranslatedRecipeUpdateQuery(currentTranslatedRecipe,
				updatedTranslatedRecipe, tabletype);
		Class.forName(driver);
		Connection con = null;
		Statement stmt = null;
		;
		int i = 0;
		try {
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			i = stmt.executeUpdate(translatedRecipeQuery);
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

}
