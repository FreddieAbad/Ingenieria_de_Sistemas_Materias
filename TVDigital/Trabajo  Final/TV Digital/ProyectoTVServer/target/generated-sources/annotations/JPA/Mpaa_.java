package JPA;

import JPA.Multimedia;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-21T20:56:34")
@StaticMetamodel(Mpaa.class)
public class Mpaa_ { 

    public static volatile SingularAttribute<Mpaa, Integer> edadMayor;
    public static volatile SingularAttribute<Mpaa, String> clasificacion;
    public static volatile SingularAttribute<Mpaa, Integer> idMpaa;
    public static volatile SingularAttribute<Mpaa, String> detalle;
    public static volatile CollectionAttribute<Mpaa, Multimedia> multimediaCollection;

}