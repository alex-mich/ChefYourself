package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.MethodsDAO;
import pojos.Locale;
import pojos.Method;
import pojos.TranslatedMethod;

public class MethodsDAOImpl implements MethodsDAO {

	private LocaleDAOImpl ldi;
	private String driver, url, username, password;
	
	private List<Locale> localesList;
	private List<Method> methodsList;
	private List<TranslatedMethod> translatedMethodsList;
	
	public void setLdi(LocaleDAOImpl ldi) {
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
	public int insertMethod(Method method) throws Exception {
		final String methodSQL = "INSERT INTO app_methods" + "(mid) VALUES (?)";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt;
		int i = 0;

		try {

			pstmt = con.prepareStatement(methodSQL);
			pstmt.setInt(1, method.getMid());
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
	public int insertTranslatedMethod(TranslatedMethod tMethod) throws Exception {
		final String tMethodSQL = "INSERT INTO app_methods_trans (tmid,mid,locale,mname) VALUES (?, ?, ?, ?)";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt;
		int i = 0;
		try {

			pstmt = con.prepareStatement(tMethodSQL);
			pstmt.setInt(1, tMethod.getTmid());
			pstmt.setInt(2, tMethod.getMethod().getMid());
			pstmt.setString(3, tMethod.getLocale().getLoc());
			pstmt.setString(4, tMethod.getMname());
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
	public List<Method> findAllMethods() throws Exception {
		final String allSQL = "SELECT * FROM app_methods ORDER BY mid";
		methodsList = new ArrayList<Method>();
		Connection con = DriverManager.getConnection(url, username, password);

		try {

			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allSQL);

			while (rs.next()) {
				Method m = new Method();
				m.setMid(rs.getInt(1));
				methodsList.add(m);
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
		return methodsList;
	}
	
	public List<TranslatedMethod> findGrMethods() throws Exception {
		final String allGrSQL = "SELECT * FROM app_methods_trans WHERE locale = 'el' ORDER BY tmid";
		methodsList = findAllMethods();
		localesList = ldi.findLocales();
		translatedMethodsList = new ArrayList<TranslatedMethod>();
		Connection con = DriverManager.getConnection(url, username, password);

		try {

			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allGrSQL);

			while (rs.next()) {
				TranslatedMethod tm = new TranslatedMethod();
				tm.setTmid(rs.getInt(1));
				for (int i = 0; i < methodsList.size(); i++)
					if (rs.getInt(2) == methodsList.get(i).getMid()) {
						tm.setMethod(methodsList.get(i));
					}
				
				for (int i = 0; i < localesList.size(); i++)
					if (rs.getString(3).equals(localesList.get(i).getLoc())) {
						tm.setLocale(localesList.get(i));
					}
				tm.setMname(rs.getString(4));
				translatedMethodsList.add(tm);
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
		return translatedMethodsList;
	}
	
	@Override
	public List<TranslatedMethod> findEnMethods() throws Exception {
		final String allEnSQL = "SELECT * FROM app_methods_trans WHERE locale = 'en' ORDER BY tmid";
		methodsList = findAllMethods();
		localesList = ldi.findLocales();
		translatedMethodsList = new ArrayList<TranslatedMethod>();
		Connection con = DriverManager.getConnection(url, username, password);

		try {

			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allEnSQL);

			while (rs.next()) {
				TranslatedMethod tm = new TranslatedMethod();
				tm.setTmid(rs.getInt(1));
				for (int i = 0; i < methodsList.size(); i++)
					if (rs.getInt(2) == methodsList.get(i).getMid()) {
						tm.setMethod(methodsList.get(i));
					}
				
				for (int i = 0; i < localesList.size(); i++)
					if (rs.getString(3).equals(localesList.get(i).getLoc())) {
						tm.setLocale(localesList.get(i));
					}
				tm.setMname(rs.getString(4));
				tm.setMname(rs.getString(4));
				translatedMethodsList.add(tm);
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
		return translatedMethodsList;
	}

}