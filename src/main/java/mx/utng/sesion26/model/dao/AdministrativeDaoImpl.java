package mx.utng.sesion26.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.sesion26.model.entity.Administrative;
/*
* Clase repositorio o Dao permite guardar datos y estar trabajando con ellos
UTILIZARE LA ANOTACIÓN @Repository
Repositorios: Sirven para guardar info(CLASES,METODOS,ETC)
 */

 @Repository
public class AdministrativeDaoImpl implements IAdministrativeDao {

    //Entity manager y contexto de persistencia  = Gestor de entidad persistencia nos permite ver los datos mas de una vez como la base de datos donde puedes acceder a la info
    //Guarda internamente todas las entidades y utiliza como una chache datos de DB

     @Autowired
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Administrative> list() {
        return em.createQuery("from Administrative").getResultList();
    }

    @Override
    public void save(Administrative administrative) {
        if(administrative.getId()!=null && administrative.getId()>0){
            //Actualizar si Student no es null 
            em.merge(administrative);
        }else{
            //Crear un nuevo Student
            em.persist(administrative);
        }
        
    }

    @Override
    public Administrative getById(Long id) {
        //PARA ENCONTRAR A UN ESTUDIANTE CON EL id que esta en los PARAMETROS

        return em.find(Administrative.class, id);        
    }

    @Override
    public void delete(Long id) {
    Administrative administrative = getById(id); 
    em.remove(administrative);
    }
    


    //FALTAN 5 ARCHIVOS QUE MODIFICAR 
}
