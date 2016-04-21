package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.LocaleDAO;
import pojos.Locale;

public class LocaleDAOImpl implements LocaleDAO{

	private String driver, url, username, password;

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
	public int insertLocale(Locale locale) throws Exception {
		final String locSQL = "INSERT INTO app_lang (locale,language,lod) VALUES (?,?,?)";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt;
		int i = 0;

		try {

			pstmt = con.prepareStatement(locSQL);
			pstmt.setString(1, locale.getLoc());
			pstmt.setString(2, locale.getLanguage());
			pstmt.setInt(3, locale.getLid());
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
	public List<Locale> findLocales() throws Exception {
		final String locSQL = "SELECT * FROM app_lang ORDER BY lid";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		List<Locale> localeList = new ArrayList<Locale>();
		Statement stmt;
		ResultSet rs;
		
		try {
			
		stmt = con.createStatement();
		rs = stmt.executeQuery(locSQL);

		while(rs.next()){
			Locale locale = new Locale();
			locale.setLoc(rs.getString(1));
			locale.setLanguage(rs.getString(2));
			locale.setLid(rs.getInt(3));
			localeList.add(locale);
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
		return localeList;
	}
	
}
