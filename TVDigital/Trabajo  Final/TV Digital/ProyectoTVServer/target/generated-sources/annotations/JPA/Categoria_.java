package JPA;

import JPA.Multimedia;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-07-21T20:56:34")
@StaticMetamodel(Categoria.class)
public class Categoria_ { 

    public static volatile SingularAttribute<Categoria, String> descripcion;
    public static volatile SingularAttribute<Categoria, Integer> idCategoriaPadre;
    public static volatile SingularAttribute<Categoria, Integer> idSucategoria;
    public static volatile SingularAttribute<Categoria, Integer> idCategoria;
    public static volatile CollectionAttribute<Categoria, Multimedia> multimediaCollection;

}