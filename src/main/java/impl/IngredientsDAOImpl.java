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

import Helpers.IngredientsQueryHelper;
import dao.IngredientsDAO;
import pojos.Ingredient;
import pojos.Language;
import pojos.TranslatedIngredient;

@Repository
public class IngredientsDAOImpl implements IngredientsDAO {

	private LanguagesDAOImpl ldi;
	private String driver, url, username, password;

	private List<Language> localeList;
	private List<Ingredient> ingredientsList;
	private List<TranslatedIngredient> translatedIngredientsList;

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
	public int insertIngredient(Ingredient in) throws Exception {

		final String ingrSQL = "INSERT INTO app_ingredients (inid,itype) VALUES (?, ?)";
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

		final String tingrSQL = "INSERT INTO app_ingredients_trans" + "(tinid,inid,locale,iname) VALUES (?, ?, ?, ?)";
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
		String viewIngredientsTableQuery = "SELECT * FROM app_ingredients ORDER BY inid";
		List<Ingredient> ingredientsList = new ArrayList<Ingredient>();
		Class.forName(driver);
		Connection con = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		try {
			con = DriverManager.getConnection(url, username, password);
			stmt = con.createStatement();
			resultSet = stmt.executeQuery(viewIngredientsTableQuery);
			while (resultSet.next()) {
				Ingredient ingredient = new Ingredient(resultSet.getInt(1), resultSet.getString(2));
				ingredientsList.add(ingredient);
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
	public int deleteIngredient(Ingredient ingredient) throws Exception {
		String ingredientSQL = "DELETE FROM app_ingredients WHERE inid = (?)";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstm;
		int i = 0;
		try {
			pstm = con.prepareStatement(ingredientSQL);
			pstm.setInt(1, ingredient.getInid());
			i = pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteTranslatedIngredient(TranslatedIngredient translatedIngredient) throws Exception {
		String sql = "DELETE FROM app_ingredients_trans WHERE tinid = (?)";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstm;
		int i = 0;
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, translatedIngredient.getTinid());
			i = pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updateIngredient(Ingredient currentIngredient, Ingredient updatedIngredient) throws Exception {
		String ingredientUpdate = IngredientsQueryHelper.constructIngredientUpdateQuery(currentIngredient,
				updatedIngredient);
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		Statement stmt;
		int i = 0;
		try {
			stmt = con.createStatement();
			i = stmt.executeUpdate(ingredientUpdate);
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int updateTranslatedIngredient(TranslatedIngredient currentTranslatedIngredient,
			TranslatedIngredient updatedTranslatedIngredient) throws Exception {
		String translatedIngredientUpdate = IngredientsQueryHelper
				.constructTranslatedIngredientUpdateQuery(currentTranslatedIngredient, updatedTranslatedIngredient);
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		Statement stmt;
		int i = 0;
		try {
			stmt = con.createStatement();
			i = stmt.executeUpdate(translatedIngredientUpdate);
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Ingredient> viewIngredientsTable() throws Exception {
		return findAllIngredients();
	}

	@Override
	public List<TranslatedIngredient> viewTranslatedIngredientsTable() throws Exception {
		return findAllTranslatedIngredients();
	}

	@Override
	public List<TranslatedIngredient> findAllTranslatedIngredients() throws Exception {
		final String allGrSQL = "SELECT * FROM app_ingredients_trans ORDER BY tinid";
		Class.forName(driver);
		ingredientsList = findAllIngredients();
		localeList = ldi.findLocales();
		translatedIngredientsList = new ArrayList<TranslatedIngredient>();
		Connection con = DriverManager.getConnection(url, username, password);

		try {

			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allGrSQL);

			while (rs.next()) {
				TranslatedIngredient ti = new TranslatedIngredient();
				ti.setTinid(rs.getInt(1));
				for (int i = 0; i < ingredientsList.size(); i++)
					if (rs.getInt(2) == ingredientsList.get(i).getInid()) {
						ti.setIngredient(ingredientsList.get(i));
					}

				for (int i = 0; i < localeList.size(); i++)
					if (rs.getString(3).equals(localeList.get(i).getLoc())) {
						ti.setLocale(localeList.get(i));
					}
				ti.setIname(rs.getString(4));
				translatedIngredientsList.add(ti);
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

	public List<TranslatedIngredient> findTranslatedIngredientsByLanguage(String language) throws Exception {
		final String allGrSQL = "SELECT * FROM app_ingredients_trans WHERE locale = (?) ORDER BY tinid";
		Class.forName(driver);
		//ingredientsList = findAllIngredients();
		localeList = ldi.findLocales();
		translatedIngredientsList = new ArrayList<TranslatedIngredient>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;

		try {
			con = DriverManager.getConnection(url, username, password);
			pstmt = con.prepareStatement(allGrSQL);
			pstmt.setString(1, language);
			resultSet = pstmt.executeQuery();

			while (resultSet.next()) {
				TranslatedIngredient ôranslatedIngredient = new TranslatedIngredient();
				ôranslatedIngredient.setTinid(resultSet.getInt(1));
				/*for (int i = 0; i < ingredientsList.size(); i++)
					if (resultSet.getInt(2) == ingredientsList.get(i).getInid()) {
						ôranslatedIngredient.setIngredient(ingredientsList.get(i));
					}
*/
				for (int i = 0; i < localeList.size(); i++)
					if (resultSet.getString(3).equals(localeList.get(i).getLoc())) {
						ôranslatedIngredient.setLocale(localeList.get(i));
					}
				ôranslatedIngredient.setIname(resultSet.getString(4));
				translatedIngredientsList.add(ôranslatedIngredient);
			}
			resultSet.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
}
