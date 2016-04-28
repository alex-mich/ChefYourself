package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

import org.springframework.stereotype.Repository;

import dao.RecipesDAO;
import pojos.Locale;
import pojos.Recipe;
import pojos.TranslatedCuisine;
import pojos.TranslatedMethod;
import pojos.TranslatedRecipe;

@Repository
public class RecipesDAOImpl implements RecipesDAO {

	private LocaleDAOImpl ldi;
	private CuisinesDAOImpl tcdi;
	private MethodsDAOImpl tmdi;

	private String driver, url, username, password;

	private List<Locale> localeList;
	private List<TranslatedMethod> transMethodsList;
	private List<TranslatedCuisine> transCuisinesList;
	private List<TranslatedRecipe> recipesList;

	public void setLdi(LocaleDAOImpl ldi) {
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
	public int insertGreekRecipe(Recipe recipe) throws Exception {
		final String grrSQL = "INSERT INTO app_greek_recipes (grrid) VALUES (?)";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt;
		int i = 0;

		try {

			pstmt = con.prepareStatement(grrSQL);
			pstmt.setInt(1, recipe.getRid());
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
	public int insertGlobalRecipe(Recipe recipe) throws Exception {
		final String glrSQL = "INSERT INTO app_global_recipes (glrid) VALUES (?)";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt;
		int i = 0;

		try {

			pstmt = con.prepareStatement(glrSQL);
			pstmt.setInt(1, recipe.getRid());
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
	public int insertSpanishRecipe(Recipe recipe) throws Exception {
		final String sprSQL = "INSERT INTO app_spanish_recipes (sprid) VALUES (?)";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt;
		int i = 0;

		try {

			pstmt = con.prepareStatement(sprSQL);
			pstmt.setInt(1, recipe.getRid());
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
	public int insertGreekTranslatedRecipe(TranslatedRecipe trRecipe) throws Exception {
		final String grSQL = "INSERT INTO app_greek_recipes_trans (tgrrid,grrid,tcid,tmid,locale,grrname) VALUES (?,?,?,?,?,?)";
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
	public int insertGlobalTranslatedRecipe(TranslatedRecipe trRecipe) throws Exception {
		final String glSQL = "INSERT INTO app_global_recipes_trans (tglrid,glrid,tcid,tmid,locale,glrname) VALUES (?,?,?,?,?,?)";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt;
		int i = 0;

		try {

			pstmt = con.prepareStatement(glSQL);
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
	public int insertSpanishTranslatedRecipe(TranslatedRecipe trRecipe) throws Exception {
		final String spSQL = "INSERT INTO app_spanish_recipes_trans (tsprid,sprid,tcid,tmid,locale,sprname) VALUES (?,?,?,?,?,?)";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt;
		int i = 0;

		try {

			pstmt = con.prepareStatement(spSQL);
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
	public List<TranslatedRecipe> findGreekRecipesGr() throws Exception {
		final String allGrSQL = "SELECT * FROM app_greek_recipes_trans WHERE locale = 'el' ORDER BY tgrrid";
		localeList = ldi.findLocales();
		transMethodsList = tmdi.findGrMethods();
		transCuisinesList = tcdi.findGrCuisines();
		recipesList = new ArrayList<TranslatedRecipe>();
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
				recipesList.add(trRecipe);
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
		return recipesList;
	}

	@Override
	public List<TranslatedRecipe> findGreekRecipesEn() throws Exception {
		final String allGrSQL = "SELECT * FROM app_greek_recipes_trans WHERE locale = 'en' ORDER BY tgrrid";
		localeList = ldi.findLocales();
		transMethodsList = tmdi.findEnMethods();
		transCuisinesList = tcdi.findEnCuisines();
		recipesList = new ArrayList<TranslatedRecipe>();

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
				recipesList.add(trRecipe);
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
		return recipesList;
	}

	@Override
	public List<TranslatedRecipe> findSpanishRecipesGr() throws Exception {

		final String allGrSQL = "SELECT * FROM app_spanish_recipes_trans WHERE locale = 'el'";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		localeList = ldi.findLocales();
		transMethodsList = tmdi.findGrMethods();
		transCuisinesList = tcdi.findGrCuisines();
		recipesList = new ArrayList<TranslatedRecipe>();

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
				recipesList.add(trRecipe);
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
		return recipesList;
	}

	@Override
	public List<TranslatedRecipe> findSpanishRecipesEn() throws Exception {
		final String allEnSQL = "SELECT * FROM app_spanish_recipes_trans WHERE locale = 'en'";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		transMethodsList = tmdi.findEnMethods();
		transCuisinesList = tcdi.findEnCuisines();
		localeList = ldi.findLocales();
		recipesList = new ArrayList<TranslatedRecipe>();

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
				recipesList.add(trRecipe);
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
		return recipesList;
	}

	@Override
	public List<TranslatedRecipe> findGlobalRecipesGr() throws Exception {
		final String allGrSQL = "SELECT * FROM app_global_recipes_trans WHERE locale = 'el'";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);

		localeList = ldi.findLocales();
		transMethodsList = tmdi.findGrMethods();
		transCuisinesList = tcdi.findGrCuisines();
		recipesList = new ArrayList<TranslatedRecipe>();

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
				recipesList.add(trRecipe);
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
		return recipesList;
	}

	@Override
	public List<TranslatedRecipe> findGlobalRecipesEn() throws Exception {
		final String allEnSQL = "SELECT * FROM app_global_recipes_trans WHERE locale = 'en'";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		localeList = ldi.findLocales();
		transMethodsList = tmdi.findEnMethods();
		transCuisinesList = tcdi.findEnCuisines();
		recipesList = new ArrayList<TranslatedRecipe>();

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
				recipesList.add(trRecipe);
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
		return recipesList;
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
		recipesList = new ArrayList<TranslatedRecipe>();

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
				recipesList.add(trRecipe);
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
		return recipesList;
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
		recipesList = new ArrayList<TranslatedRecipe>();

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
				recipesList.add(trRecipe);
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
		return recipesList;
	}

	@Override
	public int deleteGreekRecipe(Recipe recipe) throws Exception {

		String sql = "DELETE FROM app_greek_recipes WHERE grrid = (?)";
		Class.forName(driver);
		Connection conn = null;
		int i = 0;
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, recipe.getRid());
			i = pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteGlobalRecipe(Recipe recipe) throws Exception {

		String sql = "DELETE FROM app_global_recipes WHERE glrid = (?)";
		Class.forName(driver);
		Connection conn = null;
		int i = 0;
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, recipe.getRid());
			i = pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteSpanishRecipe(Recipe recipe) throws Exception {

		String sql = "DELETE FROM app_spanish_recipes WHERE sprid = (?)";
		Class.forName(driver);
		Connection conn = null;
		int i = 0;
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, recipe.getRid());
			i = pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteGreekTranslatedRecipe(TranslatedRecipe trRecipe) throws Exception {

		String sql = "DELETE FROM app_greek_recipes_trans WHERE tgrrid = (?)";
		Class.forName(driver);
		Connection conn = null;
		int i = 0;
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, trRecipe.getTrid());
			i = pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteGlobalTranslatedRecipe(TranslatedRecipe trRecipe) throws Exception {

		String sql = "DELETE FROM app_global_recipes_trans WHERE tglrid = (?)";
		Class.forName(driver);
		Connection conn = null;
		int i = 0;
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, trRecipe.getTrid());
			i = pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteSpanishTranslatedRecipe(TranslatedRecipe trRecipe) throws Exception {

		String sql = "DELETE FROM app_spanish_recipes_trans WHERE tsprid = (?)";
		Class.forName(driver);
		Connection conn = null;
		int i = 0;
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, trRecipe.getTrid());
			i = pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

}
