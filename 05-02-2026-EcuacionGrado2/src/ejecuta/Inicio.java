package ejecuta;

import java.util.Scanner;
import clases.Ecuacion;

public class Inicio 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Ecuacion ecu;
		
		int numA, numB, numC; 
		double[] solucion;
		
		System.out.println("Resolución de ecuaciones de 2º grado (ax2+bx+c=0)\n");
		
		System.out.println("Introduce la variable a:");
		numA = sc.nextInt();
		System.out.println("Introduce la variable b:");
		numB = sc.nextInt();
		System.out.println("Introduce la variable c:");
		numC = sc.nextInt();
		
		ecu = new Ecuacion(numA, numB, numC);
		try 
		{
			solucion = ecu.MetodoGrado2();
			
			System.out.println("Las soluciones son " 
					+ Math.round(solucion[0] * 100.0) / 100.0  + ", " 
					+ Math.round(solucion[1] * 100.0) / 100.0);
			
		} catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
		
		System.out.println("FIN");
		
		sc.close();
	}

}
