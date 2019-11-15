package poo.dao.dao.h2.dao;

import org.h2.jdbcx.JdbcDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class H2Singleton {
	private static Connection connection;

	public static final String URL = "jdbc:h2:mem:test";
	public static final String USER = "SA";
	public static final String PASS = "";
	
	public static Connection getInstance() throws SQLException {
		if (connection == null) {
			// DB CONNECTION
			JdbcDataSource source = new JdbcDataSource();
			source.setURL(URL);
			source.setUser(USER);
			source.setPassword(PASS);
			connection = source.getConnection();
		}
		return connection;
	}
	private static void createDB() {
		try (Statement statement = getInstance().createStatement()) {
			ResultSet set = getInstance().getMetaData().getTables("null", "null", "SOCIETIES", new String[0]);
			createJunctionTable();
			createLanguagesTable();
			createEmployeesTable();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void createJunctionTable() {
		String sql = "";
	}
	
	private static void createLanguagesTable() throws SQLException{
		String sql = "create table if not exists LANGUAGES (" +
				"LANG_ID identity primary key," +
				"LANG_NAME varchar(50))";
		Statement statement = getInstance().createStatement();
		statement.execute(sql);
	}
	
	private static void createEmployeesTable() throws SQLException{
		String sql = "";
		Statement statement = getInstance().createStatement();
		statement.execute(sql);
	}
}
