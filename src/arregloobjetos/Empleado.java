// JUAN JESUS ESQUIVES ZAPATA

package arregloobjetos;

public class Empleado {

    public String codigo;
    public String nombres;
    public String areaLaboral;
    public double sueldo;
    public int horasExtra;
    public String tipoAfiliacion;

    public Empleado() {
    }

    public Empleado(String codigo, String nombres, String areaLaboral, double sueldo, int horasExtra, String tipoAfiliacion) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.areaLaboral = areaLaboral;
        this.sueldo = sueldo;
        this.horasExtra = horasExtra;
        this.tipoAfiliacion = tipoAfiliacion;
    }

    public double montoHExtras() {
        return sueldo * horasExtra / 240;
    }

    public double montoSeguro() {
        if(tipoAfiliacion.equalsIgnoreCase("AFP"))
            return sueldo * 0.17;
        if(tipoAfiliacion.equalsIgnoreCase("SNP"))
            return sueldo * 0.05;
        return 0;
    }

    public double montoEsSalud() {
        return sueldo * 0.03;
    }

    public double montoDescuentos() {
        return montoSeguro() + montoEsSalud();
    }

    public double sueldoBruto() {
        return sueldo + montoHExtras();
    }

    public double sueldoNeto() {
        return sueldoBruto() - montoDescuentos();
    }
}
