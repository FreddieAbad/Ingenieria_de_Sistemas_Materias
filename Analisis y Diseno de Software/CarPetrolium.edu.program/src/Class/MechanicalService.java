package Class;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MechanicalService extends Service{
    private List<Box> caja;
    private List<Customer> clientes;
    private List<ServiceEmployee> servicios;
    
    
    public MechanicalService(Administrator administrador, String fecha) {
        super(administrador, fecha);
        this.caja = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.servicios = new ArrayList<>();
    }
 
    public void createBox(Box caja){
        this.caja.add(caja);
    }
    
    public void createCustomer(Customer cliente){
        this.clientes.add(cliente);
    }
    
    public void createServiceEmployee(ServiceEmployee servicio){
        this.servicios.add(servicio);
    }

    public List<Box> getCaja() {
        return caja;
    }

    public List<Customer> getClientes() {
        return clientes;
    }

    public List<ServiceEmployee> getServicios() {
        return servicios;
    }
    
    @Override
    public void seeInfo(){
        JOptionPane.showMessageDialog(null,"administrador " + super.administrador.getNombre(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
}
