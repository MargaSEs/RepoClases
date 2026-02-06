package clases;

public class Ecuacion 
{
	// Constructores
	// -------------
	public Ecuacion()
	{
		
	}
	
	public Ecuacion(int p_varA, int p_varB, int p_varC)
	{
		this.varA = p_varA;
		this.varB = p_varB;
		this.varC = p_varC;
	}

	// Campos
	// ------
	public int varA;
	public int varB;
	public int varC;
	
	// Métodos
	// -------
	public double[] MetodoGrado2() throws Exception
	{
		double[] solucion = new double[2];
		
		double discriminante;
		int denominador;	
		
		discriminante = Math.pow(this.varB, 2.0) - 4 * this.varA * this.varC;
		denominador = 2 * this.varA;
		
		if (discriminante < 0)
		{
			throw new Exception("La ecuación no tiene solución. El discriminante no puede ser negativo");
		}

		if (denominador ==  0)
		{
			throw new Exception("No hay solución. El denominador no puede ser cero.");
		}
		
		solucion[0] = (-this.varB + Math.sqrt(discriminante) )/ denominador;
		solucion[1] = (-this.varB - Math.sqrt(discriminante) )/ denominador;
		
		return solucion; 
	}
}
