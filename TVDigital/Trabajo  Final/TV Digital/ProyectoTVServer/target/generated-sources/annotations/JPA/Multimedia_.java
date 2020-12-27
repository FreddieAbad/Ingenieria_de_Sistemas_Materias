package JPA;

import JPA.Categoria;
import JPA.Mpaa;
import JPA.Preferencia;
import JPA.Ranking;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-21T20:56:34")
@StaticMetamodel(Multimedia.class)
public class Multimedia_ { 

    public static volatile CollectionAttribute<Multimedia, Preferencia> preferenciaCollection;
    public static volatile CollectionAttribute<Multimedia, Ranking> rankingCollection;
    public static volatile SingularAttribute<Multimedia, Integer> idMultimedia;
    public static volatile SingularAttribute<Multimedia, String> duracion;
    public static volatile SingularAttribute<Multimedia, Categoria> idCategoria;
    public static volatile SingularAttribute<Multimedia, Mpaa> idMpaa;
    public static volatile SingularAttribute<Multimedia, String> nombre;

}