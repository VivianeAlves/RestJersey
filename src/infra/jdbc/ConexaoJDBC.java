package infra.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConexaoJDBC {
	/*
	pegar conexao
	fechar conexão
	commit
	rollback
	*/
	
	public Connection getConnection();
	public void close();
	public void commit() throws SQLException;
	public void rollback();
	
}
