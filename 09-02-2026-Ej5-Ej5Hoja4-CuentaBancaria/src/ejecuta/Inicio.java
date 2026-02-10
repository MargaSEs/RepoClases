// Versión 2
package ejecuta;

import java.util.Scanner;

import clases.Cuenta;
import clases.CuentaException;

public class Inicio 
{

	public static void main(String[] args) 
	{
		// Declaramos las variables
		
		String menu = "MENU CUENTA\n"
					+ "-----------\n"
					+ "1. Abrir cuenta bancaria\n"
					+ "2. Ingresar dinero\n"
					+ "3. Retirar dinero\n"
					+ "4. Consultar saldo\n"
					+ "5. Liquidar saldo\n"
					+ "6. Salir\n"
					+ "Introduce una opción: ";
					
		Scanner sc = new Scanner(System.in);
		int opcion =  0;  //Si diera problemas este valor, podríamos ponerlo en los catch
		
		Cuenta cuenta1 = null; //Cuenta no inicializada
		
		double dinero;
		double dineroIngresado;
		
		final String MENSAJE = "No dispones de una cuenta bancaria. No se ha realizado la operación";
		
		do
		{
			try
			{
				System.out.println(menu);
				opcion = Integer.valueOf(sc.nextLine() );
				
				switch(opcion)
				{
					case 1:
						cuenta1 = new Cuenta();
						
						System.out.println("Introduce tu DNI: ");
						cuenta1.setDni(sc.nextLine());
						
						cuenta1.setSaldo(0.0);
						cuenta1.setInteres((byte)10);
						
						System.out.println("Enhorabuena, has abierto tu cuenta.");
						
					break;
						
					case 2:
						if (cuenta1 !=null)
						{
							System.out.println("Introduce la cantidad que deseas ingresar: ");
							dinero = Double.valueOf(sc.nextLine());
							dineroIngresado = cuenta1.ingresar(dinero);
							
							System.out.println("Confirmación: has ingresado " + dineroIngresado + " euros");
						}
						else
						{
							System.out.println();
						}
					break;
						
					case 3:
						if (cuenta1 !=null)
						{							System.out.println("Introduce la cantidad que deseas retirar: ");
							dinero =Double.valueOf(sc.nextLine());
							cuenta1.retirar(dinero);
							
							System.out.println("Dinero retirado con éxito. Su saldo es " + cuenta1.getSaldo() + "€");
						}
						else
						{
							System.out.println(MENSAJE);
						}
					break;
					
					case 4:
						if (cuenta1 !=null)
						{
							dinero = cuenta1.getSaldo();
							System.out.println("El saldo es " + dinero + "€");
						}
						else
						{
							System.out.println(MENSAJE);
						}
					break;
						
					case 5:
						if (cuenta1 !=null)
						{
							cuenta1.actualizarSaldo();
							System.out.println("Confirmación: Intereses anuales liquidados.");
							System.out.println("Su saldo es de " + cuenta1.getSaldo() + "€");
						}
						else
						{
							System.out.println(MENSAJE);
						}
					break;
	
					case 6:
						System.out.println("Gracias. Hasta pronto");
					break;
	
					default:
						System.out.println(MENSAJE);
				
				}

			}
			catch (NumberFormatException e)
			{
				System.out.println("La opción del menú debe ser numérica");
			}
			catch (CuentaException e)
			{
				System.out.println(e.getMessage());
			}
			catch (Exception e)
			{
				System.out.println("Esto no debería estar pasando. Si sucede de nuevo, contacte con el administrador");
			}
			
		}while (opcion != 6);
		
		/*
		try 
		{
			cuenta1 = new Cuenta("12345678Z", 100.0D,(byte) 3);
			
			cuenta1.ingresar(1000.00);
			cuenta1.retirar(1200.00);
			
			System.out.println("El saldo en la cuenta es " + cuenta1.getSaldo());
		} 
		catch (CuentaException e)
		{
			System.out.println(e.getMessage());
		}*/
		
		System.out.println("FIN");
		
		sc.close();
	}

}
