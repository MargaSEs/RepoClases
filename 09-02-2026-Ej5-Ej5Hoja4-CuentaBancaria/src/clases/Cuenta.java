package clases;

public class Cuenta 
{
	public Cuenta() throws CuentaException
	{
		this("",0D, (byte)0);	
	}
	
	public Cuenta(String p_dni, double p_saldo, byte p_interes) throws CuentaException
	{
		this.numCuenta = Cuenta.numeroCuenta;
		Cuenta.numeroCuenta++;  //es autoincremental
		
		setDni(p_dni);
		setSaldo(p_saldo);
		setInteres(p_interes);
	}
	
	private static int numeroCuenta = 100001; //es estático. Se comparte en todos los objetos
	
	// Campos
	// ------
	private long numCuenta;
	public String dni;
	public double saldo;
	public byte interes;


	// Métodos
	// -------

	
	// Métodos de instancia de esta clase
	// -------
	
	public void actualizarSaldo() throws CuentaException
	{
		double intereses;
		
		intereses = getSaldo() * getInteres() / 100;
		
		setSaldo(getSaldo() + intereses);
		
	}
	
	public double ingresar(double p_cantidad) throws CuentaException
	{
		if (p_cantidad >= 0)
		{
			setSaldo (getSaldo() + p_cantidad);
		}
		else
		{
			throw new CuentaException("No se ha ingresado el dinero. La cantidad debe ser un valor positivo");
		}
		return p_cantidad;
	}
	
	public void retirar(double p_cantidad) throws CuentaException
	{
		if (getSaldo() >= p_cantidad)
		{
			// Actualizar saldo
			setSaldo(getSaldo() - p_cantidad);
		}
		else
		{
			throw new CuentaException("No se puede retirar el dinero. No hay saldo suficiente");
		}

	}
	
	private boolean validarDni(String p_dni)
	{
		boolean ok = true;
		String cadena = "TRWAGMYFPDXBNJZSQVHLCKE";
		
		char letraOk;
		char letraUsuario;
		int posicion;
		int numeroSinLetra;
		
		//Validamos el DNI
		if (p_dni.length() != 9)
		{
			ok=false;
		}
		else
		{
			letraUsuario = p_dni.toUpperCase().charAt(8);  //20805000A
			
			//posicion = cadena.indexOf(letraUsuario);
			numeroSinLetra = Integer.valueOf(p_dni.substring(0, p_dni.length()-1));
			posicion = numeroSinLetra % cadena.length();
			
			if (posicion== -1)
			{
				ok= false;
			}
			else
			{
				letraOk = cadena.charAt(posicion);
				if (letraOk != letraUsuario)
				{
					ok= false;
				}
			}
		}
		
		return ok;
	}
	
	@Override
	public String toString() 
	{
		return "NUM. CUENTA: " + getNumCuenta() + "\n"
				+ "SALDO: " + getSaldo() + "\n"
				+ "INTERES: " + getInteres() + "\n";
  	}
	
	// Getters y setters
	public long getNumCuenta()
	{
		return this.numCuenta;
	}
	
	public String getDni()
	{
		return this.dni;
	}
	
	public void setDni(String p_dni) throws CuentaException
	{
		
		//Si es correcto guardamos el dato en el campo
		if (p_dni.equals("") || validarDni(p_dni) == true)
		{
			this.dni = p_dni;
		}
		else	//Si es incorrecto lanzamos una excepción
		{
			throw new CuentaException("DNI incorrecto");
		}
		
	}
	
	public double getSaldo()
	{
		return this.saldo;
	}
	public void setSaldo(double p_saldo) throws CuentaException
	{
		//Esta cuenta bancaria no admite saldo negativo
		if (p_saldo >= 0)
		{
			this.saldo = p_saldo;
		}
		else
		{
			throw new CuentaException("El saldo inicial de la cuenta no puede ser negtivo");
		}
		
	}
	
	public byte getInteres()
	{
		return this.interes;
	}
	
	public void setInteres(byte p_interes)
	{
		this.interes = p_interes;
	}

}