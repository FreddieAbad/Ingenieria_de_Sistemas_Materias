
package wsc;


public class Aplicacion {

    public static void main(String[] args) {
        System.out.println("Response: "+getMensaje("789654"));
    }

    private static String getMensaje(java.lang.String code) {
        wsc.WS101_Service service = new com.empresa.proyecto.ws.WS100_Service();
        wsc.WS101 port = service.getWS100Port();
        return port.getMensaje(code);
    }
    
}
