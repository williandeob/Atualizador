package br.com.itecbrazil.atualizadoriteccliente.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConexao {
	
	public Connection getConexao();
	public void desconectar() throws SQLException;	

}
