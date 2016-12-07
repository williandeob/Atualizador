package br.com.itecbrazil.atualizadoriteccliente.util;

import java.io.IOException;
import java.sql.SQLException;

import br.com.itecbrazil.atualizadoriteccliente.dao.ConexaoSqlServer;
import br.com.itecbrazil.atualizadoriteccliente.dao.IConexao;
import br.com.itecbrazil.atualizadoriteccliente.model.Configuracao;

public class UtilBancoDeDados {
	
	 public static void validarDadosDeConfiguracao(Configuracao configuracao) throws IOException, SQLException{
	    if("".equals(configuracao.getPathPostgreSql().trim()) && "".equals(configuracao.getPathSqlServer().trim())){
	    	throw new SQLException();
	    }else{
	    	IConexao testeConexaoSql = new ConexaoSqlServer();
	    	testeConexaoSql.desconectar();
	    }
	  }
	 

}
