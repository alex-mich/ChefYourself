package impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.RecipeDescriptionsDAO;
import pojos.RecipeDescription;
import pojos.TranslatedRecipe;

public class RecipeDescriptionsDAOImpl implements RecipeDescriptionsDAO {

	private RecipesDAOImpl trdi;

	private List<TranslatedRecipe> transRecipesList;
	private List<RecipeDescription> transDescriptionList;

	private String driver, url, username, password;

	public void setTrdi(RecipesDAOImpl trdi) {
		this.trdi = trdi;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int insertGreekRecipeDescription(RecipeDescription rd) throws Exception {
		final String grSQL = "INSERT INTO app_greek_recipes_description (grrdid,tgrrid,grrdesc) VALUES (?,?,?)";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt;
		int i = 0;

		try {

			pstmt = con.prepareStatement(grSQL);
			pstmt.setInt(1, rd.getRdid());
			pstmt.setInt(2, rd.getTrRecipe().getTrid());
			pstmt.setString(3, rd.getDesc());
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
	public int insertGlobalRecipeDescription(RecipeDescription rd) throws Exception {
		final String glSQL = "INSERT INTO app_global_recipes_description (glrdid,tglrid,glrdesc) VALUES (?,?,?)";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt;
		int i = 0;

		try {

			pstmt = con.prepareStatement(glSQL);
			pstmt.setInt(1, rd.getRdid());
			pstmt.setInt(2, rd.getTrRecipe().getTrid());
			pstmt.setString(3, rd.getDesc());
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
	public int insertSpanishRecipeDescription(RecipeDescription rd) throws Exception {
		final String spSQL = "INSERT INTO app_spanish_recipes_description (sprdid,tsprid,sprdesc) VALUES (?,?,?)";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt;
		int i = 0;

		try {

			pstmt = con.prepareStatement(spSQL);
			pstmt.setInt(1, rd.getRdid());
			pstmt.setInt(2, rd.getTrRecipe().getTrid());
			pstmt.setString(3, rd.getDesc());
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
	public List<RecipeDescription> findGreekRecipesDescriptionGr() throws Exception {
		final String allGrSQL = "SELECT * FROM app_greek_recipes_description WHERE tgrrid % 2 = 1";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		transDescriptionList = new ArrayList<RecipeDescription>();
		transRecipesList = trdi.findGreekRecipesGr();
		try {

			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allGrSQL);

			while (rs.next()) {
				RecipeDescription rd = new RecipeDescription();
				rd.setRdid(rs.getInt(1));
				for (int i = 0; i < transRecipesList.size(); i++) {
					if (rs.getInt(2) == transRecipesList.get(i).getTrid()) {
						rd.setTrRecipe(transRecipesList.get(i));
					}
				}
				rd.setDesc(rs.getString(3));
				transDescriptionList.add(rd);
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
		return transDescriptionList;
	}

	@Override
	public List<RecipeDescription> findGreekRecipesDescriptionEn() throws Exception {
		final String allGrSQL = "SELECT * FROM app_greek_recipes_description WHERE tgrrid % 2 = 0";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		transDescriptionList = new ArrayList<RecipeDescription>();
		transRecipesList = trdi.findGreekRecipesEn();
		try {

			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allGrSQL);

			while (rs.next()) {
				RecipeDescription rd = new RecipeDescription();
				rd.setRdid(rs.getInt(1));
				for (int i = 0; i < transRecipesList.size(); i++) {
					if (rs.getInt(2) == transRecipesList.get(i).getTrid()) {
						rd.setTrRecipe(transRecipesList.get(i));
					}
				}
				rd.setDesc(rs.getString(3));
				transDescriptionList.add(rd);
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
		return transDescriptionList;
	}

	@Override
	public List<RecipeDescription> findGlobalRecipesDescriptionGr() throws Exception {
		final String allGrSQL = "SELECT * FROM app_global_recipes_description WHERE tglrid % 2 = 1";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		transDescriptionList = new ArrayList<RecipeDescription>();
		transRecipesList = trdi.findGlobalRecipesGr();
		try {

			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allGrSQL);

			while (rs.next()) {
				RecipeDescription rd = new RecipeDescription();
				rd.setRdid(rs.getInt(1));
				for (int i = 0; i < transRecipesList.size(); i++) {
					if (rs.getInt(2) == transRecipesList.get(i).getTrid()) {
						rd.setTrRecipe(transRecipesList.get(i));
					}
				}
				rd.setDesc(rs.getString(3));
				transDescriptionList.add(rd);
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
		return transDescriptionList;
	}

	@Override
	public List<RecipeDescription> findGlobalRecipesDescriptionEn() throws Exception {
		final String allGrSQL = "SELECT * FROM app_global_recipes_description WHERE tglrid % 2 = 0";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		transDescriptionList = new ArrayList<RecipeDescription>();
		transRecipesList = trdi.findGlobalRecipesEn();
		try {

			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allGrSQL);

			while (rs.next()) {
				RecipeDescription rd = new RecipeDescription();
				rd.setRdid(rs.getInt(1));
				for (int i = 0; i < transRecipesList.size(); i++) {
					if (rs.getInt(2) == transRecipesList.get(i).getTrid()) {
						rd.setTrRecipe(transRecipesList.get(i));
					}
				}
				rd.setDesc(rs.getString(3));
				transDescriptionList.add(rd);
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
		return transDescriptionList;
	}

	@Override
	public List<RecipeDescription> findSpanishRecipesDescriptionGr() throws Exception {
		final String allGrSQL = "SELECT * FROM app_spanish_recipes_description WHERE tsprid % 2 = 1";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		transDescriptionList = new ArrayList<RecipeDescription>();
		transRecipesList = trdi.findSpanishRecipesGr();
		try {

			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allGrSQL);

			while (rs.next()) {
				RecipeDescription rd = new RecipeDescription();
				rd.setRdid(rs.getInt(1));
				for (int i = 0; i < transRecipesList.size(); i++) {
					if (rs.getInt(2) == transRecipesList.get(i).getTrid()) {
						rd.setTrRecipe(transRecipesList.get(i));
					}
				}
				rd.setDesc(rs.getString(3));
				transDescriptionList.add(rd);
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
		return transDescriptionList;
	}

	@Override
	public List<RecipeDescription> findSpanishRecipesDescriptionEn() throws Exception {
		final String allGrSQL = "SELECT * FROM app_greek_recipes_description WHERE tsprid % 2 = 0";
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, username, password);
		transDescriptionList = new ArrayList<RecipeDescription>();
		transRecipesList = trdi.findSpanishRecipesEn();
		try {

			Statement ps = con.createStatement();
			ResultSet rs = ps.executeQuery(allGrSQL);

			while (rs.next()) {
				RecipeDescription rd = new RecipeDescription();
				rd.setRdid(rs.getInt(1));
				for (int i = 0; i < transRecipesList.size(); i++) {
					if (rs.getInt(2) == transRecipesList.get(i).getTrid()) {
						rd.setTrRecipe(transRecipesList.get(i));
					}
				}
				rd.setDesc(rs.getString(3));
				transDescriptionList.add(rd);
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
		return transDescriptionList;
	}

	@Override
	public int deleteGreekRecipeDescription(RecipeDescription rd) throws Exception {

		String sql = "DELETE FROM app_greek_recipes_description WHERE grrdid = (?)";
		Connection conn = null;
		int i = 0;
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, rd.getRdid());
			i = pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteGlobalRecipeDescription(RecipeDescription rd) throws Exception {

		String sql = "DELETE FROM app_global_recipes_description WHERE glrdid = (?)";
		Connection conn = null;
		int i = 0;
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, rd.getRdid());
			i = pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteSpanishRecipeDescription(RecipeDescription rd) throws Exception {

		String sql = "DELETE FROM app_spanish_recipes_description WHERE sprdid = (?)";
		Connection conn = null;
		int i = 0;
		try {
			conn = DriverManager.getConnection(url, username, password);
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, rd.getRdid());
			i = pstm.executeUpdate();
			pstm.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

}
