package aplicacion.viewmodels;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hibernate.entidades.ThDepartamento;
import hibernate.entidades.ThEmpleado;

public class EmpleadoViewModel 
{
	// ==========================
	//Campos de la tabla Empleado
	// ==========================
	private Short empNo;  	//PK
	private Byte deptNo;	//FK
	private String apellido;
	private String oficio;
	private Short dir;
	private Date fechaAlt;
	private BigDecimal salario;
	private BigDecimal comision;

	//Campos de la tabla Departamento
	private String dnombre;
	private String loc;
	
	// Otros campos (relación de la tabla Empleado consigo misma)
	private String apellidoDirector;
	
	// Campo para el desplegable de los departamentos
	List<DepartamentosDesplegable> lsDepartamentos;

	// =======
	// Métodos
	// =======
	// - Mapeo desde la entidad hacia el modelo
	public static EmpleadoViewModel entidadToModelo(ThEmpleado entidad, ThEmpleado entidadDirector , List<ThDepartamento> lsEntidades)
	{
		EmpleadoViewModel modelo = new EmpleadoViewModel();
		List<DepartamentosDesplegable> lsDepartamentos;
		DepartamentosDesplegable item;
		
		// Datos del empleado
		modelo.setEmpNo(entidad.getEmpNo());
		modelo.setDeptNo(entidad.getThDepartamento().getDeptNo());
		modelo.setApellido(entidad.getApellido());
		modelo.setOficio(entidad.getOficio());
		modelo.setDir(entidad.getDir());
		modelo.setFechaAlt(entidad.getFechaAlt());
		modelo.setSalario(entidad.getSalario());
		modelo.setComision(entidad.getComision());
		
		// Datos de su departamento
		modelo.setDnombre(entidad.getThDepartamento().getDnombre());
		modelo.setLoc(entidad.getThDepartamento().getLoc());
		
		// Desplegable con los departamentos
		lsDepartamentos = new ArrayList<DepartamentosDesplegable>();
		
		// Otros campos
		modelo.setApellidoDirector(entidadDirector.getApellido());
				
		for(ThDepartamento d: lsEntidades)
		{
			item = new DepartamentosDesplegable(d.getDeptNo(), d.getDnombre());
			lsDepartamentos.add(item);
		}
		modelo.setLsDepartamentos(lsDepartamentos);
		 
		return modelo;
	}
	
	// - Mapeo desde el modelo hacia la entidad
	public static ThEmpleado modeloToEntidad(EmpleadoViewModel modelo)
	{
		ThEmpleado entidad = new ThEmpleado();
		ThDepartamento entidadDepartamento;
		
		entidad.setEmpNo(modelo.getEmpNo());
		entidad.setApellido(modelo.getApellido());
		entidad.setOficio(modelo.getOficio());
		entidad.setDir(modelo.getDir());
		entidad.setFechaAlt(modelo.getFechaAlt());
		entidad.setSalario(modelo.getSalario());
		entidad.setComision(modelo.getComision());
		
		entidadDepartamento = new ThDepartamento();
		entidadDepartamento.setDeptNo(modelo.getDeptNo());
		
		entidad.setThDepartamento(entidadDepartamento);
		
		return entidad;
	}
	
	// Getters y setters
	public Short getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Short empNo) {
		this.empNo = empNo;
	}

	public Byte getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Byte deptNo) {
		this.deptNo = deptNo;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getOficio() {
		return oficio;
	}

	public void setOficio(String oficio) {
		this.oficio = oficio;
	}

	public Short getDir() {
		return dir;
	}

	public void setDir(Short dir) {
		this.dir = dir;
	}

	public Date getFechaAlt() {
		return fechaAlt;
	}

	public void setFechaAlt(Date fechaAlt) {
		this.fechaAlt = fechaAlt;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public BigDecimal getComision() {
		return comision;
	}

	public void setComision(BigDecimal comision) {
		this.comision = comision;
	}

	public String getDnombre() {
		return dnombre;
	}

	public void setDnombre(String dnombre) {
		this.dnombre = dnombre;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public List<DepartamentosDesplegable> getLsDepartamentos() {
		return lsDepartamentos;
	}

	public void setLsDepartamentos(List<DepartamentosDesplegable> lsDepartamentos) {
		this.lsDepartamentos = lsDepartamentos;
	}

	public String getApellidoDirector() {
		return apellidoDirector;
	}

	public void setApellidoDirector(String apellidoDirector) {
		this.apellidoDirector = apellidoDirector;
	}
	
	
}
