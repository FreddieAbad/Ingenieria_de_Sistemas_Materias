package Class;

public abstract class Service {
    
    Administrator administrador; 
    private String fecha;

    public Service(Administrator administrador, String fecha) {
        if(fecha == null)
            throw new IllegalArgumentException("NO SE REGISTRADO LA FECHA DE CREACION");
        if(administrador == null)
            throw new IllegalArgumentException("EL ADMINISTRADOR NO HA SIDO IDENTIFICADO");
        this.administrador = administrador;
        this.fecha = fecha;
    }

    public Administrator getAdministrador() {
        return administrador;
    }

    public String getFecha() {
        return fecha;
    }

    public void setAdministrador(Administrator administrador) {
        this.administrador = administrador;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    
    public void seeInfo(){
        
    }
    
}
