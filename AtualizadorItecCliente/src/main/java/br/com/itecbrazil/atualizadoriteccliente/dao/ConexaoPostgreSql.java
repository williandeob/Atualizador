package br.com.itecbrazil.atualizadoriteccliente.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.itecbrazil.atualizadoriteccliente.model.Configuracao;

public class ConexaoPostgreSql implements IConexao{
	private Connection conexao;
	private Configuracao configuracao;
	
	public ConexaoPostgreSql(Configuracao configuracao) throws IOException, SQLException {
		super();
		this.configuracao = configuracao;
		buildConexao();
	}
	
	public Connection buildConexao() throws SQLException {
		String url = "jdbc:postgresql://"+configuracao.getPathPostgreSql();
		String user = configuracao.getPostgreUser();
		String password = configuracao.getPostgreSenha();
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
