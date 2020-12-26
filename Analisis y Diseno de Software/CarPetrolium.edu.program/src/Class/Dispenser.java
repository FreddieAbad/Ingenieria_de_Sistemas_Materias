package Class;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Dispenser {
 
    ServiceStation gasolinera;
    private String fecha;
    private List<EmployeeServiceStation> empleados;
    private List<saleServiceStation> venta;
    public List<Fuel> combustible;

    public Dispenser(ServiceStation gasolinera, String fecha) {
        if(gasolinera == null)
            throw new IllegalArgumentException("EL SERVICIO QUE BRINDA NO HA SIDO IDENTIFICADO");
        if(fecha == null)
            throw new IllegalArgumentException("LA FECHA DE REGISTRO NO EXISTE");
        /*if(combustible.size() > 4) // Solo registra hasta 4 tipos de combustible
            throw new IllegalArgumentException("NO SE PUEDE REGISTRAR MAS DE 4 COMBUSTIBLES");
        */
        this.gasolinera = gasolinera;
        this.fecha = fecha;
        this.empleados = new ArrayList<>();
        this.combustible = new ArrayList<>();
        this.venta = new ArrayList<>();
    }


    public String getFecha() {
        return fecha;
    }

    public List<Fuel> getCombustible() {
        return combustible;
    }

    public List<saleServiceStation> getVenta() {
        return venta;
    }
    
    
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<EmployeeServiceStation> getEmpleados() {
        return empleados;
    }

    public ServiceStation getGasolinera() {
        return gasolinera;
    }
    
    public void createFuel(Fuel combustible){
        this.combustible.add(combustible);
    }
    
    public void createSaleServiceStation(saleServiceStation venta){
        this.venta.add(venta);
    }
    
    public void createEmployeeServiceStation(EmployeeServiceStation empleado){
            this.empleados.add(empleado);      
    }
    /*
    public String venta(){
        return this.venta().toString();
    }
    */
    public void seeInfo(){
        JOptionPane.showMessageDialog(null, "FECHA CREADO: "+this.getFecha()
                +"","**INFO SURTIDOR**",JOptionPane.INFORMATION_MESSAGE);
    } 
    
    @Override
    public String toString(){
        return gasolinera.administrador.sucursal+"\n";
    }
    
}
