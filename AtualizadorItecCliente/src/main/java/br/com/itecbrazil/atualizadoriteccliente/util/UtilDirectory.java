package br.com.itecbrazil.atualizadoriteccliente.util;

import java.io.File;
import java.io.IOException;

public class UtilDirectory {
	private static String diretorioDeConfiguracao = System.getProperty("user.home").concat(File.separator).concat("itecbrazil").concat(File.separator).concat("atualizador");
	private static String nomeArquivoDeConfiguracao = "atualizadorConfig.json";
	
	public static void criarDiretorioDeConfiguracaoDoSistema() throws IOException{
		File diretorioDeConfiguracao = new File(UtilDirectory.diretorioDeConfiguracao);
		File arquivoDeConfiguracao = new File(UtilDirectory.diretorioDeConfiguracao.concat(File.separator).concat(UtilDirectory.nomeArquivoDeConfiguracao));
		if(!arquivoDeConfiguracao.exists()){
			diretorioDeConfiguracao.mkdirs();
			arquivoDeConfiguracao.createNewFile();
		}
	};
	
	public static File getFileConfiguracao(){
		return new File(UtilDirectory.diretorioDeConfiguracao.concat(File.separator).concat(UtilDirectory.nomeArquivoDeConfiguracao));
	};
}
