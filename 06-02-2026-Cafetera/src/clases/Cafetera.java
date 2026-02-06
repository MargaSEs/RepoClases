package clases;

import java.util.concurrent.CancellationException;

public class Cafetera 
{
	public Cafetera(int capacidadTotal, int capacidadRestante, int volumenTaza, int volumenVaso) throws CafeteraException
	{
		setCapacidadTotal(capacidadTotal);
		setCapacidadRestante(capacidadRestante);
		setVolumenTaza(volumenTaza);
		setVolumenVaso(volumenVaso);
		
		// La cafetera se encuentra apagada
		setEstado(false);
		
	}
	
	private int capacidadTotal;
	private int capacidadRestante;
	private int volumenTaza;
	private int volumenVaso;		// cantidad de agua que cabe en un vaso
	private boolean estado; 		// indica si la cafetera está encendida o apagada
	
	public String servirTaza() throws CafeteraException
	{
		// Validamos
		
		// Comprobamos que la cafetera esté encendida
		if (getEstado() == false)	
		{
			throw new CafeteraException("La cafetera está apagada. No se pueden servir tazas");
			
		}
		// Comprobamos que quede suficiente agua
		else if (getCapacidadRestante() < getVolumenTaza())
		{
			throw new CafeteraException("No queda suficiente agua. No se ha servido la taza");
				
		}
		// Si todo es correcto servimos la taza
		else
		{
			setCapacidadRestante(getCapacidadRestante() - getVolumenTaza());
			//System.out.println("Taza servida");
			
			//this.capacidadRestante= this.volumenTaza - this.volumenTaza;
			//capacidadRestante = capacidadRestante - volumenTaza;
		}
		
		return "Taza servida";
	}

	
	public String servirVaso() throws CafeteraException
	{
		// Validamos
		
		// Comprobamos que la cafetera esté encendida
		if (getEstado() == false)	
		{
			throw new CafeteraException("La cafetera está apagada. No se pueden servir vasos");
			
		}
		// Comprobamos que quede suficiente agua
		else if (getCapacidadRestante() < getVolumenVaso())
		{
			throw new CafeteraException("No queda suficiente agua. No se ha servido el vaso");
				
		}
		// Si todo es correcto servimos el vaso
		else
		{
			setCapacidadRestante(getCapacidadRestante() - getVolumenVaso());
			//System.out.println("Vaso servido");
			
			//this.capacidadRestante= this.volumenTaza - this.volumenTaza;
			//capacidadRestante = capacidadRestante - volumenTaza;
		}
		
		return "Vaso servido";
	}
	
	public void encender()
	{
		setEstado(true);
	}
	
	public void apagar()
	{
		setEstado(false);
	}
	
	public void rellenar() throws CafeteraException  //Este error nunca se va a producir
	{
		setCapacidadRestante(getCapacidadTotal());
		
	}
	
	public String mostrarCapacidad()
	{
		return "Queda(n) " + getCapacidadRestante()  + " ml de agua";
	}
	
	// Getters y setters
	
	public int getCapacidadTotal() {
		return capacidadTotal;
	}

	public void setCapacidadTotal(int capacidadTotal) {
		this.capacidadTotal = capacidadTotal;
	}

	public int getCapacidadRestante() {
		return capacidadRestante;
	}

	public void setCapacidadRestante(int capacidadRestante) throws CafeteraException {
		if (capacidadRestante > getCapacidadTotal())
		{
			throw new CafeteraException("Campo CAPACIDAD RESTANTE incorrecto. No puede superar la capacidad de la cafetera");
		}
		else 
		{
			this.capacidadRestante = capacidadRestante;
		}
	}

	public int getVolumenTaza() {
		return volumenTaza;
	}

	public void setVolumenTaza(int volumentTaza) {
		this.volumenTaza = volumentTaza;
	}

	public int getVolumenVaso() {
		return volumenVaso;
	}

	public void setVolumenVaso(int volumenVaso) {
		this.volumenVaso = volumenVaso;
	}


	public boolean getEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {	 //true: encender   false:apagar
		this.estado = estado;
	}
	
	
}
