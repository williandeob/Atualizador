package br.com.itecbrazil.atualizadoriteccliente.model;

import java.io.IOException;

public class ThreadAtualizadorDeArquivosDoWebService implements Runnable{
	
	private Configuracao configuracao;
	
	@Override
	public void run() {
		try {
			System.out.println("thread executada...");
			configuracao = Configuracao.getInstancia();
		} catch (IOException e) {
			System.out.println("Thread parou pois não foi possivel recuperas as informações de configuração");
			e.printStackTrace();
		}
	}

}
