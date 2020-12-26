package Class;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Manager extends Person{
    
    Company empresa;
    
    private List<BranchOffice> sucursales;
    //private List<Administrator> administradores;
    private List<EmployeeServiceStation> empleados;
    private List<saleServiceStation> ventaGasolinera;
    private List<SaleStoreService> ventaMarket;
    private List<SaleMechanicalService> ventaTecnicentro;
    
    public Manager(int ruc, String nombre, String direccion, String correo, Company empresa) {
        
        super(ruc, nombre, direccion, correo);
        
        if(ruc == 0)
            throw new IllegalArgumentException("RUC INCORRECTO");
        if(nombre == null)
            throw new IllegalArgumentException("NOMBRE DEL GERENTE == NULL");
        if(direccion == null)
            throw new IllegalArgumentException("DIRECCION DEL GERENTE == NULL");
        if(correo == null)
            throw new IllegalArgumentException("CORREO DEL GERENTE == NULL");
        if(empresa == null)
            throw new IllegalArgumentException("LA EMPRESA NO AH SIDO IDENTIFICADA");
                
        this.empresa = empresa;
        //this.administradores = new ArrayList<>();
        this.sucursales = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.ventaGasolinera = new ArrayList<>();
        this.ventaMarket = new ArrayList<>();
        this.ventaTecnicentro = new ArrayList<>();
    }
    
    
    public void createBranchOffice(BranchOffice sucursal){
        this.sucursales.add(sucursal);
    }
    /*public void createAdmin(Administrator administrador, int i){ // i va a ser el numero de sucursal
        
      //this.administradores.add(administrador);
        this.sucursales.get(i).createAdministrator(administrador);
        
    }*/

    public List<saleServiceStation> getVentaGasolinera() {
        return ventaGasolinera;
    }

    public List<SaleStoreService> getVentaMarket() {
        return ventaMarket;
    }

    public List<SaleMechanicalService> getVentaTecnicentro() {
        return ventaTecnicentro;
    }
    
    public void createEmployee(EmployeeServiceStation empleado){
        this.empleados.add(empleado);
    }
    
    public void createSaleServiceStation(saleServiceStation venta){
        this.ventaGasolinera.add(venta);
    }
    public void createSaleStoreService(SaleStoreService venta){
        this.ventaMarket.add(venta);
    }
    public void createSaleMechanicalService(SaleMechanicalService venta){
        this.ventaTecnicentro.add(venta);
    }
    /*public List<Administrator> getAdministradores() {
        return administradores;
    }*/

    public List<EmployeeServiceStation> getEmpleados() {
        return empleados;
    }

    public List<BranchOffice> getSucursales() {
        return sucursales;
    }
    
    
    
    @Override
    public void seeInfo() {
        JOptionPane.showMessageDialog(null,"RUC: 0"+ super.getRuc()+"\nNOMBRE: "+super.getNombre()
                +"\nDIRECCION: "+super.getDireccion()+"\nCORREO: "+super.getCorreo()
                +"\nEMPRESA: "+empresa.getNombre(),"**INFO GERENTE**",1);
    }
    
    @Override
    public String toString(){
        return super.toString();
    }
    
}
