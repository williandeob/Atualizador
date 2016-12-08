package br.com.itecbrazil.atualizadoriteccliente;

import java.io.IOException;
import java.sql.SQLException;

import br.com.itecbrazil.atualizadoriteccliente.model.Configuracao;
import br.com.itecbrazil.atualizadoriteccliente.util.UtilBancoDeDados;
import br.com.itecbrazil.atualizadoriteccliente.util.UtilDirectory;

/**
 * @author willian batista
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
        	
			UtilDirectory.criarDiretorioDeConfiguracaoDoSistema();
			Configuracao configuracao = Configuracao.getInstancia();
			UtilBancoDeDados.validarDadosDeConfiguracao(configuracao);
			iniciarServico();
	
		} catch (IOException e) {
			System.out.println("Diretório de configuração não pode ser criado ou não há permissao de leitura ou escrita!");
			e.printStackTrace();
		}catch( SQLException e){	
			iniciarConfiguracao();
			e.printStackTrace();
		}
    }
   
    
    private static void iniciarServico(){
    	System.out.println("Iniciou Servico");
    }
    
	private static void iniciarConfiguracao(){
    	System.out.println("Iniciou Tela de Configuração");
    }
	

}
