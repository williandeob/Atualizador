package br.com.itecbrazil.atualizadoriteccliente.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.itecbrazil.atualizadoriteccliente.model.Configuracao;

public class ConexaoSqlServer implements IConexao{
	private Connection conexao;
	private Configuracao configuracao;
	
	public ConexaoSqlServer(Configuracao configuracao) throws IOException, SQLException {
		super();
		this.configuracao = configuracao;
		buildConexao();
	}
	
	public Connection buildConexao() throws SQLException {
		String url = "jdbc:sqlserver://"+configuracao.getPathSqlServer();
		String user = configuracao.getSqlUser();
		String password = configuracao.getSqlSenha();
		conexao = DriverManager.getConnection(url, user, password);
		return conexao;
	}
	
	@Override
	public Connection getConexao() {
		return conexao;
	}

	@Override
	public void desconectar() throws SQLException {
		conexao.close();
	}
}