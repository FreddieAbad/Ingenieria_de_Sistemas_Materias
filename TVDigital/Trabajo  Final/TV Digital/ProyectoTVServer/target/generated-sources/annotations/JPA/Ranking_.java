package JPA;

import JPA.Multimedia;
import JPA.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-21T20:56:34")
@StaticMetamodel(Ranking.class)
public class Ranking_ { 

    public static volatile SingularAttribute<Ranking, Integer> idRanking;
    public static volatile SingularAttribute<Ranking, Multimedia> idMultimedia;
    public static volatile SingularAttribute<Ranking, String> porcentaje;
    public static volatile SingularAttribute<Ranking, Integer> nota;
    public static volatile SingularAttribute<Ranking, Usuario> idPersona;

}