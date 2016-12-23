package br.com.itecbrazil.atualizadoriteccliente.util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;

public class UtilSocket {
	private static ServerSocket socket;
	
	public static void verificarInstaciaEmExecucao() throws SocketException{
		try {
			socket = new ServerSocket(9999);
		} catch (IOException e) {
			e.printStackTrace();
			throw new SocketException("Verificar se a instância do programa em execução, porta 9999!");
		}
	}
	
	public static void liberarPortaParaNovasIntacias() throws SocketException{
        try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
			throw new SocketException("Verificar liberação da porta 9999 pelo programa!");
		}
    }
}
