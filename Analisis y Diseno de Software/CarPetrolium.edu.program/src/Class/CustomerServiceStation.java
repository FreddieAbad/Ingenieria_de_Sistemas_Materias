package Class;

import javax.swing.JOptionPane;

public class CustomerServiceStation extends Person{
    
    ServiceStation gasolinera;
    private String VehiclePlates;

    public CustomerServiceStation(int ruc, String nombre, String direccion, String correo,String placas,ServiceStation gasolinera) {
        super(ruc, nombre, direccion, correo);
        this.VehiclePlates = placas;
        this.gasolinera = gasolinera;
    }

    public String getVehiclePlates() {
        return VehiclePlates;
    }

    public ServiceStation getGasolinera() {
        return gasolinera;
    }

    public void setGasolinera(ServiceStation gasolinera) {
        this.gasolinera = gasolinera;
    }
    
    
    public void setVehiclePlates(String VehiclePlates) {
        this.VehiclePlates = VehiclePlates;
    }
    
    public void seeInfo(){
        JOptionPane.showMessageDialog(null,"PLACAS VEHICULO: " + this.VehiclePlates + "\nRUC: "+super.getRuc()+"\nNOMBRE: "+super.getNombre()
                +"\nDIRECCION: "+ super.getDireccion() +"\nCORREO: "+super.getCorreo()
                +"","**INFO CLIENTE**",JOptionPane.INFORMATION_MESSAGE);    
    }
    
    @Override
    public String toString(){
        return "PLACAS VEHICULO: "+ this.VehiclePlates + "\n" + super.toString();
    }
}
