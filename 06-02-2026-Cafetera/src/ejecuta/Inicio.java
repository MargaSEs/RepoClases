package ejecuta;


import java.util.Scanner;
import clases.Cafetera;
import clases.CafeteraException;

public class Inicio 
{

	public static void main(String[] args) 
	{
		/*try {
			Cafetera c = new Cafetera(0,10,0,0);
		} 
		catch (CafeteraException e) 
		{
			System.out.println(e.detalleError());
		}*/
		
		// Declaramos las variables
		Cafetera miCafetera;
		
		String menu = "MENU\n"
				+ "1. Encender\n"
				+ "2. Apagar\n"
				+ "3. Servir taza\n"
				+ "4. Servir vaso\n"
				+ "5. Rellenar\n"
				+ "6. Mostrar agua restante\n"
				+ "7. Salir\n"
				+ "Introduce opción: ";
		
		int opcion = 0;
		String mensaje;
		Scanner sc = new Scanner(System.in);
		
		try
		{
			miCafetera = new Cafetera(1000,1000,100,250);
		
			do
			{
				try
				{
					System.out.println(menu);
					opcion = sc.nextInt();
					
					switch(opcion)
					{
						case 1:		//encender
							miCafetera.encender();
							break;
						
						case 2:		//apagar
							miCafetera.apagar();
							break;
						
						case 3:		//servir taza
							mensaje = miCafetera.servirTaza();
							System.out.println(mensaje);
							break;
						
						case 4:		//servir vaso
							mensaje = miCafetera.servirVaso();
							System.out.println(mensaje);
							break;
							
						case 5:		//rellenar
							miCafetera.rellenar();
							break;
							
						case 6:		//mostrar agua restante
							mensaje = miCafetera.mostrarCapacidad();
							System.out.println(mensaje);
							break;
							
						case 7:
							System.out.println("¡Hasta pronto!");
							break;
							
						default:
							System.out.println("Opción incorrecta");
					}
				}
				catch(CafeteraException e)
				{
					//System.out.println(e.getMessage()); //Con e.getMessage sólo muestra el mensaje de error
					
					System.out.println(e);  //Con e muestra el mensaje de error y la clase
				}	
			}while(opcion != 7);

				
				
			
		} catch (CafeteraException e)
		{
			System.out.println(e.getMessage()); 
			
		}
		
		System.out.println("FIN");
		
		sc.close();
	}

}
