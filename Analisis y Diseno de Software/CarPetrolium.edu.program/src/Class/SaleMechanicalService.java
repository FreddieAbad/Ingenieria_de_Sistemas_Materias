package Class;

import javax.swing.JOptionPane;


public class SaleMechanicalService {
    
    private Customer cliente;
    private Employee empleado;
    private double total;

    public SaleMechanicalService(Customer cliente, Employee empleado, double total) {
        if(cliente == null)
            throw new IllegalArgumentException("CLIENTE == NULL");
        if(empleado == null)
            throw new IllegalArgumentException("EMPLEADO == NULL");
        /*if(total == 0)
            throw new IllegalArgumentException("COMPRA EN CERO OSEA QUE ONDA");*/
        this.cliente = cliente;
        this.empleado = empleado;
        this.total = total;
    }

    public Customer getCliente() {
        return cliente;
    }

    public Employee getEmpleado() {
        return empleado;
    }

    public double getTotal() {
        return total;
    }

    public void sale(){
        JOptionPane.showMessageDialog(null,"REALIZADO POR: " + this.empleado.getNombre() + "\nCLIENTE: "+ this.cliente.getNombre() +"\nTOTAL A PAGAR: "+ this.total
                          +" DOLARES","**INFO VENTA TECNICENTRO**",JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public String toString() {
        return "CLIENTE" + cliente.getNombre() + ", EMPLEADO: " + empleado.getNombre() + ", TOTAL: " + total + " EN SERVICIOS";
    }
}
