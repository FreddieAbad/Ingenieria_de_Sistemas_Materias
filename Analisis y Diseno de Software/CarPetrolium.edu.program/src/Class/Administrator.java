package Class;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Administrator extends Person{

    BranchOffice sucursal;
    private List<ServiceStation> gasolinera;
    private List<StoreService> minimercado;
    private List<MechanicalService> tecnicentro;
    
    public Administrator(int ruc, String nombre, String direccion, String correo,BranchOffice sucursal) {
        super(ruc, nombre, direccion, correo);
        
        
        /*if(gasolinera.size() > 1)
            throw new IllegalArgumentException("SOLO SE PERMITE UNA GASOLINERA POR SUCURSAL");
        */if(sucursal == null)
            throw new IllegalArgumentException("NO SE A IDENTIFICADO LA SUCURSAL DONDE VA A TRABAJAR");
        
        this.sucursal = sucursal;
        this.gasolinera = new ArrayList<>();
        this.minimercado = new ArrayList<>();        
        this.tecnicentro = new ArrayList<>();

    }

    public BranchOffice getSucursal() {
        return sucursal;
    }
    
    public void createServiceStation(ServiceStation gasolinera){
        this.gasolinera.add(gasolinera);
    }
    
    public void createStoreService(StoreService minimercado){
        this.minimercado.add(minimercado);
    }
    
    public void createMechanicalService(MechanicalService taller){
        this.tecnicentro.add(taller);
    }
    
    public List<ServiceStation> getGasolinera() {
        return gasolinera;
    }

    public List<StoreService> getMinimercado() {
        return minimercado;
    }

    public List<MechanicalService> getTecnicentro() {
        return tecnicentro;
    }
    
    
    @Override
    public void seeInfo(){
    
        JOptionPane.showMessageDialog(null, "RUC: 0"+super.getRuc()+"\nNOMBRE: "+super.getNombre()
                +"\nDIRECCION: "+ super.getDireccion() +"\nCORREO: "+super.getCorreo()
                +"","**INFO ADMINISTRADOR**",JOptionPane.INFORMATION_MESSAGE);
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
    
}
