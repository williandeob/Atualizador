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
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
