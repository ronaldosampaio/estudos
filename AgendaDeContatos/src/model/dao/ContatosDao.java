package model.dao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import conexão.ConectaBanco;
import model.bean.ContatoBean;

public class ContatosDao 
{
	ConectaBanco cb = new ConectaBanco();
	ContatoBean cBean = new ContatoBean();
	Connection conn ;
	PreparedStatement pstm;
	ResultSet rs;
	
	
	public ContatoBean doContatos()//(Object nome, String tipoLocal, Object telTipoFixo, String telefoneFixo, Object telTipoOperadora1, String telCelular1, Object telTipoOperadora2, String telCelular2) throws SQLException  
    {  
		ContatoBean contato =null;
        try  
        {  
        	contato = new ContatoBean();
            conn = cb.conecta();  
            pstm=conn.prepareStatement("select * from Contato");  
            rs =pstm.executeQuery();  
              
                while(rs.next())  
                {  
                      
                  
                contato.setId(rs.getInt(1));  
                contato.setNome(rs.getObject(2));  
                contato.setTipoLocal(rs.getString("Tipo_Local"));  
                contato.setTelTipoFixo(rs.getString("TelTipoFixo"));  
                contato.setTelefoneFixo(rs.getString("Telefone_fixo"));   
                contato.setTelTipoOperadora1(rs.getString("Tel_Tipo_Operadora1"));   
                contato.setTelCelular1(rs.getString("Telefone_Celular1"));     
                contato.setTelTipoOperadora2(rs.getString("Tel_Tipo_Operadora2"));     
                contato.setTelCelular2(rs.getString("Telefone_Celular2"));  
                  
             
             
                //rs.close();  
                //pstm.close();  
                }  
           }    
            catch(SQLException erro)  
            {  
                  
            }  
            return contato;  
    }
	public String excluirContato(int id,Object nome,String tipoLocal,Object telTipoFixo,String telefoneFixo,
	Object telTipoOperadora1,String telCelular1,Object telTipoOperadora2,String telCelular2)throws SQLException
	
	{
		String retorno=null;
		int excluir = JOptionPane.showConfirmDialog(null,"Você deseja exluir contato?","Excluir",JOptionPane.YES_NO_OPTION);
		if(excluir == JOptionPane.YES_OPTION)
		try
		{
			conn = cb.conecta();
			pstm = conn.prepareStatement("delete Contato where idjdjkjkd = ? and Nome =? ");
			pstm.setInt(1, id);
			pstm.setObject(2, nome);
			
			pstm.executeUpdate();
			retorno ="Excluido com sucesso";
		}
		catch(SQLException erro)
		{
			throw new SQLException("error cod"+String.valueOf(erro.getErrorCode()));
		}
		
		return retorno;
		
	}
	
	
	
	public ContatoBean nextContatos()//(Object nome, String tipoLocal, Object telTipoFixo, String telefoneFixo, Object telTipoOperadora1, String telCelular1, Object telTipoOperadora2, String telCelular2) throws SQLException  
    {  
		ContatoBean contato =null;
        try  
        {  
        	contato = new ContatoBean();
            conn = cb.conecta();  
            pstm=conn.prepareStatement("select * from Contato");  
            rs =pstm.executeQuery();  
              
                while(rs.next())  
                {  
                      
                  
                contato.setId(rs.getInt(1));  
                contato.setNome(rs.getObject(2));  
                contato.setTipoLocal(rs.getString("Tipo_Local"));  
                contato.setTelTipoFixo(rs.getString("TelTipoFixo"));  
                contato.setTelefoneFixo(rs.getString("Telefone_fixo"));   
                contato.setTelTipoOperadora1(rs.getString("Tel_Tipo_Operadora1"));   
                contato.setTelCelular1(rs.getString("Telefone_Celular1"));     
                contato.setTelTipoOperadora2(rs.getString("Tel_Tipo_Operadora2"));     
                contato.setTelCelular2(rs.getString("Telefone_Celular2"));  
                  
             
             
                //rs.close();  
                //pstm.close();  
                }  
           }    
            catch(SQLException erro)  
            {  
                  
            }  
            return contato;  
    }

}

/*
   Nome
   Tipo_Local  
   TelTipoFixo
   Telefone_fixo  
   Tel_Tipo_Operadora1   
   Telefone_Celular1
   Tel_Tipo_Operadora2 
   Telefone_Celular2
   Data_gravada
   Data_alterada
 */
 
