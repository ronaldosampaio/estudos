package model.bean;
import java.sql.Date;

public class ContatoBean 
{
	public int id;
	public Object nome; 
	public String tipoLocal;
	public String telTipoFixo; 
	public String telefoneFixo; 
	public String telTipoOperadora1;
	public String telCelular1; 
	public String telTipoOperadora2;
	public String telCelular2; 
	public Date dataGravada;
	public Date dataAlterada;
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public Object getNome()
	{
		return nome;
	}
	public void setNome(Object nome)
	{
		this.nome = nome;
	}
	public String getTipoLocal()
	{
	    return tipoLocal;
	}
	public void setTipoLocal(String tipoLocal)
	{
		this.tipoLocal = tipoLocal;
	}
	public String getTelTipoFixo()
	{
		return telTipoFixo;
	}
	public void setTelTipoFixo(String telTipoFixo)
	{
		this.telTipoFixo = telTipoFixo;
	}
	public String getTelefoneFixo()
	{
		return telefoneFixo;
	}
	public void setTelefoneFixo(String telefoneFixo)
	{
		this.telefoneFixo = telefoneFixo;
	}
	public String getTelTipoOperadora1()
	{
		return telTipoOperadora1;
	}
	public void setTelTipoOperadora1(String telTipoOperadora1)
	{
		this.telTipoOperadora1 = telTipoOperadora1;
	}
	public String getTelCelular1()
	{
		return telCelular1;
	}
	public void setTelCelular1(String telCelular1)
	{
		this.telCelular1 = telCelular1;
	}
	public String getTelTipoOperadora2()
	{
	    return telTipoOperadora2;
	}
	public void setTelTipoOperadora2(String telTipoOperadora2)
	{
		this.telTipoOperadora2 = telTipoOperadora2;
	}
	public String getTelCelular2()
	{
		return telCelular2;
	}
	public void setTelCelular2(String telCelular2)
	{
		this.telCelular2 = telCelular2;
	}
	public Date getDataGravada() 
	{
		return dataGravada;
	}
	public void setDataGravada(Date dataGravada) 
	{
		this.dataGravada = dataGravada;
	}
	
	public Date getDataAlterada() 
	{
		return dataAlterada;
	}
	public void setDataAlterada(Date dataAlterada) 
	{
		this.dataAlterada = dataAlterada;
	}
	@Override
	public String toString() 
	{
		return "ContatoBean [id=" + id + ", nome=" + nome + ", tipoLocal="
				+ tipoLocal + ", telTipoFixo=" + telTipoFixo
				+ ", telefoneFixo=" + telefoneFixo + ", telTipoOperadora1="
				+ telTipoOperadora1 + ", telCelular1=" + telCelular1
				+ ", telTipoOperadora2=" + telTipoOperadora2 + ", telCelular2="
				+ telCelular2 + ", dataGravada=" + dataGravada
				+ ", dataAlterada=" + dataAlterada + "]";
	}
}
