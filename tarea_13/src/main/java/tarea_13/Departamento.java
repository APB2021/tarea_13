package tarea_13;

public class Departamento {
    private int deptNo;
    private String dnombre;
    private String localidad;

    public Departamento(int deptNo, String dnombre, String localidad) {
        this.deptNo = deptNo;
        this.dnombre = dnombre;
        this.localidad = localidad;
    }

    // Getters y setters
    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
}
