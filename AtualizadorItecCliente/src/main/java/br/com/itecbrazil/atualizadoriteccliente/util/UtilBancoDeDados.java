package br.com.itecbrazil.atualizadoriteccliente.util;

import java.io.IOException;
import java.sql.SQLException;

import br.com.itecbrazil.atualizadoriteccliente.dao.ConexaoPostgreSql;
import br.com.itecbrazil.atualizadoriteccliente.dao.ConexaoSqlServer;
import br.com.itecbrazil.atualizadoriteccliente.dao.IConexao;
import br.com.itecbrazil.atualizadoriteccliente.model.Configuracao;

public class UtilBancoDeDados {
	
	 public static void validarDadosDeConfiguracao(Configuracao configuracao) throws IOException, SQLException{
		 	if(!configuracao.isHabilitadoSqlServer() && !configuracao.isHabilitadoPostgreSql()){
		 		throw new SQLException();
		 	}

		 	if(configuracao.isHabilitadoSqlServer()){
		    	IConexao testeConexaoSql = new ConexaoSqlServer();
		    	testeConexaoSql.desconectar();
		 	}
		 	
	    	if(configuracao.isHabilitadoPostgreSql()){
	    		IConexao testeConexaoPostgre = new ConexaoPostgreSql();
	    		testeConexaoPostgre.desconectar();
		 	}
	    	
	  }
	 
}
