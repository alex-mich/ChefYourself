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

import dao.LanguagesDAO;
import pojos.Language;

@Repository
public class LanguagesDAOImpl implements LanguagesDAO {

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
	public int insertLocale(Language language) throws Exception {
		final String locSQL = "INSERT INTO app_lang (locale,language,lid) VALUES (?,?,?)";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt;
		int i = 0;

		try {

			pstmt = con.prepareStatement(locSQL);
			pstmt.setString(1, language.getLoc());
			pstmt.setString(2, language.getLanguage());
			pstmt.setInt(3, language.getLid());
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
	public int deleteLocale(Language language) throws Exception {
		String languageSQL = "DELETE FROM app_lang WHERE lid = (?)";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstm;
		int i = 0;
		try {
			pstm = con.prepareStatement(languageSQL);
			pstm.setInt(1, language.getLid());
			i = pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	
	@Override
	public int updateLocale(Language currentLanguage, Language updatedLanguage) throws Exception {
		String languageUpdate = constructQuery(currentLanguage,updatedLanguage);
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		Statement stmt;
		int i = 0;
		try {
			stmt = con.createStatement();
			i = stmt.executeUpdate(languageUpdate);
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}

	@Override
	public List<Language> findLocales() throws Exception {
		final String locSQL = "SELECT * FROM app_lang ORDER BY lid";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		List<Language> localeList = new ArrayList<Language>();
		Statement stmt;
		ResultSet rs;
		try {

			stmt = con.createStatement();
			rs = stmt.executeQuery(locSQL);

			while (rs.next()) {
				Language locale = new Language();
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

	public String constructQuery(Language currentLanguage,Language updatedLanguage){
		String query = "UPDATE app_lang ";
		
		String set= "SET ";
		if(updatedLanguage.getLid() != 0)
			set += "lid=" + updatedLanguage.getLid() +", ";
		if(!updatedLanguage.getLanguage().equals(""))
			set += "language='" + updatedLanguage.getLanguage() +"', ";
		if(!updatedLanguage.getLoc().equals(""))
			set += "locale='" + updatedLanguage.getLoc() +"', ";
			set = (String) set.substring(0, set.length()-2);
		
		String where = " WHERE ";
		if(currentLanguage.getLid() != 0)
			where += "lid=" + currentLanguage.getLid() +" AND ";
		if(!currentLanguage.getLanguage().equals(""))
			where += "language='" + currentLanguage.getLanguage() +"' AND ";
		if(!currentLanguage.getLoc().equals(""))
			where += "locale='" + currentLanguage.getLoc() +"' AND ";
			where = (String) where.substring(0, where.length()-5);
		
		set += where;
		query += set + ";";
			
		return query;
	}

	@Override
	public List<Language> viewLanguagesTable() throws Exception {
		
		return findLocales();
	}

}

	