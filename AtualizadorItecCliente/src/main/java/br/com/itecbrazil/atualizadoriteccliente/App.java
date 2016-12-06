package br.com.itecbrazil.atualizadoriteccliente;

import java.io.IOException;

import br.com.itecbrazil.atualizadoriteccliente.model.Configuracao;
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
			if(validarDadosDeConfiguracao()){
				iniciarServico();
			}else{
				iniciarConfiguracao();
			}	

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    private static boolean validarDadosDeConfiguracao(){
    	return true;
    }
    
    private static void iniciarServico(){
    	
    }
    
	private static void iniciarConfiguracao(){
    	
    }
	

}
