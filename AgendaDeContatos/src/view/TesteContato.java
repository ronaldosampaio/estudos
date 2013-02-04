package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JComboBox;

import conexão.ConectaBanco;
import conexão.ConexaoBanco;

public class TesteContato extends JFrame {

	private JPanel contentPane;
	JComboBox cbNome;
	ConexaoBanco obj_conexao = new ConexaoBanco();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TesteContato frame = new TesteContato();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void mostrarDados() 
	{
		
		try 
		{
			cbNome.addItem(obj_conexao.rs.getString("Nome"));
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public TesteContato() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		obj_conexao.conecta();
		obj_conexao.executeSQL("select * from Contato");
		obj_conexao.rs.first();
		
		
		
		cbNome = new JComboBox();
		cbNome.setBounds(10, 11, 331, 20);
		contentPane.add(cbNome);
		
		mostrarDados();
		//System.out.println(obj_conexao.rs.next());
		
		
		
	}
}
