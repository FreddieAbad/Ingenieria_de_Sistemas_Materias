package Class;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ServiceStation extends Service{

    private List<Dispenser> dispensadores;
    private List<CustomerServiceStation> clientes;

    public ServiceStation(Administrator administrador, String fecha) {
        super(administrador, fecha);
                
        /*if(dispensadores.size() > 6) //solo permite agregar 6 dispensadores
                                      /* OJO == 6 es tamaño no posicion */
        /*    throw new IllegalArgumentException("NO HAY ESPACIO PARA MAS DISPENSADORES");
        
        */
        this.dispensadores = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public List<Dispenser> getDispensadores() {
        return dispensadores;
    }

    public List<CustomerServiceStation> getClientes() {
        return clientes;
    }
    
    public void createDispenser(Dispenser dispensador){
            this.dispensadores.add(dispensador);
    }   
    
    public void createCustomerServiceStation(CustomerServiceStation cliente){
        this.clientes.add(cliente);
    }
    
    public void seeinfo(){
        JOptionPane.showInputDialog(null, "SUCURSAL: "+administrador.sucursal.getNombreSucursal()+"\nDIRECCION: "+administrador.sucursal.getDireccionSucursal()
            +"\nNUMERO DE DISPENSADORES: " + dispensadores.size() + "\nFECHA DE REGISTRO AL SISTEMA: "+ getFecha()
            +"\n","**INFO ADMINISTRADOR**",JOptionPane.INFORMATION_MESSAGE);
    }
    
}
