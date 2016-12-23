package br.com.itecbrazil.atualizadoriteccliente;

import java.io.IOException;
import java.net.SocketException;
import java.sql.SQLException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import br.com.itecbrazil.atualizadoriteccliente.model.Configuracao;
import br.com.itecbrazil.atualizadoriteccliente.model.ThreadAtualizadorDeArquivosDoWebService;
import br.com.itecbrazil.atualizadoriteccliente.util.UtilBancoDeDados;
import br.com.itecbrazil.atualizadoriteccliente.util.UtilDirectory;
import br.com.itecbrazil.atualizadoriteccliente.util.UtilSocket;
import br.com.itecbrazil.atualizadoriteccliente.view.PopupDialog;
import br.com.itecbrazil.atualizadoriteccliente.view.TelaDeConfiguracaoBancoDeDados;

/**
 * @author willian batista
 *
 */
public class App 
{
    private static ScheduledExecutorService service;

	public static void main( String[] args )
    {
    	Configuracao configuracao = null;

        try {
        	UtilSocket.verificarInstaciaEmExecucao();
			UtilDirectory.criarDiretorioDeConfiguracaoDoSistema();
			configuracao = Configuracao.getInstancia();
			UtilBancoDeDados.validarDadosDeConfiguracao(configuracao);
			iniciarServico();
	
        }catch( SocketException e){
        	e.printStackTrace();
        	PopupDialog popup = new PopupDialog("FALHA OPERACIONAL", "Verificar se já existe uma instância do programa em execução, porta 9999");
			popup.show(null);
		} catch( IOException e ) {
			e.printStackTrace();
			PopupDialog popup = new PopupDialog("FALHA OPERACIONAL", "Diretório de configuração não pode ser criado ou não há permissao de leitura ou escrita");
			popup.show(null);
		} catch( SQLException e ){ //validarDadosDeConfiguracao()
			e.printStackTrace();
			System.out.println("Banco não configurado corretamente!");
			iniciarConfiguracao(configuracao);
		}
    }
   
    
    public static void iniciarServico(){
    	System.out.println("Iniciou Servico");
    	service = Executors.newScheduledThreadPool(1);
    	Runnable thread = new ThreadAtualizadorDeArquivosDoWebService();
    	service.scheduleAtFixedRate(new Thread(thread), 10, 10, TimeUnit.SECONDS);
    }
	
	public static void pararServico(){
		System.out.println("Parar Servico");
		if(service != null)
			service.shutdown();
	}
	
	private static void iniciarConfiguracao(Configuracao configuracao){
    	System.out.println("Iniciou Tela de Configuração");
    	TelaDeConfiguracaoBancoDeDados telaDeConfiguracao = new TelaDeConfiguracaoBancoDeDados(configuracao);
    	telaDeConfiguracao.setVisible(true);
    }

}
