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
				String conteudo = br.readLine();
				while (conteudo != null) {
					conteudo+=br.readLine();
				}

				Gson gson = new Gson();
				


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
	
	
}
