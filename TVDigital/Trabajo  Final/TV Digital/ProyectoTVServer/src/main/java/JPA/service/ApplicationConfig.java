/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Gustavo
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(JPA.service.CategoriaFacadeREST.class);
        resources.add(JPA.service.LogginFacadeREST.class);
        resources.add(JPA.service.MpaaFacadeREST.class);
        resources.add(JPA.service.MultimediaFacadeREST.class);
        resources.add(JPA.service.PreferenciaFacadeREST.class);
        resources.add(JPA.service.RankingFacadeREST.class);
        resources.add(JPA.service.UsuarioFacadeREST.class);
    }
    
}
