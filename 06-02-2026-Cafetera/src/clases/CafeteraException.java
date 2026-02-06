package clases;

import java.io.StringWriter;
import java.io.PrintWriter;

@SuppressWarnings("serial")
public class CafeteraException extends Exception
{
	public CafeteraException(String p_mensaje)
	{
		super(p_mensaje);
	}
	
	public String detalleError()
	{
		StringWriter sw = new StringWriter();
		
		this.printStackTrace(new PrintWriter(sw));
		String cadena = sw.toString();
		
		return cadena;
	}
	
	public void escribirEnFichero()
	{
		//Instrucciones para añadir texto al log de errores
	}
}
