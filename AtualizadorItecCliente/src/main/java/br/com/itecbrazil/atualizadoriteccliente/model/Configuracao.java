package br.com.itecbrazil.atualizadoriteccliente.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;

import br.com.itecbrazil.atualizadoriteccliente.util.UtilDirectory;

public class Configuracao {
	private static Configuracao configuracao;
	private boolean habilitadoSqlServer, habilitadoPostgreSql;
	private String pathSqlServer, pathPostgreSql;
	
	private Configuracao () throws IOException{
		File arquivoDeConfiguracao = UtilDirectory.getFileConfiguracao();
		if(arquivoDeConfiguracao.exists() && arquivoDeConfiguracao.length()>0){
			InputStream is = null;
			InputStreamReader isr = null;
			BufferedReader br = null;
			try{
				is = new FileInputStream(arquivoDeConfiguracao);
				isr = new InputStreamReader(is);
				br = new BufferedReader(isr);
				StringBuilder conteudo = new StringBuilder();
				String linha = br.readLine();
				while (linha != null) {
					conteudo.append(linha);
					linha = br.readLine();
				}
				
				Gson gson = new Gson();
				ConfiguracaoConteudo configuracaoDoArquivo = gson.fromJson(conteudo.toString(), ConfiguracaoConteudo.class);
				setHabilitadoSqlServer(configuracaoDoArquivo.isHabilitadoSqlServer());
				setHabilitadoPostgreSql(configuracaoDoArquivo.isHabilitadoPostgreSql());
				setPathSqlServer(configuracaoDoArquivo.getPathSqlServer());
				setPathPostgreSql(configuracaoDoArquivo.getPathPostgreSql());

			}finally{
				if(br != null){
					br.close();
				}
			}
		}else{
			setHabilitadoSqlServer(false);
			setHabilitadoPostgreSql(false);
			setPathSqlServer("");
			setPathPostgreSql("");
		}
	};
	
	public static synchronized Configuracao getInstancia() throws IOException{
		if(configuracao == null){
			configuracao = new Configuracao();
		}
		
		return configuracao;
	};
	
	public boolean isHabilitadoSqlServer() {
		return habilitadoSqlServer;
	}
	private void setHabilitadoSqlServer(boolean habilitadoSqlServer) {
		this.habilitadoSqlServer = habilitadoSqlServer;
	}
	public boolean isHabilitadoPostgreSql() {
		return habilitadoPostgreSql;
	}
	private void setHabilitadoPostgreSql(boolean habilitadoPostgreSql) {
		this.habilitadoPostgreSql = habilitadoPostgreSql;
	}
	public String getPathSqlServer() {
		return pathSqlServer;
	}
	private void setPathSqlServer(String pathSqlServer) {
		this.pathSqlServer = pathSqlServer;
	}
	public String getPathPostgreSql() {
		return pathPostgreSql;
	}
	private void setPathPostgreSql(String pathPostgreSql) {
		this.pathPostgreSql = pathPostgreSql;
	}
	
	private class ConfiguracaoConteudo{
		public boolean habilitadoSqlServer, habilitadoPostgreSql;
		public String pathSqlServer, pathPostgreSql;
		public ConfiguracaoConteudo(boolean habilitadoSqlServer, boolean habilitadoPostgreSql, String pathSqlServer, String pathPostgreSql) {
			super();
			this.habilitadoSqlServer = habilitadoSqlServer;
			this.habilitadoPostgreSql = habilitadoPostgreSql;
			this.pathSqlServer = pathSqlServer;
			this.pathPostgreSql = pathPostgreSql;
		}
		public boolean isHabilitadoSqlServer() {
			return habilitadoSqlServer;
		}
		public boolean isHabilitadoPostgreSql() {
			return habilitadoPostgreSql;
		}
		public String getPathSqlServer() {
			return pathSqlServer;
		}
		public String getPathPostgreSql() {
			return pathPostgreSql;
		} 
	}
}
