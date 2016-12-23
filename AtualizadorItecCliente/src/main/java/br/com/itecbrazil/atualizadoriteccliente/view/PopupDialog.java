package br.com.itecbrazil.atualizadoriteccliente.view;

import java.awt.Component;

import javax.swing.JOptionPane;

public class PopupDialog {
String titulo, mensagem;

	public PopupDialog (String titulo, String mensagem){
		this.titulo = titulo;
		this.mensagem = mensagem;
	}
	
	public void show(Component parentComponent){
		JOptionPane.showMessageDialog(parentComponent, this.mensagem, this.titulo, JOptionPane.ERROR_MESSAGE); 
	};
	
}