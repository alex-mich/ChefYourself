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

import dao.IngredientsDAO;
import pojos.Ingredient;
import pojos.Locale;
import pojos.TranslatedIngredient;

@Repository
public class IngredientsDAOImpl implements IngredientsDAO {

	private LocaleDAOImpl ldi;
	private String driver, url, username, password;

	private List<Locale> localeList;
	private List<Ingredient> ingredientsList;
	private List<TranslatedIngredient> translatedIngredientsList;

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
	public int insertIngredient(Ingredient in) throws Exception {

		final String ingrSQL = "INSERT INTO app_ingredients" + "(inid,itype) VALUES (?, ?)";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt;
		int i = 0;

		try {

			pstmt = con.prepareStatement(ingrSQL);
			pstmt.setInt(1, in.getInid());
			pstmt.setString(2, in.getItype());
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
	public int insertTranslatedIngredient(TranslatedIngredient tin) throws Exception {

		final String tingrSQL = "INSERT INTO app_ingredients_trans" + "(tinid,inid,locale,itype) VALUES (?, ?, ?, ?)";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt;
		int i = 0;

		try {

			pstmt = con.prepareStatement(tingrSQL);
			pstmt.setInt(1, tin.getTinid());
			pstmt.setInt(2, tin.getIngredient().getInid());
			pstmt.setString(3, tin.getLocale().getLoc());
			pstmt.setString(4, tin.getIname());
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
	public List<Ingredient> findAllIngredients() throws Exception {
		final String allSQL = "SELECT * FROM app_ingredients ORDER BY inid";
		ingredientsList = new ArrayList<Ingredient>();
		Connection con = DriverManager.getConnection(url, username, password);

		try {

			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allSQL);

			while (rs.next()) {
				Ingredient in = new Ingredient();
				in.setInid(rs.getInt(1));
				in.setItype(rs.getString(2));
				ingredientsList.add(in);
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
		return ingredientsList;
	}

	@Override
	public List<TranslatedIngredient> findGrIngredients() throws Exception {

		final String allGrSQL = "SELECT * FROM app_ingredients_trans WHERE locale = 'el' ORDER BY tinid";
		translatedIngredientsList = new ArrayList<TranslatedIngredient>();
		ingredientsList = findAllIngredients();
		localeList = ldi.findLocales();
		Connection con = DriverManager.getConnection(url, username, password);

		try {

			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allGrSQL);

			while (rs.next()) {
				TranslatedIngredient tin = new TranslatedIngredient();

				tin.setTinid(rs.getInt(1));
				for (int i = 0; i < ingredientsList.size(); i++)
					if (rs.getInt(2) == ingredientsList.get(i).getInid()) {
						tin.setIngredient(ingredientsList.get(i));
					}

				for (int i = 0; i < localeList.size(); i++)
					if (rs.getString(3).equals(localeList.get(i).getLoc())) {
						tin.setLocale(localeList.get(i));
					}
				tin.setIname(rs.getString(4));
				translatedIngredientsList.add(tin);
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
		return translatedIngredientsList;
	}

	@Override
	public List<TranslatedIngredient> findEnIngredients() throws Exception {
		final String allEnSQL = "SELECT * FROM app_ingredients_trans WHERE locale = 'en' ORDER BY tinid";
		translatedIngredientsList = new ArrayList<TranslatedIngredient>();
		ingredientsList = findAllIngredients();
		localeList = ldi.findLocales();
		Connection con = DriverManager.getConnection(url, username, password);

		try {

			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allEnSQL);

			while (rs.next()) {
				TranslatedIngredient tin = new TranslatedIngredient();

				tin.setTinid(rs.getInt(1));
				for (int i = 0; i < ingredientsList.size(); i++)
					if (rs.getInt(2) == ingredientsList.get(i).getInid()) {
						tin.setIngredient(ingredientsList.get(i));
					}
				for (int i = 0; i < localeList.size(); i++)
					if (rs.getString(3).equals(localeList.get(i).getLoc())) {
						tin.setLocale(localeList.get(i));
					}
				tin.setIname(rs.getString(4));
				translatedIngredientsList.add(tin);
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
		return translatedIngredientsList;
	}

	@Override
	public int deleteIngredient(Ingredient in) throws Exception {

		String sql = "DELETE FROM app_ingredients WHERE inid = (?)";
		Connection conn = null;
		int i = 0;
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, in.getInid());
			i = pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteTranslatedIngredient(TranslatedIngredient tin) throws Exception {

		String sql = "DELETE FROM app_ingredients_trans WHERE tinid = (?)";
		Connection conn = null;
		int i = 0;
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, tin.getTinid());
			i = pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

}
