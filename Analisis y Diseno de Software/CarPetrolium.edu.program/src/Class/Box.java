package Class;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Box {
   
    private String fecha;
    private List<Employee> empleados;
    private List<SaleStoreService> venta;
    private List<SaleMechanicalService> ventaT;
    
    public Box(String fecha) {
        if(fecha == null)
            throw new IllegalArgumentException("NO HAY FECHA");
        this.fecha = fecha;
        this.empleados = new ArrayList<>();
        this.venta = new ArrayList<>();
        this.ventaT = new ArrayList<>();
    }

    public String getFecha() {
        return fecha;
    }

    public List<SaleStoreService> getVenta() {
        return venta;
    }

    public List<SaleMechanicalService> getVentaT() {
        return ventaT;
    }
    
    public List<Employee> getEmpleados() {
        return empleados;
    }
    
    public void createEmployee(Employee empleado){
        this.empleados.add(empleado);
    }
    
    public void createSaleStoreService(SaleStoreService venta){
        this.venta.add(venta);
    }
    
    public void createSaleMechanicalService(SaleMechanicalService venta){
        this.ventaT.add(venta);
    }
    
    public void seeInfo(){
        JOptionPane.showMessageDialog(null, "FECHA CREADO: "+this.getFecha()
                +"","**INFO CAJERO**",JOptionPane.INFORMATION_MESSAGE);
    } 
    
}
