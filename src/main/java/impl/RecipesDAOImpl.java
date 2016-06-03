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
		String insertRecipeQuery = constructRecipeInsertQuery(recipe, tableType);
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
			if (stmt != null) try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
			if (con != null) try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		return i;
	}

	@Override
	public int insertTranslatedRecipe(TranslatedRecipe trRecipe, TableType tableType) throws Exception {
		final String grSQL = constructTranslatedRecipeInsertQuery(tableType);
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
		String viewTranslatedRecipeTableQuery = constructRecipeViewTableQuery(tableType);
		recipesList = new ArrayList<Recipe>();
		Class.forName(driver);
		Connection con = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(viewTranslatedRecipeTableQuery);
			while(resultSet.next()){
				Recipe recipe = new Recipe(resultSet.getInt(1));
				recipesList.add(recipe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
			if (stmt != null) try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
			if (con != null) try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		return recipesList;
	}
	
	@Override
	public List<TranslatedRecipe> viewTranslatedRecipesTable(TableType tableType) throws Exception {
		String viewTranslatedRecipeTableQuery = constructTranslatedRecipeViewTableQuery(tableType);
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
			while(resultSet.next()){
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
				TranslatedRecipe translatedRecipe = new TranslatedRecipe(resultSet.getInt(1),recipe,translatedCuisine,translatedMethod,locale,resultSet.getString(6));
				translatedRecipesList.add(translatedRecipe);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
			if (stmt != null) try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
			if (con != null) try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
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
		transMethodsList = tmdi.findEnMethods();
		transCuisinesList = tcdi.findEnCuisines();
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
		final String allGrSQL = constructTranslatedRecipeViewTableQuery(tableType);
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
		String deleteRecipeQuery = constructRecipeDeleteQuery(recipe, tabletype);
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
			if (stmt != null) try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
			if (con != null) try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		return i;
	}

	@Override
	public int deleteTranslatedRecipe(TranslatedRecipe translatedRecipe, TableType tabletype) throws Exception {
		String deleteTranslatedRecipeQuery = constructTranslatedRecipeDeleteQuery(translatedRecipe, tabletype);
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
			if (stmt != null) try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
			if (con != null) try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		return i;
	}

	@Override
	public int updateRecipe(Recipe currentRecipe, Recipe updatedRecipe, TableType tabletype) throws Exception {
		String recipeQuery = constructRecipeUpdateQuery(currentRecipe, updatedRecipe, tabletype);
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
		String translatedRecipeQuery = constructTranslatedRecipeUpdateQuery(currentTranslatedRecipe, updatedTranslatedRecipe, tabletype);
		Class.forName(driver);
		Connection con = null;
		Statement stmt = null;;
		int i = 0;
		try {
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			i = stmt.executeUpdate(translatedRecipeQuery);
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) try { stmt.close(); } catch (Exception e) { e.printStackTrace(); }
			if (con != null) try { con.close(); } catch (SQLException e) { e.printStackTrace(); }
		}
		return i;
	}
	
	public String constructRecipeInsertQuery(Recipe recipe, TableType tableType){
		String query = "";
		switch(tableType){
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
	
	public String constructRecipeDeleteQuery(Recipe recipe, TableType tableType){
		String query = "";
		switch(tableType){
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
	
	public String constructRecipeUpdateQuery(Recipe currentRecipe, Recipe updatedRecipe, TableType tableType) {
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
	
	public String constructRecipeViewTableQuery(TableType tableType) {
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
	
	public String constructTranslatedRecipeDeleteQuery(TranslatedRecipe translatedRecipe, TableType tableType){
		String query = "";
		switch(tableType){
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

	public String constructTranslatedRecipeUpdateQuery(TranslatedRecipe currentTranslatedRecipe,
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

	public String constructTranslatedRecipeViewTableQuery(TableType tableType) {
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
	
	public String constructTranslatedRecipeInsertQuery(TableType tableType) {
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
	
}
