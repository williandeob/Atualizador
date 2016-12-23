package br.com.itecbrazil.atualizadoriteccliente.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import br.com.itecbrazil.atualizadoriteccliente.model.Configuracao;

public class TelaDeConfiguracaoBancoDeDados extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelSqlServerConfig;
	private JPanel panelPostgreSqlConfig;
	private JLabel labelConfiguraSqlServer;
	private JRadioButton radioUsaSqlServerNao;
	private JRadioButton radioUsaSqlServerSim;
	private JLabel labelEnderecoSqlServer;
	private JTextField inputEnderecoSqlServer;
	private JLabel labelUsuarioSqlServer;
	private JTextField inputUsuarioSqlServer;
	private JLabel labelSenhaSqlServer;
	private JTextField inputSenhaSqlServer;
	private JLabel labelConfiguraPostgreSql;
	private JRadioButton radioUsaPostgreSqlNao;
	private JRadioButton radioUsaPostgreSqlSim;
	private JLabel labelEnderecoPostgreSql;
	private JTextField inputEnderecoPostgreSql;
	private JLabel labelUsuarioPostgreSql;
	private JTextField inputUsuarioPostgreSql;
	private JLabel labelSenhaPostgreSql;
	private JTextField inputSenhaPostgreSql;
	private JButton buttonSalvar;
	private JButton buttonCancelar;
	private JLabel labelCopyRigth;
	private ButtonGroup sqlServerHabilitado;
	private ButtonGroup postgreSqlHabilitado;
	private Configuracao configuracao;
	
	public TelaDeConfiguracaoBancoDeDados(Configuracao configuracao){
		this.configuracao = configuracao;
		buildView();
		criarGrupoRadioButton();
		bindEvent();
		popularView();
	}

	private void popularView() {
		if(this.configuracao.isHabilitadoSqlServer()){
			this.radioUsaSqlServerSim.setSelected(true);
			habilitarInputs("sql");
		}
		if(this.configuracao.isHabilitadoPostgreSql()){
			this.radioUsaSqlServerNao.setSelected(true);
			habilitarInputs("postgre");
		}
		
		this.inputEnderecoSqlServer.setText(this.configuracao.getPathSqlServer());
		this.inputUsuarioSqlServer.setText(this.configuracao.getSqlUser());
		this.inputSenhaSqlServer.setText(this.configuracao.getSqlSenha());
		
		this.inputEnderecoPostgreSql.setText(this.configuracao.getPathPostgreSql());
		this.inputUsuarioPostgreSql.setText(this.configuracao.getPostgreUser());
		this.inputSenhaPostgreSql.setText(this.configuracao.getPostgreSenha());
	}
	
	private void habilitarInputs(String banco){
		if("sql".equals(banco)){
			this.inputEnderecoSqlServer.setEnabled(true);
			this.inputUsuarioSqlServer.setEnabled(true);
			this.inputSenhaSqlServer.setEnabled(true);
		}else{
			this.inputEnderecoPostgreSql.setEnabled(true);
			this.inputUsuarioPostgreSql.setEnabled(true);
			this.inputSenhaPostgreSql.setEnabled(true);
		}
	}
	
	private void desabilitarInputs(String banco){
		if("sql".equals(banco)){
			this.inputEnderecoSqlServer.setEnabled(false);
			this.inputUsuarioSqlServer.setEnabled(false);
			this.inputSenhaSqlServer.setEnabled(false);
		}else{
			this.inputEnderecoPostgreSql.setEnabled(false);
			this.inputUsuarioPostgreSql.setEnabled(false);
			this.inputSenhaPostgreSql.setEnabled(false);
		}
	}

	private void criarGrupoRadioButton() {
		this.sqlServerHabilitado = new ButtonGroup();
		this.sqlServerHabilitado.add(this.radioUsaSqlServerNao);
		this.sqlServerHabilitado.add(this.radioUsaSqlServerSim);
		
		this.postgreSqlHabilitado = new ButtonGroup();
		this.postgreSqlHabilitado.add(this.radioUsaPostgreSqlNao);
		this.postgreSqlHabilitado.add(this.radioUsaPostgreSqlSim);
	}

	private void buildView() {
		setTitle("Configuração do banco de dados da aplicação");
        setSize(new Dimension(700, 220));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanelConfigSqlServer();
        buildPanelConfigPostgreSql();
        getContentPane().add(panelSqlServerConfig, BorderLayout.NORTH);
        getContentPane().add(new JSeparator(), BorderLayout.CENTER);
        getContentPane().add(panelPostgreSqlConfig, BorderLayout.SOUTH);
        pack();
	}

	
	private void buildPanelConfigSqlServer() {
		panelSqlServerConfig = new JPanel();
		panelSqlServerConfig.setLayout(null);
		panelSqlServerConfig.setPreferredSize(new Dimension(700, 85));
		
		labelConfiguraSqlServer = new JLabel("Habilitar banco SQLServer");
		labelConfiguraSqlServer.setLocation(10, 10);
		labelConfiguraSqlServer.setSize(180, 15);
		labelConfiguraSqlServer.setFont(new java.awt.Font("Verdana", 0, 12));
		panelSqlServerConfig.add(labelConfiguraSqlServer);

		radioUsaSqlServerNao = new JRadioButton("Nao");
		radioUsaSqlServerNao.setLocation((int)labelConfiguraSqlServer.getLocation().getX()+labelConfiguraSqlServer.getWidth(), (int)labelConfiguraSqlServer.getLocation().getY());
		radioUsaSqlServerNao.setSize(60, 15);
		radioUsaSqlServerNao.setFont(new java.awt.Font("Verdana", 0, 12));
		radioUsaSqlServerNao.setSelected(true);
		panelSqlServerConfig.add(radioUsaSqlServerNao);
		
		radioUsaSqlServerSim = new JRadioButton("Sim");
		radioUsaSqlServerSim.setLocation((int)radioUsaSqlServerNao.getLocation().getX()+radioUsaSqlServerNao.getWidth(), (int)radioUsaSqlServerNao.getLocation().getY());
		radioUsaSqlServerSim.setSize(60, 15);
		radioUsaSqlServerSim.setFont(new java.awt.Font("Verdana", 0, 12));
		panelSqlServerConfig.add(radioUsaSqlServerSim);
		
		labelEnderecoSqlServer = new JLabel("Banco de dados SQLServer");
		labelEnderecoSqlServer.setLocation((int)labelConfiguraSqlServer.getLocation().getX(), (int)labelConfiguraSqlServer.getLocation().getY()+labelConfiguraSqlServer.getHeight()+10);
		labelEnderecoSqlServer.setSize(180, 15);
		labelEnderecoSqlServer.setFont(new java.awt.Font("Verdana", 0, 12));
		panelSqlServerConfig.add(labelEnderecoSqlServer);
		
		inputEnderecoSqlServer = new JTextField();
		inputEnderecoSqlServer.setLocation((int)labelEnderecoSqlServer.getLocation().getX(), (int)labelEnderecoSqlServer.getLocation().getY()+labelEnderecoSqlServer.getHeight());
		inputEnderecoSqlServer.setSize(390, 30);
		inputEnderecoSqlServer.setFont(new java.awt.Font("Verdana", 0, 12));
		inputEnderecoSqlServer.setEnabled(false);
		inputEnderecoSqlServer.setDisabledTextColor(Color.GRAY);
		panelSqlServerConfig.add(inputEnderecoSqlServer);
		
		labelUsuarioSqlServer = new JLabel("Usuário");
		labelUsuarioSqlServer.setLocation((int)labelEnderecoSqlServer.getLocation().getX()+inputEnderecoSqlServer.getWidth()+10, (int)labelEnderecoSqlServer.getLocation().getY());
		labelUsuarioSqlServer.setSize(75, 15);
		labelUsuarioSqlServer.setFont(new java.awt.Font("Verdana", 0, 12));
		panelSqlServerConfig.add(labelUsuarioSqlServer);
		
		inputUsuarioSqlServer = new JTextField();
		inputUsuarioSqlServer.setLocation((int)labelUsuarioSqlServer.getLocation().getX(), (int)labelEnderecoSqlServer.getLocation().getY()+labelEnderecoSqlServer.getHeight());
		inputUsuarioSqlServer.setSize(135, 30);
		inputUsuarioSqlServer.setFont(new java.awt.Font("Verdana", 0, 12));
		inputUsuarioSqlServer.setEnabled(false);
		inputUsuarioSqlServer.setDisabledTextColor(Color.GRAY);
		panelSqlServerConfig.add(inputUsuarioSqlServer);
		
		labelSenhaSqlServer = new JLabel("Senha");
		labelSenhaSqlServer.setLocation((int)labelUsuarioSqlServer.getLocation().getX()+inputUsuarioSqlServer.getWidth()+10, (int)labelUsuarioSqlServer.getLocation().getY());
		labelSenhaSqlServer.setSize(50, 15);
		labelSenhaSqlServer.setFont(new java.awt.Font("Verdana", 0, 12));
		panelSqlServerConfig.add(labelSenhaSqlServer);
		
		inputSenhaSqlServer = new JTextField();
		inputSenhaSqlServer.setLocation((int)inputUsuarioSqlServer.getLocation().getX()+inputUsuarioSqlServer.getWidth()+10, (int)inputUsuarioSqlServer.getLocation().getY());
		inputSenhaSqlServer.setSize(135, 30);
		inputSenhaSqlServer.setFont(new java.awt.Font("Verdana", 0, 12));
		inputSenhaSqlServer.setEnabled(false);
		inputSenhaSqlServer.setDisabledTextColor(Color.GRAY);
		panelSqlServerConfig.add(inputSenhaSqlServer);
	}
	
	private void buildPanelConfigPostgreSql() {
		panelPostgreSqlConfig = new JPanel();
		panelPostgreSqlConfig.setLayout(null);
		panelPostgreSqlConfig.setPreferredSize(new Dimension(700, 125));
		
		labelConfiguraPostgreSql = new JLabel("Habilitar banco PostgreSql");
		labelConfiguraPostgreSql.setLocation(10, 10);
		labelConfiguraPostgreSql.setSize(180, 15);
		labelConfiguraPostgreSql.setFont(new java.awt.Font("Verdana", 0, 12));
		panelPostgreSqlConfig.add(labelConfiguraPostgreSql);

		radioUsaPostgreSqlNao = new JRadioButton("Nao");
		radioUsaPostgreSqlNao.setLocation((int)labelConfiguraPostgreSql.getLocation().getX()+labelConfiguraPostgreSql.getWidth(), (int)labelConfiguraPostgreSql.getLocation().getY());
		radioUsaPostgreSqlNao.setSize(60, 15);
		radioUsaPostgreSqlNao.setFont(new java.awt.Font("Verdana", 0, 12));
		radioUsaPostgreSqlNao.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		radioUsaPostgreSqlNao.setSelected(true);
		panelPostgreSqlConfig.add(radioUsaPostgreSqlNao);
		
		radioUsaPostgreSqlSim = new JRadioButton("Sim");
		radioUsaPostgreSqlSim.setLocation((int)radioUsaPostgreSqlNao.getLocation().getX()+radioUsaPostgreSqlNao.getWidth(), (int)radioUsaPostgreSqlNao.getLocation().getY());
		radioUsaPostgreSqlSim.setSize(60, 15);
		radioUsaPostgreSqlSim.setFont(new java.awt.Font("Verdana", 0, 12));
		radioUsaPostgreSqlSim.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		panelPostgreSqlConfig.add(radioUsaPostgreSqlSim);
		
		labelEnderecoPostgreSql = new JLabel("Banco de dados PostgreSql");
		labelEnderecoPostgreSql.setLocation((int)labelConfiguraPostgreSql.getLocation().getX(), (int)labelConfiguraPostgreSql.getLocation().getY()+labelConfiguraPostgreSql.getHeight()+10);
		labelEnderecoPostgreSql.setSize(180, 15);
		labelEnderecoPostgreSql.setFont(new java.awt.Font("Verdana", 0, 12));
		panelPostgreSqlConfig.add(labelEnderecoPostgreSql);
		
		inputEnderecoPostgreSql = new JTextField();
		inputEnderecoPostgreSql.setLocation((int)labelEnderecoPostgreSql.getLocation().getX(), (int)labelEnderecoPostgreSql.getLocation().getY()+labelEnderecoPostgreSql.getHeight());
		inputEnderecoPostgreSql.setSize(390, 30);
		inputEnderecoPostgreSql.setFont(new java.awt.Font("Verdana", 0, 12));
		inputEnderecoPostgreSql.setEnabled(false);
		inputEnderecoPostgreSql.setDisabledTextColor(Color.GRAY);
		panelPostgreSqlConfig.add(inputEnderecoPostgreSql);
		
		labelUsuarioPostgreSql = new JLabel("Usuário");
		labelUsuarioPostgreSql.setLocation((int)labelEnderecoPostgreSql.getLocation().getX()+inputEnderecoPostgreSql.getWidth()+10, (int)labelEnderecoPostgreSql.getLocation().getY());
		labelUsuarioPostgreSql.setSize(75, 15);
		labelUsuarioPostgreSql.setFont(new java.awt.Font("Verdana", 0, 12));
		panelPostgreSqlConfig.add(labelUsuarioPostgreSql);
		
		inputUsuarioPostgreSql = new JTextField();
		inputUsuarioPostgreSql.setLocation((int)labelUsuarioPostgreSql.getLocation().getX(), (int)labelEnderecoPostgreSql.getLocation().getY()+labelEnderecoPostgreSql.getHeight());
		inputUsuarioPostgreSql.setSize(135, 30);
		inputUsuarioPostgreSql.setFont(new java.awt.Font("Verdana", 0, 12));
		inputUsuarioPostgreSql.setEnabled(false);
		inputUsuarioPostgreSql.setDisabledTextColor(Color.GRAY);
		panelPostgreSqlConfig.add(inputUsuarioPostgreSql);
		
		labelSenhaPostgreSql = new JLabel("Senha");
		labelSenhaPostgreSql.setLocation((int)labelUsuarioPostgreSql.getLocation().getX()+inputUsuarioPostgreSql.getWidth()+10, (int)labelUsuarioPostgreSql.getLocation().getY());
		labelSenhaPostgreSql.setSize(50, 15);
		labelSenhaPostgreSql.setFont(new java.awt.Font("Verdana", 0, 12));
		panelPostgreSqlConfig.add(labelSenhaPostgreSql);
		
		inputSenhaPostgreSql = new JTextField();
		inputSenhaPostgreSql.setLocation((int)inputUsuarioPostgreSql.getLocation().getX()+inputUsuarioPostgreSql.getWidth()+10, (int)inputUsuarioPostgreSql.getLocation().getY());
		inputSenhaPostgreSql.setSize(135, 30);
		inputSenhaPostgreSql.setFont(new java.awt.Font("Verdana", 0, 12));
		inputSenhaPostgreSql.setEnabled(false);
		inputSenhaPostgreSql.setDisabledTextColor(Color.GRAY);
		panelPostgreSqlConfig.add(inputSenhaPostgreSql);
		
		buttonSalvar = new JButton("Salvar");
		buttonSalvar.setSize(90, 30);
		buttonSalvar.setLocation((int)inputSenhaPostgreSql.getLocation().getX()+inputSenhaPostgreSql.getWidth() - buttonSalvar.getWidth(), (int)inputSenhaPostgreSql.getLocation().getY()+inputSenhaPostgreSql.getHeight()+10);
		buttonSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		buttonSalvar.setFont(new java.awt.Font("Verdana", 0, 12));
		panelPostgreSqlConfig.add(buttonSalvar);
		
		buttonCancelar = new JButton("Cancelar");
		buttonCancelar.setSize(90, 30);
		buttonCancelar.setLocation((int)buttonSalvar.getLocation().getX() - buttonCancelar.getWidth()-10, (int)buttonSalvar.getLocation().getY());
		buttonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		buttonCancelar.setFont(new java.awt.Font("Verdana", 0, 12));
		panelPostgreSqlConfig.add(buttonCancelar);
		
		labelCopyRigth = new JLabel("Atualizador Copyright © ItecBrazil");
		labelCopyRigth.setLocation(10, (int)buttonSalvar.getLocation().getY()+15);
		labelCopyRigth.setSize(200, 15);
		labelCopyRigth.setFont(new java.awt.Font("Verdana", 1, 10));
		panelPostgreSqlConfig.add(labelCopyRigth);
	}
	
	private void bindEvent(){
		
		this.radioUsaSqlServerSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               habilitarInputs("sql");
            }
        });
		
		this.radioUsaSqlServerNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               desabilitarInputs("sql");
            }
        });
		
		this.radioUsaPostgreSqlSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               habilitarInputs("postgre");
            }
        });
		
		this.radioUsaPostgreSqlNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               desabilitarInputs("postgre");
            }
        });
		
		this.buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
            }
        });
		
		this.buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
               
            }
        });

	}

}