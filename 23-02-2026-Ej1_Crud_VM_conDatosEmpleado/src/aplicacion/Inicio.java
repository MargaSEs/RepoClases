package aplicacion;

import java.util.List;

import aplicacion.viewmodels.DepartamentosDesplegable;
import aplicacion.viewmodels.EmpleadoViewModel;
import hibernate.entidades.ThDepartamento;
import hibernate.entidades.ThEmpleado;
import hibernate.repositorios.ThDepartamentoRepositorio;
import hibernate.repositorios.ThEmpleadoRepositorio;

public class Inicio
{

	public static void main(String[] args) 
	{
		// Repositorios
		ThEmpleadoRepositorio repoEmple;
		ThDepartamentoRepositorio repoDepart;
		
		// Entidades
		ThEmpleado entidadEmpleado;				// contiene un registro de la tabla THEmpleado con los datos del empleado
		ThEmpleado entidadDirector; 	// contiene un registro de la tabla THEmpleado con los datos del director del empleado
		List<ThDepartamento> lsEntidadesDepartamento; 	// contiene todos los registros de la tabla THDepartamento para  poblar el desplegable
		
		// Modelo
		EmpleadoViewModel modelo;
		
		// Campos PK
		short empNo = 7521;
		
		String cadena;
		// Poblamos las entidades con la información de la BB.DD
		// Utilizamos los repositorios
		repoEmple = new ThEmpleadoRepositorio();
		entidadEmpleado = repoEmple.leer(empNo);
		entidadDirector = repoEmple.leer(entidadEmpleado.getDir());
				
		repoDepart = new ThDepartamentoRepositorio();
		lsEntidadesDepartamento = repoDepart.listar();
		
		// Poblamos el modelo de las entidades
		modelo = EmpleadoViewModel.entidadToModelo(entidadEmpleado, entidadDirector, lsEntidadesDepartamento);
		
		// Imprimimos
		cadena = "DATOS DEL EMPLEADO: \n"
				+ "EMPNO: " + modelo.getEmpNo() + ", DEPTNO: " + modelo.getDeptNo() 
				+ ", APELLIDO: " + modelo.getApellido()  + ", OFICIO: " + modelo.getOficio() 
				+ ", DIRECTOR: " + modelo.getDir() + " " + modelo.getApellidoDirector()
				+ ", FECHA ALTA: " + modelo.getFechaAlt() 
				+ ", SALARIO: " + modelo.getSalario() + ", COMISION: " + modelo.getComision() + "\n" ;
		
		cadena += "DATOS DE SU DEPARTAMENTO: \n"
				+ "DNOMBRE: " + modelo.getDnombre() + ". LOCALIDAD: " + modelo.getLoc() + "\n";		

		cadena += "DEPARTAMENTOS PARA EL DESPLEGBLE: \n";
		
		for(DepartamentosDesplegable item: modelo.getLsDepartamentos())
		{
			cadena += "\tDEPTNO: " + item.getDeptNo() + ", DNOMRE: " + item.getDnombre() + "\n";
		}
			
		System.out.println(cadena);
		
		/*
		ThEmpleadoRepositorio repo = new ThEmpleadoRepositorio();
		ThEmpleado empleado1 = new ThEmpleado();
		
		empleado1 = repo.leer((short)10); //Esto garantiza que la variable está acoplada, tiene los datos de la BD
		
		empleado1.setEmpNo((short)10);
		
		repo.eliminarEntidad(empleado1);*/
		
		
	}

}
