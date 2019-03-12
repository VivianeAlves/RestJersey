package infra.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;

import com.sun.istack.logging.Logger;

public class ConexaoPostgresJDBC implements ConexaoJDBC {
	private Connection connection = null;

	public ConexaoPostgresJDBC() throws ClassNotFoundException, SQLException {
		Class.forName("org.postgresql.Driver");
		Properties properties = new Properties();
		properties.put("user", "postgres");
		properties.put("password", "1234");
		this.connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/help-me?ApplicationName=HelpMe",
				properties);
	}

	@Override
	public Connection getConnection() {
		try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return this.connection;
	}

	@Override
	public void close() {
		if (this.connection != null) {
			try {
				this.connection.close();
			} catch (SQLException e) {
				Logger.getLogger(ConexaoPostgresJDBC.class.getName(), null).log(Level.SEVERE, null, e);
			}
		}
	}

	@Override
	public void commit() throws SQLException {
		this.connection.commit();
		this.close();

	}

	@Override
	public void rollback() {
		if (this.connection != null) {
			try {
				this.connection.rollback();
			} catch (Exception e) {
				Logger.getLogger(ConexaoPostgresJDBC.class.getName(), null).log(Level.SEVERE, null, e);
			} finally {
				this.close();
			}
		}

	}

}
