package conexão;

import javax.swing.*;
import java.sql.*;
public class ConexaoBanco
{
  String driver = "net.sourceforge.jtds.jdbc.Driver";
  String url = "jdbc:jtds:sqlserver://localhost:1433/ronaldo";
  //String url = "jdbc:jtds:sqlserver://SERVIDORHRTECH:1433/ronaldo";
  String usuario = "sa";
  //String senha = "TECH";
  String senha = "levita";
  private Connection con;
  public Statement stm;
  public ResultSet rs;
  public CallableStatement call;

    public void conecta()
    {
      try
      {
        Class.forName(driver);
        con = DriverManager.getConnection(url, usuario, senha);
        JOptionPane.showMessageDialog(null,"Conectado!!!");
        //JOptionPane.showMessageDialog(null,"Conexão concluida com sucesso!!!");
      }
        catch(ClassNotFoundException drive)
        {
           JOptionPane.showMessageDialog(null,"Driver não localizado"+drive);

        }
           catch(SQLException Fonte)
           {
              JOptionPane.showMessageDialog(null,"Erro no comando com fonte de dados"+Fonte);

           }
    }


    public void executeSQL(String sql)
    {
          try
          {
            stm =con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);                            
          }
            catch(SQLException ex)
            {
              JOptionPane.showMessageDialog(null,"Driver não localizado"+ex);
            }
         // return rs;
        }
}
