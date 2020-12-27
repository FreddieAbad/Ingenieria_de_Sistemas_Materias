
package com.empresa.poyecto.app;


public class Aplicacion {

    public static void main(String[] args) {
        System.out.println("Response: "+getMensaje("Ecuador"));
    }

    private static String getMensaje(java.lang.String code) {
        com.empresa.proyecto.ws.WS100_Service service = new com.empresa.proyecto.ws.WS100_Service();
        com.empresa.proyecto.ws.WS100 port = service.getWS100Port();
        return port.getMensaje(code);
    }
    
}
