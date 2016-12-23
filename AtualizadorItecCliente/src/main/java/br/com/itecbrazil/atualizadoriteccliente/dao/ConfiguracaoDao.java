package br.com.itecbrazil.atualizadoriteccliente.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.itecbrazil.atualizadoriteccliente.model.Configuracao;
import br.com.itecbrazil.atualizadoriteccliente.util.UtilDirectory;

public class ConfiguracaoDao {
	
	public ConfiguracaoDao(){
	}
	
	public void save (Configuracao configuracao) throws IOException{
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String conteudo = gson.toJson(configuracao, Configuracao.class);
		File arquivo = UtilDirectory.getFileConfiguracao();
		BufferedWriter buffWrite = null;
		try{
			buffWrite = new BufferedWriter(new FileWriter(arquivo));
		    buffWrite.write(conteudo);
		    buffWrite.flush();
		   
		}finally{
			if( buffWrite!= null)
			 buffWrite.close();
		}
		
	}
}
