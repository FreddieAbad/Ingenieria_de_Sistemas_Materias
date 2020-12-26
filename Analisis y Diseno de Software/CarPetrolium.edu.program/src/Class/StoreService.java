package Class;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class StoreService extends Service{
    
    private List<Box> caja;
    private List<Customer> clientes;
    private List<Product> productos;
    
    public StoreService(Administrator administrador, String fecha) {
        super(administrador, fecha);
        this.caja = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.productos = new ArrayList<>();
    }    

    public List<Box> getCaja() {
        return caja;
    }

    public List<Customer> getClientes() {
        return clientes;
    }

    public List<Product> getProductos() {
        return productos;
    }
    
    public void createBox(Box caja){
        this.caja.add(caja);
    }
    
    public void createCustomer(Customer cliente){
        this.clientes.add(cliente);
    }
    
    public void createProduct(Product producto){
        this.productos.add(producto);
    }
    
    @Override
    public void seeInfo(){
        JOptionPane.showMessageDialog(null,"administrador " + super.administrador.getNombre(),"ERROR",JOptionPane.ERROR_MESSAGE);
    }
}
