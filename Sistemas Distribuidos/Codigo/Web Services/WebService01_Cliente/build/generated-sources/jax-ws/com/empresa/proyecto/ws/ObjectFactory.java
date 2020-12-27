
package com.empresa.proyecto.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.empresa.proyecto.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetMensaje_QNAME = new QName("http://ws.proyecto.empresa.com/", "getMensaje");
    private final static QName _GetMensajeResponse_QNAME = new QName("http://ws.proyecto.empresa.com/", "getMensajeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.empresa.proyecto.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetMensajeResponse }
     * 
     */
    public GetMensajeResponse createGetMensajeResponse() {
        return new GetMensajeResponse();
    }

    /**
     * Create an instance of {@link GetMensaje }
     * 
     */
    public GetMensaje createGetMensaje() {
        return new GetMensaje();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMensaje }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.proyecto.empresa.com/", name = "getMensaje")
    public JAXBElement<GetMensaje> createGetMensaje(GetMensaje value) {
        return new JAXBElement<GetMensaje>(_GetMensaje_QNAME, GetMensaje.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMensajeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.proyecto.empresa.com/", name = "getMensajeResponse")
    public JAXBElement<GetMensajeResponse> createGetMensajeResponse(GetMensajeResponse value) {
        return new JAXBElement<GetMensajeResponse>(_GetMensajeResponse_QNAME, GetMensajeResponse.class, null, value);
    }

}
