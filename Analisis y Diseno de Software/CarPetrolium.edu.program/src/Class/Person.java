package Class;

public abstract class Person {

    private int ruc;
    private String nombre,direccion,correo;

    public Person(int ruc, String nombre, String direccion, String correo) {
        
        if(ruc == 0)
            throw new IllegalArgumentException("RUC INCORRECTO");
        if(nombre == null)
            throw new IllegalArgumentException("NOMBRE DE PERSONA == NULL");
        if(direccion == null)
            throw new IllegalArgumentException("DIRECCION DE PERSONA == NULL");
        if(correo == null)
            throw new IllegalArgumentException("CORREO DE PERSONA == NULL");
        
        this.ruc = ruc;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
    }

    public int getRuc() {
        return ruc;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setRuc(int ruc) {
        this.ruc = ruc;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public void seeInfo(){
        
    }
    @Override
    
    public String toString(){
        return "RUC: 0" + this.getRuc() + " NOMBRE: " + this.getNombre() + ""
                + " DIRECCION: " + this.getDireccion() + " CORREO: " + this.getCorreo();
    }
}
