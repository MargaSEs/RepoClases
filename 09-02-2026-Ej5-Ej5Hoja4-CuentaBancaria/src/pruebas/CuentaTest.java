package pruebas;


import clases.Cuenta;
import clases.CuentaException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite; 

public class CuentaTest extends TestCase
{
	public CuentaTest(String p_nombre)
	{
		super(p_nombre);
	}
	
	private Cuenta cuenta;
	
	@Override
	protected void setUp() throws Exception
	{
		String dni = "00000000T";
		double saldo = 100.0;
		byte interes = 10;
		
		this.cuenta = new Cuenta(dni, saldo, interes);
	}
	
	@Override
	protected void tearDown() throws Exception
	{
		this.cuenta = null;
	}
	
	//Métodos de prueba
	public void testRetirar()
	{
		double dinero = 20.0;
		
		try 
		{
			this.cuenta.retirar(dinero);
			assertEquals(80.0, this.cuenta.getSaldo());
		} 
		catch (CuentaException e) 
		{
			fail("No debería lanzar una excepción");
			System.out.println(e.getMessage());
		}
	}
	
	
	public void testRetirarDineroNoDisponible()
	{
		double dinero = 110.0;
				
		try 
		{
			this.cuenta.retirar(dinero);
			fail("Debería lanzar una excepción");
		} 
		catch (CuentaException e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	public void testIngresar()
	{
		double dinero = 200.0;
		
		try
		{
			this.cuenta.ingresar(dinero);
			assertEquals(300.0, this.cuenta.getSaldo());
		} 
		catch (CuentaException e)
		{
			fail("No debería lanzar una excepción");
			System.out.println(e.getMessage());
		}		
	}
	
	public void testIngresarCantidadNegativa()
	{
		double dinero = -200.0;
		
		try
		{
			this.cuenta.ingresar(dinero);
			fail("Debería lanzar una excepción");
		} 
		catch (CuentaException e)
		{
			System.out.println(e.getMessage());
		}		
	}
	public void testActualizarSaldo()
	{
		try 
		{
			this.cuenta.actualizarSaldo();
			assertEquals(110.0, this.cuenta.getSaldo());
		} 
		catch (CuentaException e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	//Este método siempre hay que hacerlo igual
	//Indica los tests que deben ejecutarse
	public static Test conjuntoTest()
	{
		//- Indicamos que ejecute todos los tests de la clase CuentaTest
		//TestSuite ts = new TestSuite(CuentaTest.class); //usa la "reflexión"
		
		//- Indicar  que ejecute sólo los tests seleccionados
		//TestSuite implementa la interfaz de Test  (hereda de Test) 
		TestSuite ts = new TestSuite();
		
		ts.addTest(new CuentaTest("testRetirar")) ;
		ts.addTest(new CuentaTest("testRetirarDineroNoDisponible")) ;
		ts.addTest(new CuentaTest("testIngresar"));
		ts.addTest(new CuentaTest("testIngresarCantidadNegativa"));
		ts.addTest(new CuentaTest("testActualizarSaldo"));
				
		return ts;
	}
	
	public static void main(String args[])
	{
		Test t = conjuntoTest();
		
		junit.textui.TestRunner.run(t);
		
		//junit.textui.TestRunner.run(suite());
		
	}
}
