/**
 * @autor:Carmen Catalina Delgado Manzano 
 * @category:GDS0622
 * @since: 17-03-2024
 */
package mx.utng.sesion26.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.sesion26.model.entity.Installation;
/*
* Clase repositorio o Dao permite guardar datos y estar trabajando con ellos
UTILIZARE LA ANOTACIÓN @Repository
Repositorios: Sirven para guardar info(CLASES,METODOS,ETC)
 */

 @Repository
public class InstallationDaoImpl implements IInstallationDao {

    //Entity manager y contexto de persistencia  = Gestor de entidad persistencia nos permite ver los datos mas de una vez como la base de datos donde puedes acceder a la info
    //Guarda internamente todas las entidades y utiliza como una chache datos de DB

     @Autowired
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Installation> list() {
        return em.createQuery("from Installation").getResultList();
    }

    @Override
    public void save(Installation installation) {
        if(installation.getId()!=null && installation.getId()>0){
            //Actualizar si installation no es null 
            em.merge(installation);
        }else{
            //Crear una nueva Instalación
            em.persist(installation);
        }
        
    }

    @Override
    public Installation getById(Long id) {
        //PARA ENCONTRAR A UN ESTUDIANTE CON EL id que esta en los PARAMETROS

        return em.find(Installation.class, id);        
    }

    @Override
    public void delete(Long id) {
    Installation installation = getById(id); 
    em.remove(installation);
    }
    


    //FALTAN 5 ARCHIVOS QUE MODIFICAR 
}
