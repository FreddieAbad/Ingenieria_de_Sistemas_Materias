package com.empresa.proyecto.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "WS100")
public class WS100 {

    @WebMethod(operationName = "getMensaje")
    public String getMensaje(@WebParam(name = "code") String code) {
        String msg = "Bienvenido a Web Services - SOAP "+code;
        return msg;
    }

    
}
