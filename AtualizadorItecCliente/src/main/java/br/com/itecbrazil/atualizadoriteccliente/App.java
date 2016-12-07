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
			e.printStackTrace();
		}catch( SQLException e){
			iniciarConfiguracao();
		}
    }
   
    
    private static void iniciarServico(){
    	
    }
    
	private static void iniciarConfiguracao(){
    	
    }
	

}
