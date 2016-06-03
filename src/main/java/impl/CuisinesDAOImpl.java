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

import dao.CuisinesDAO;
import pojos.Cuisine;
import pojos.Language;
import pojos.TranslatedCuisine;

@Repository
public class CuisinesDAOImpl implements CuisinesDAO {

	private LanguagesDAOImpl ldi;
	private String driver, url, username, password;

	private List<TranslatedCuisine> translatedCuisinesList;
	private List<Cuisine> cuisinesList;
	private List<Language> localesList;

	public void setLdi(LanguagesDAOImpl ldi) {
		this.ldi = ldi;
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
	public int insertCuisine(Cuisine cui) throws Exception {
		final String cuiSQL = "INSERT INTO app_cuisines (cid) VALUES (?)";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt;
		int i = 0;
		try {
			pstmt = con.prepareStatement(cuiSQL);
			pstmt.setInt(1, cui.getCid());
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
	public int insertTranslatedCuisine(TranslatedCuisine tcui) throws Exception {
		final String tcuiSQL = "INSERT INTO app_cuisines_trans (tcid,cid,locale,cname) VALUES (?, ?, ?, ?)";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt;
		int i = 0;
		try {
			pstmt = con.prepareStatement(tcuiSQL);
			pstmt.setInt(1, tcui.getTcid());
			pstmt.setInt(2, tcui.getCuisine().getCid());
			pstmt.setString(3, tcui.getLocale().getLoc());
			pstmt.setString(4, tcui.getCname());
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
	public List<Cuisine> findAllCuisines() throws Exception {
		String viewCuisinesTableQuery = "SELECT * FROM app_cuisines ORDER BY cid";
		List<Cuisine> cuisinesList = new ArrayList<Cuisine>();
		Class.forName(driver);
		Connection con = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(viewCuisinesTableQuery);
			while (resultSet.next()) {
				Cuisine cuisine = new Cuisine(resultSet.getInt(1));
				cuisinesList.add(cuisine);
			}
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
		return cuisinesList;
	}

	@Override
	public List<TranslatedCuisine> findAllTranslatedCuisines() throws Exception {

		final String allGrSQL = "SELECT * FROM app_cuisines_trans ORDER BY tcid";
		cuisinesList = findAllCuisines();
		localesList = ldi.findLocales();
		translatedCuisinesList = new ArrayList<TranslatedCuisine>();
		Connection con = null;
		ResultSet resultSet = null;
		Statement stmt = null;
		try {
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(allGrSQL);

			while (resultSet.next()) {
				TranslatedCuisine translatedCuisine = new TranslatedCuisine();
				translatedCuisine.setTcid(resultSet.getInt(1));
				for (int i = 0; i < cuisinesList.size(); i++)
					if (resultSet.getInt(2) == cuisinesList.get(i).getCid()) {
						translatedCuisine.setCuisine(cuisinesList.get(i));
					}

				for (int i = 0; i < localesList.size(); i++)
					if (resultSet.getString(3).equals(localesList.get(i).getLoc())) {
						translatedCuisine.setLocale(localesList.get(i));
					}

				translatedCuisine.setCname(resultSet.getString(4));
				translatedCuisinesList.add(translatedCuisine);
			}
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
		return translatedCuisinesList;
	}

	public List<TranslatedCuisine> findGrCuisines() throws Exception {

		final String allGrSQL = "SELECT * FROM app_cuisines_trans WHERE locale = 'el' ORDER BY tcid";
		cuisinesList = findAllCuisines();
		localesList = ldi.findLocales();
		translatedCuisinesList = new ArrayList<TranslatedCuisine>();
		Connection con = DriverManager.getConnection(url, username, password);

		try {

			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allGrSQL);

			while (rs.next()) {
				TranslatedCuisine tc = new TranslatedCuisine();
				tc.setTcid(rs.getInt(1));
				for (int i = 0; i < cuisinesList.size(); i++)
					if (rs.getInt(2) == cuisinesList.get(i).getCid()) {
						tc.setCuisine(cuisinesList.get(i));
					}

				for (int i = 0; i < localesList.size(); i++)
					if (rs.getString(3).equals(localesList.get(i).getLoc())) {
						tc.setLocale(localesList.get(i));
					}

				tc.setCname(rs.getString(4));
				translatedCuisinesList.add(tc);
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
		return translatedCuisinesList;
	}

	@Override
	public List<TranslatedCuisine> findEnCuisines() throws Exception {
		final String allEnSQL = "SELECT * FROM app_cuisines_trans WHERE locale = 'en' ORDER BY tcid";
		cuisinesList = findAllCuisines();
		localesList = ldi.findLocales();
		translatedCuisinesList = new ArrayList<TranslatedCuisine>();
		Connection con = DriverManager.getConnection(url, username, password);

		try {

			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allEnSQL);

			while (rs.next()) {
				Cuisine c = new Cuisine();
				Language loc = new Language();
				TranslatedCuisine tc = new TranslatedCuisine();

				tc.setTcid(rs.getInt(1));
				for (int i = 0; i < cuisinesList.size(); i++)
					if (rs.getInt(2) == cuisinesList.get(i).getCid()) {
						c.setCid(cuisinesList.get(i).getCid());
					}
				tc.setCuisine(c);
				for (int i = 0; i < localesList.size(); i++)
					if (rs.getString(3).equals(localesList.get(i).getLoc())) {
						loc.setLoc(localesList.get(i).getLoc());
						loc.setLanguage(localesList.get(i).getLanguage());
						loc.setLid(localesList.get(i).getLid());
					}
				tc.setLocale(loc);
				tc.setCname(rs.getString(4));
				translatedCuisinesList.add(tc);
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
		return translatedCuisinesList;
	}

	@Override
	public int deleteCuisine(Cuisine cuisine) throws Exception {
		String cuisineSQL = "DELETE FROM app_cuisines WHERE cid = (?)";
		String translatedSQL = "DELETE FROM app_cuisines_trans WHERE cid = (?)";
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		PreparedStatement pstm;
		int i = 0;
		try {
			pstm = conn.prepareStatement(translatedSQL);
			pstm.setInt(1, cuisine.getCid());
			i = pstm.executeUpdate();
			pstm = conn.prepareStatement(cuisineSQL);
			pstm.setInt(1, cuisine.getCid());
			i += pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteTranslatedCuisine(TranslatedCuisine transCuisine) throws Exception {
		String sql = "DELETE FROM app_cuisines_trans WHERE tcid = (?)";
		Connection conn = DriverManager.getConnection(url, username, password);
		PreparedStatement pstm;
		int i = 0;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, transCuisine.getTcid());
			i = pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updateCuisine(Cuisine currentCuisine, Cuisine updatedCuisine) throws Exception {
		String cuisineUpdate = "UPDATE app_cuisines SET cid = (?) WHERE cid = (?)";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt;
		int i = 0;
		try {
			pstmt = con.prepareStatement(cuisineUpdate);
			pstmt.setInt(1, updatedCuisine.getCid());
			pstmt.setInt(2, currentCuisine.getCid());
			i = pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updateTranslatedCuisine(TranslatedCuisine currentTranslatedCuisine,
			TranslatedCuisine updatedTranslatedCuisine) throws Exception {
		String translatedCuisineUpdate = constructQuery(currentTranslatedCuisine, updatedTranslatedCuisine);
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		Statement stmt;
		int i = 0;
		try {
			stmt = con.createStatement();
			i = stmt.executeUpdate(translatedCuisineUpdate);
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public String constructQuery(TranslatedCuisine currentTranslatedCuisine,
			TranslatedCuisine updatedTranslatedCuisine) {
		String query = "UPDATE app_cuisines_trans ";

		String set = "SET ";
		if (updatedTranslatedCuisine.getTcid() != 0)
			set += "tcid=" + updatedTranslatedCuisine.getTcid() + ", ";
		if (updatedTranslatedCuisine.getCuisine().getCid() != 0)
			set += "cid=" + updatedTranslatedCuisine.getCuisine().getCid() + ", ";
		if (!updatedTranslatedCuisine.getLocale().getLoc().equals(""))
			set += "locale='" + updatedTranslatedCuisine.getLocale().getLoc() + "', ";
		if (!updatedTranslatedCuisine.getCname().equals(""))
			set += "cname='" + updatedTranslatedCuisine.getCname() + "', ";
		set = (String) set.substring(0, set.length() - 2);

		String where = "WHERE ";
		if (currentTranslatedCuisine.getTcid() != 0)
			where += "tcid=" + currentTranslatedCuisine.getTcid() + " AND ";
		if (currentTranslatedCuisine.getCuisine().getCid() != 0)
			where += "cid=" + currentTranslatedCuisine.getCuisine().getCid() + " AND ";
		if (!currentTranslatedCuisine.getLocale().getLoc().equals(""))
			where += "locale='" + currentTranslatedCuisine.getLocale().getLoc() + "' AND ";
		if (!currentTranslatedCuisine.getCname().equals(""))
			where += "cname='" + currentTranslatedCuisine.getCname() + "' AND ";
		where = (String) where.substring(0, where.length() - 5);

		set += where;
		query += set + ";";

		return query;
	}

	@Override
	public List<Cuisine> viewCuisinesTable() throws Exception {
		return findAllCuisines();
	}

	@Override
	public List<TranslatedCuisine> viewTranslatedCuisinesTable() throws Exception {
		return findAllTranslatedCuisines();
	}

}
