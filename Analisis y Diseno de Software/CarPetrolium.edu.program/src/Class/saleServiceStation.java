package Class;

import javax.swing.JOptionPane;

public class saleServiceStation {
    private EmployeeServiceStation empleado;
    private CustomerServiceStation cliente;
    private Fuel combustible;
    private String fecha;
    private int cantidad;

    public saleServiceStation(EmployeeServiceStation empleado, CustomerServiceStation cliente, Fuel combustible, String fecha, int cantidad) {
        this.empleado = empleado;
        this.cliente = cliente;
        this.combustible = combustible;
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    
    
    public EmployeeServiceStation getEmpleado() {
        return empleado;
    }

    public CustomerServiceStation getCliente() {
        return cliente;
    }

    public Fuel getCombustible() {
        return combustible;
    }

    public String toString(){
        return "EMPLEADO: " + this.empleado.getNombre() + " | EMPLEADO: " + this.getCliente().getNombre() + "| "
                + "VENTA: " + this.getCantidad() + " galones de " +this.combustible.getNombre() + " | TOTAL: " + this.cantidad*this.combustible.getCostoGalon();
    }
    
    public void sale(){
        JOptionPane.showMessageDialog(null,"REALIZADO POR: " + this.empleado.getNombre() + "\nCOMBUSTIBLE: "+ this.combustible.getNombre() +"\nCantidad: "+ this.getCantidad()
                +"\nCLIENTE: "+ this.cliente.getNombre() +"\nTOTAL: "+ this.cantidad*this.combustible.getCostoGalon()
                +"","**INFO VENTA**",JOptionPane.INFORMATION_MESSAGE);
    }
    
}
