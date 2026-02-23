package aplicacion.viewmodels;

public class DepartamentosDesplegable 
{
	public DepartamentosDesplegable()
	{
		
	}
	
	public DepartamentosDesplegable(Byte deptNo, String dnombre)
	{
		this.deptNo = deptNo;
		this.dnombre = dnombre;
	}
	
	private Byte deptNo;
	private String dnombre;
	
	public Byte getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(Byte deptNo) {
		this.deptNo = deptNo;
	}

	public String getDnombre() {
		return dnombre;
	}

	public void setDnombre(String dnombre) {
		this.dnombre = dnombre;
	}
	
	
	
}
