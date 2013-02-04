package controller;

import java.io.IOException;
import java.sql.SQLException;

import model.bean.ContatoBean;
import model.dao.ContatosDao;


public class ContatoControle 

{
public String excluir(int codigo,String str2,String str3,String str4,String str5,String str6,String str7,String str8,String str9)
{String msg=null;
	if(codigo==0){
		return msg="Codigo não existe";
	}
	
	
	ContatosDao dao = new ContatosDao();
	try 
	{
		msg=dao.excluirContato(codigo,str2,str3,str4,str5,str6,str7,str8, str9);
	} catch (SQLException e) 
	{
		System.out.println(e.getMessage());
		msg=e.getMessage();
	}
	
return msg;	
}
public ContatoBean getContatos(){
	try {
		
	} catch (NullPointerException e) {
		// TODO: handle exception
	}catch (IllegalArgumentException e) {
		// TODO: handle exception
	}
	ContatosDao dao = new ContatosDao();
	ContatoBean bean = new ContatoBean();
	return bean=dao.doContatos();
	
}
}