package conexão;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConectaBanco 
{
	public String driver   = "net.sourceforge.jtds.jdbc.Driver";
	public String url      = "jdbc:jtds:sqlserver://localhost:1433/ronaldo";
	private String usuario = "sa";
	private String senha   = "levita";
	
	public Connection conecta()
	{
		Connection con =null;
		try
		{
			Class.forName(driver);
			con=DriverManager.getConnection(url,usuario,senha);
			//JOptionPane.showMessageDialog(null,"Conectado!!!");
		}
		catch(ClassNotFoundException erro)
		{
			JOptionPane.showMessageDialog(null, "Erro ao executar driver sql" +erro);
		}
		catch(SQLException erro)
		{
			JOptionPane.showMessageDialog(null,"Erro ao verificar dados do banco sql" +erro);
		}
		return con;
	}

}
