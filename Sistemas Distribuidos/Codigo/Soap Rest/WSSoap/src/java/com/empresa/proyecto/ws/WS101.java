
package com.empresa.proyecto.ws;

import com.empresa.proyecto.dto.Usuario;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;


@WebService(serviceName = "WS101")
public class WS101 {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUsuario")
    public Usuario getUsuario(@WebParam(name = "code") String code) {
        Usuario u=new Usuario();
        
        return u;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getWeather")
    public Usuario getWeather(@WebParam(name = "city") String city) {
        Usuario ux= new Usuario ();
        ux.setCiudad("Cuenca");
        ux.setPais("Ecuador");
        ux.setClima("57");
        return ux;
    }


}
