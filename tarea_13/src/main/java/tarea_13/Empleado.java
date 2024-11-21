package tarea_13;

public class Empleado {

	private int emplNo;
	private String apellido;
	private String puesto;
	private String fechaAlta;
	private double salario;
	private double variable;
	private int dept;

	public Empleado(int emplNo, String apellido, String puesto, String fechaAlta, double salario, double variable,
			int dept) {
		this.emplNo = emplNo;
		this.apellido = apellido;
		this.puesto = puesto;
		this.fechaAlta = fechaAlta;
		this.salario = salario;
		this.variable = variable;
		this.dept = dept;
	}

	// Getters y setters
	public int getEmplNo() {
		return emplNo;
	}

	public void setEmplNo(int emplNo) {
		this.emplNo = emplNo;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public double getVariable() {
		return variable;
	}

	public void setVariable(double variable) {
		this.variable = variable;
	}

	public int getDept() {
		return dept;
	}

	public void setDept(int dept) {
		this.dept = dept;
	}
}
