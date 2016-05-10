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
		final String allGrSQL = "SELECT * FROM app_cuisines ORDER BY cid";
		cuisinesList = new ArrayList<Cuisine>();
		Connection con = DriverManager.getConnection(url, username, password);
		Statement stmt;
		ResultSet rs;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(allGrSQL);
			while (rs.next()) {
				Cuisine c = new Cuisine();
				c.setCid(rs.getInt(1));
				cuisinesList.add(c);
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
		return cuisinesList;
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

}
