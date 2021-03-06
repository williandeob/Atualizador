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
	private String sqlUser, postgreUser;
	private String sqlSenha, postgreSenha;
	
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
				setSqlUser(configuracaoDoArquivo.getSqlUser());
				setPostgreUser(configuracaoDoArquivo.getPostgreUser());
				setSqlSenha(configuracaoDoArquivo.getSqlSenha());
				setPostgreSenha(configuracaoDoArquivo.getPostgreSenha());

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
			setSqlUser("");
			setPostgreUser("");
			setSqlSenha("");
			setPostgreSenha("");
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
	public void setHabilitadoSqlServer(boolean habilitadoSqlServer) {
		this.habilitadoSqlServer = habilitadoSqlServer;
	}
	public boolean isHabilitadoPostgreSql() {
		return habilitadoPostgreSql;
	}
	public void setHabilitadoPostgreSql(boolean habilitadoPostgreSql) {
		this.habilitadoPostgreSql = habilitadoPostgreSql;
	}
	public String getPathSqlServer() {
		return pathSqlServer;
	}
	public void setPathSqlServer(String pathSqlServer) {
		this.pathSqlServer = pathSqlServer;
	}
	public String getPathPostgreSql() {
		return pathPostgreSql;
	}
	public void setPathPostgreSql(String pathPostgreSql) {
		this.pathPostgreSql = pathPostgreSql;
	}
	public String getSqlUser() {
		return sqlUser;
	}
	public void setSqlUser(String sqlUser) {
		this.sqlUser = sqlUser;
	}
	public String getPostgreUser() {
		return postgreUser;
	}
	public void setPostgreUser(String postgreUser) {
		this.postgreUser = postgreUser;
	}
	public String getSqlSenha() {
		return sqlSenha;
	}
	public void setSqlSenha(String sqlSenha) {
		this.sqlSenha = sqlSenha;
	}
	public String getPostgreSenha() {
		return postgreSenha;
	}
	public void setPostgreSenha(String postgreSenha) {
		this.postgreSenha = postgreSenha;
	}


	private class ConfiguracaoConteudo{
		public boolean habilitadoSqlServer, habilitadoPostgreSql;
		public String pathSqlServer = "", pathPostgreSql = "";
		private String sqlUser = "", postgreUser = "";
		private String sqlSenha = "", postgreSenha = "";
		
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
		public String getSqlUser() {
			return sqlUser;
		}
		public String getPostgreUser() {
			return postgreUser;
		}
		public String getSqlSenha() {
			return sqlSenha;
		}
		public String getPostgreSenha() {
			return postgreSenha;
		}
	}
}
