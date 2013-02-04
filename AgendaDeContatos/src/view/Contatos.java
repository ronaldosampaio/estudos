package view;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import conexão.ConectaBanco;
import controller.ContatoControle;
//import controller.ContatoControle;

import java.util.ArrayList;
import java.util.List;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import model.bean.ContatoBean;
import model.dao.ContatosDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.ImageIcon;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.FlowLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.JSeparator;


public class Contatos extends JFrame {

	public JPanel contentPane,panelPrincipal,panelTelFixo,panelCel1,panelCel2;
	public JButton btNovo,btSalvar,btAlterar,btExcluir,btSair;
	public JFormattedTextField tfId, tfLocal, tfContato1, tfCel1,tfCel2;
	public JComboBox<String> cbNome, cbTelTipoFixo,cbTelTipoCel1, cbTelTipoCel2;
	//public List<ContatoBean> contatoList = new ContatoControle().listaContatos();
	int registroAtual = 0;
    private ContatoControle controller = new ContatoControle();
	ResultSet rs = null;
	Connection conn = null;
	PreparedStatement pstm = null;
	ConectaBanco cb = new ConectaBanco();
	//ContatoBean cb =new ContatoBean();
	//ContatosDao cd = new ContatosDao();
	
	
	//ConexaoBanco obj_conexao = new ConexaoBanco();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Contatos frame = new Contatos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	
	public void mostrarDados() 
	{
		ContatoBean bean = new ContatoBean();
		bean=controller.getContatos();
		tfId.setText(String.valueOf(bean.getId()));
		
	}

	
	public Contatos() throws SQLException  
	{
		setTitle("Agenda de contatos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 562);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(UIManager.getBorder("CheckBox.border"));
		panelPrincipal.setBounds(10, 11, 895, 338);
		contentPane.add(panelPrincipal);
		panelPrincipal.setLayout(null);
		
		JLabel lbId = new JLabel("Id.:");
		lbId.setFont(new Font("Arial", Font.PLAIN, 20));
		lbId.setBounds(10, 11, 29, 32);
		panelPrincipal.add(lbId);
		
		tfId = new JFormattedTextField();
		tfId.setEditable(false);
		tfId.setFont(new Font("Arial", Font.PLAIN, 20));
		tfId.setBounds(49, 11, 58, 32);
		panelPrincipal.add(tfId);
		
		JLabel lbNome = new JLabel("Nome.:");
		lbNome.setFont(new Font("Arial", Font.PLAIN, 20));
		lbNome.setBounds(124, 11, 68, 32);
		panelPrincipal.add(lbNome);
		
		cbNome = new JComboBox<String>();
		cbNome.setEditable(true);
		cbNome.setFont(new Font("Arial", Font.PLAIN, 20));
		cbNome.setBounds(202, 11, 354, 32);
		panelPrincipal.add(cbNome);
		
		JLabel lbLocal = new JLabel("Local.:");
		lbLocal.setFont(new Font("Arial", Font.PLAIN, 20));
		lbLocal.setBounds(566, 11, 68, 32);
		panelPrincipal.add(lbLocal);
		
		tfLocal = new JFormattedTextField();
		tfLocal.setFont(new Font("Arial", Font.PLAIN, 20));
		tfLocal.setBounds(644, 11, 238, 32);
		panelPrincipal.add(tfLocal);
			
		panelTelFixo = new JPanel();
		panelTelFixo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Telefone fixo", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panelTelFixo.setBounds(10, 157, 296, 110);
		panelPrincipal.add(panelTelFixo);
		panelTelFixo.setLayout(null);
		
		cbTelTipoFixo = new JComboBox<String>();
		cbTelTipoFixo.setFont(new Font("Arial", Font.PLAIN, 20));
		cbTelTipoFixo.setModel(new DefaultComboBoxModel<String>(new String[] {"Resid\u00EAncia", "Comercio"}));
		cbTelTipoFixo.setBounds(10, 40, 124, 30);
		panelTelFixo.add(cbTelTipoFixo);
		
		tfContato1 = new JFormattedTextField();
		tfContato1.setFont(new Font("Arial", Font.PLAIN, 20));
		tfContato1.setBounds(144, 40, 142, 30);
		panelTelFixo.add(tfContato1);
		
		panelCel1 = new JPanel();
		panelCel1.setLayout(null);
		panelCel1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Telefone Celular 1", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panelCel1.setBounds(316, 157, 278, 110);
		panelPrincipal.add(panelCel1);
		
		cbTelTipoCel1 = new JComboBox<String>();
		cbTelTipoCel1.setModel(new DefaultComboBoxModel<String>(new String[] {"Nenhum", "Oi", "Tim", "Claro", "Vivo", "Nextel"}));
		cbTelTipoCel1.setFont(new Font("Arial", Font.PLAIN, 20));
		cbTelTipoCel1.setBounds(10, 40, 97, 30);
		panelCel1.add(cbTelTipoCel1);
		
		tfCel1 = new JFormattedTextField();
		tfCel1.setBounds(116, 40, 152, 30);
		panelCel1.add(tfCel1);
		tfCel1.setFont(new Font("Arial", Font.PLAIN, 20));
		
		panelCel2 = new JPanel();
		panelCel2.setLayout(null);
		panelCel2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Telefone Celular 2", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panelCel2.setBounds(604, 157, 278, 110);
		panelPrincipal.add(panelCel2);
		
		cbTelTipoCel2 = new JComboBox<String>();
		cbTelTipoCel2.setModel(new DefaultComboBoxModel<String>(new String[] {"Nenhum", "Oi", "Tim", "Claro", "Vivo", "Nextel"}));
		cbTelTipoCel2.setFont(new Font("Arial", Font.PLAIN, 20));
		cbTelTipoCel2.setBounds(10, 40, 97, 30);
		panelCel2.add(cbTelTipoCel2);
		
		tfCel2 = new JFormattedTextField();
		tfCel2.setFont(new Font("Arial", Font.PLAIN, 20));
		tfCel2.setBounds(117, 40, 152, 30);
		panelCel2.add(tfCel2);
		mostrarDados();
		
		try 
		{
			ContatosDao contato = new ContatosDao();

			//contato.setNome(cbNome.getSelectedItem());
		    //contato.setTipoLocal(tfLocal.getText());
		    //contato.setTelTipoFixo(cbTelTipoFixo.getSelectedItem());
		    //contato.setTelefoneFixo(tfContato1.getText()); 
		    //contato.setTelTipoOperadora1(cbTelTipoCel1.getSelectedItem()); 
		    //contato.setTelCelular1(tfCel1.getText());   
		    //contato.setTelTipoOperadora2(cbTelTipoCel2.getSelectedItem());   
		    //contato.setTelCelular2(tfCel2.getText());
		    //System.out.println(tfId.getText());
			//System.out.println(cbNome.getSelectedItem());
		    //System.out.println(tfLocal.getText());
		    //System.out.println(cbTelTipoFixo.getSelectedItem());
		    //System.out.println(tfContato1.getText());
		    //System.out.println(cbTelTipoCel1.getSelectedItem());
		    //System.out.println(tfCel1.getText());
		    //System.out.println(cbTelTipoCel2.getSelectedItem());
		    //System.out.println(tfCel2.getText());		
	     
			
			/*
			ContatosDao cd = new ContatosDao();
			cd.mostrarContato(cbNome.getSelectedItem(), 
					                        tfLocal.getText(), 
					                  cbTelTipoFixo.getSelectedItem(),
					                     tfContato1.getText(),
					                  cbTelTipoCel1.getSelectedItem(),
					                         tfCel1.getText(),
					                  cbTelTipoCel2.getSelectedItem(),
					                         tfCel2.getText());
			System.out.println(tfId.getText());
			System.out.println(cbNome.getSelectedItem());
		    System.out.println(tfLocal.getText());
		    System.out.println(cbTelTipoFixo.getSelectedItem());
		    System.out.println(tfContato1.getText());
		    System.out.println(cbTelTipoCel1.getSelectedItem());
		    System.out.println(tfCel1.getText());
		    System.out.println(cbTelTipoCel2.getSelectedItem());
		    System.out.println(tfCel2.getText());
		    */
		} 
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Erro ao mostrar dados VIEW " +e);
		}
        
		
		JPanel panelBotoes = new JPanel();
		panelBotoes.setBorder(UIManager.getBorder("CheckBox.border"));
		panelBotoes.setBounds(36, 463, 844, 54);
		contentPane.add(panelBotoes);
		panelBotoes.setLayout(null);
		
		//Evento do botão novo
		btNovo = new JButton("Novo");
		btNovo.setBounds(10, 8, 125, 39);
		btNovo.setIcon(new ImageIcon(Contatos.class.getResource("/resources/images/Novo.gif")));
		panelBotoes.add(btNovo);
		btNovo.setFont(new Font("Arial", Font.PLAIN, 20));
		btNovo.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				int novo = JOptionPane.showConfirmDialog(null,"Você deseja inserir um novo contato?","Novo",JOptionPane.YES_NO_OPTION);
				if(novo == JOptionPane.YES_OPTION)
				try 
				{   
					cbNome.setSelectedItem("");
				    tfLocal.setText("");
				    cbTelTipoFixo.setToolTipText("");
				    tfContato1.setText("");
				    cbTelTipoCel1.setSelectedItem("");
				    tfCel1.setText("");
				    cbTelTipoCel2.setSelectedItem("");
				    tfCel2.setText("");
				} 
				catch (Exception e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		
		//Evento do botão salvar
		btSalvar = new JButton("Salvar");
		btSalvar.setIcon(new ImageIcon(Contatos.class.getResource("/resources/images/Salvar.gif")));
		btSalvar.setBounds(145, 8, 125, 39);
		panelBotoes.add(btSalvar);
		btSalvar.setFont(new Font("Arial", Font.PLAIN, 20));
		btSalvar.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent arg0) 
			{   
//				try
//			    {
//					ContatosDao cd = new ContatosDao();
//				    cd.gravarContatos(cbNome.getSelectedItem(), 
//				    		          tfLocal.getText(),  
//				    		          cbTelTipoFixo.getSelectedItem(), 
//				    		          tfContato1.getText(), 
//				    		          cbTelTipoCel1.getSelectedItem(), 
//				    		          tfCel1.getText(), 
//				    		          cbTelTipoCel2.getSelectedItem(), 
//				    		          tfCel2.getText());
//				     }
//		        
//				catch(Exception erro)
//				{
//					JOptionPane.showMessageDialog(null,"Erro ao clicar no evento gravar" +erro);
//				}
			}
		});
		
		
		//Evento do botão alterar
		btAlterar = new JButton("Alterar");
		btAlterar.setIcon(new ImageIcon(Contatos.class.getResource("/resources/images/Alterar.gif")));
		btAlterar.setBounds(280, 8, 125, 39);
		panelBotoes.add(btAlterar);
		btAlterar.setFont(new Font("Arial", Font.PLAIN, 20));
		btAlterar.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
//				/*ContatosDao cd =new ContatosDao();
//				
//				
//					
//						try 
//						{
//						    cd.alterarContato(Integer.parseInt(tfId.getText()),
//						    		          cbNome.getSelectedItem(),
//						    		          tfLocal.getText(),
//			                                  cbTelTipoFixo.getSelectedItem(),
//			                                  tfContato1.getText(),
//			                                  cbTelTipoCel1.getSelectedItem(),
//			                                  tfCel1.getText(),
//			                                  cbTelTipoCel2.getSelectedItem(),
//			                                  tfCel2.getText());                         
//						} 
//						catch (ParseException e) 
//						{
//							e.printStackTrace();
//						}
//					
//		*/		
		    }
		});
		
		
		//Evento do botão excluir
		btExcluir = new JButton("Excluir");
		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btExcluir.setIcon(new ImageIcon(Contatos.class.getResource("/resources/images/Excluir.gif")));
		btExcluir.setBounds(415, 8, 125, 39);
		panelBotoes.add(btExcluir);
		btExcluir.setFont(new Font("Arial", Font.PLAIN, 20));
		btExcluir.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				
					
						String retorno=controller.excluir(Integer.parseInt(tfId.getText()),
								String.valueOf(cbNome.getSelectedItem()), 
								String.valueOf(tfLocal.getText()), 
								                  String.valueOf(cbTelTipoFixo.getSelectedItem()),
								                  String.valueOf(tfContato1.getText()),
								                     String.valueOf(cbTelTipoCel1.getSelectedItem()),
								                     String.valueOf(tfCel1.getText()),
								                         String.valueOf(cbTelTipoCel2.getSelectedItem()),
								                         String.valueOf(tfCel2.getText()));
						JOptionPane.showMessageDialog(null, retorno);
					
			}
				
		});
		
		JButton btPesquisar = new JButton("Consultar");
		btPesquisar.setIcon(new ImageIcon(Contatos.class.getResource("/resources/images/Pesquisar.gif")));
		btPesquisar.setFont(new Font("Arial", Font.PLAIN, 20));
		btPesquisar.setBounds(550, 8, 150, 39);
		panelBotoes.add(btPesquisar);
		
		JPanel panelNavegacao = new JPanel();
		panelNavegacao.setBorder(UIManager.getBorder("CheckBox.border"));
		panelNavegacao.setBounds(324, 378, 276, 61);
		contentPane.add(panelNavegacao);
		panelNavegacao.setLayout(null);
		
		JButton btPrimeiro = new JButton("");
		btPrimeiro.setBounds(10, 8, 57, 45);
		btPrimeiro.setToolTipText("Primeiro registro");
		btPrimeiro.setIcon(new ImageIcon(Contatos.class.getResource("/resources/images/Primeiro.gif")));
		panelNavegacao.add(btPrimeiro);
		btPrimeiro.addMouseListener(new MouseAdapter() 
		{
		public void mouseClicked(MouseEvent e) 
		{		
		
			
				
				//public void getValores(int index); 
				//{
					        //if (index <= contatoList.size() - 1) 
					        //{
					
					            //ContatoBean contatoAtual = new ContatoBean();//.get(index);
//					            cbNome.setSelectedItem(contatoAtual.getNome());
//					            tfLocal.setText(contatoAtual.getTipoLocal());
//					            cbTelTipoFixo.setSelectedItem(contatoAtual.getTelTipoFixo()); 
//					            tfContato1.setText(contatoAtual.getTelefoneFixo());
//				                cbTelTipoCel1.setSelectedItem(contatoAtual.getTelTipoOperadora1());
//				                tfCel1.setText(contatoAtual.getTelCelular1());
//				                cbTelTipoCel2.setSelectedItem(contatoAtual.getTelTipoOperadora2());
//				                tfCel2.setText(contatoAtual.getTelCelular2());
					        //}
			    }

		
				
				
				/*ArrayList <ContatoBean> lista = new ArrayList <ContatoBean>();
		
				System.out.println(lista);
				ContatosDao cd = new ContatosDao();
				cd.mostrarContato(cbNome.getSelectedItem(), 
                        tfLocal.getText(), 
                  cbTelTipoFixo.getSelectedItem(),
                     tfContato1.getText(),
                  cbTelTipoCel1.getSelectedItem(),
                         tfCel1.getText(),
                  cbTelTipoCel2.getSelectedItem(),
                         tfCel2.getText());*/
				
	});
		
		JButton btAnterior = new JButton("");
		btAnterior.setBounds(77, 8, 57, 45);
		btAnterior.setToolTipText("Registro anterior");
		btAnterior.setIcon(new ImageIcon(Contatos.class.getResource("/resources/images/Anterior.gif")));
		panelNavegacao.add(btAnterior);
		btAnterior.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				//ContatosDao cd = new ContatosDao();
				//cd.anteriorRegistro();
			}
		});
		
		JButton btProximo = new JButton("");
		btProximo.setBounds(144, 8, 57, 45);
		btProximo.setIcon(new ImageIcon(Contatos.class.getResource("/resources/images/Pr\u00F3ximo.gif")));
		btProximo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btProximo.setToolTipText("Pr\u00F3ximo registro");
		panelNavegacao.add(btProximo);
		btProximo.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				//ContatosDao cd = new ContatosDao();
				//cd.proximoRegistro();
			}
		});
		
		
		JButton btUltimo = new JButton("");
		btUltimo.setBounds(211, 8, 57, 45);
		btUltimo.setToolTipText("\u00DAltimo registro");
		btUltimo.setIcon(new ImageIcon(Contatos.class.getResource("/resources/images/\u00DAltimo.gif")));
		panelNavegacao.add(btUltimo);
		btUltimo.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent e) 
			{
				//ContatosDao cd = new ContatosDao();
				//cd.ultimoRegistro();
			}
		});
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 450, 895, 2);
		contentPane.add(separator);
		
		//Evento do botão sair
		btSair = new JButton("Sair");
		btSair.setIcon(new ImageIcon(Contatos.class.getResource("/resources/images/Sair.gif")));
		btSair.setBounds(710, 8, 125, 39);
		panelBotoes.add(btSair);
		btSair.setFont(new Font("Arial", Font.PLAIN, 20));
		btSair.addMouseListener(new MouseAdapter() 
		{
			public void mouseClicked(MouseEvent arg0) 
			{
				//ContatosDao cd = new ContatosDao();
				//cd.sairContatos();
				//mostrarDados();
			}
		});
	}
}



/*
 cd.mostrarContato(cbNome.getSelectedItem(), 
							                        tfLocal.getText(), 
							                  cbTelTipoFixo.getSelectedItem(),
							                     tfContato1.getText(),
							                  cbTelTipoCel1.getSelectedItem(),
							                         tfCel1.getText(),
							                  cbTelTipoCel2.getSelectedItem(),
							                         tfCel2.getText());
					
					//System.out.println(cbNome.getSelectedItem());
				    //System.out.println(tfLocal.getText());
				    //System.out.println(cbTelTipoFixo.getSelectedItem());
				    //System.out.println(tfContato1.getText());
				    //System.out.println(cbTelTipoCel1.getSelectedItem());
				    //System.out.println(tfCel1.getText());
				    //System.out.println(cbTelTipoCel2.getSelectedItem());
				    //System.out.println(tfCel2.getText());
				     * 
				     * 
				     * cb.mostrarContato(cbNome.setSelectedItem(cb.getNome()), 
                        tfLocal.setText(cb.getTipoLocal()), 
                  cbTelTipoFixo.setSelectedItem(cb.getTelTipoFixo()),
                     tfContato1.setText(cb.getTelefoneFixo()),
                  cbTelTipoCel1.setSelectedItem(cb.getTelTipoOperadora1()),
                         tfCel1.setText(cb.getTelCelular1()),
                  cbTelTipoCel2.setSelectedItem(cb.getTelTipoOperadora2()),
                         tfCel2.setText(cb.getTelCelular2()));
 */




