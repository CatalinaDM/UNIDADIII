/**
 * @autor:Carmen Catalina Delgado Manzano 
 * @category:GDS0622
 * @since: 17-03-2024
 */
package mx.utng.evaluacion.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.evaluacion.model.entity.PlanFinanciero;

 @Repository
public class PlanFinancieroDaoImpl implements IPlanFinancieroDao {

    //Entity manager y contexto de persistencia  = Gestor de entidad persistencia nos permite ver los datos mas de una vez como la base de datos donde puedes acceder a la info
    //Guarda internamente todas las entidades y utiliza como una chache datos de DB

     @Autowired
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<PlanFinanciero> list() {
        return em.createQuery("from PlanFinanciero").getResultList();
    }

    @Override
    public void save(PlanFinanciero planfinanciero) {
        if(planfinanciero.getId()!=null && planfinanciero.getId()>0){
            //Actualizar si planfinanciero no es null 
            em.merge(planfinanciero);
        }else{
            //Crear una nueva Instalación
            em.persist(planfinanciero);
        }
        
    }

    @Override
    public PlanFinanciero getById(Long id) {
        //PARA ENCONTRAR A UN ESTUDIANTE CON EL id que esta en los PARAMETROS

        return em.find(PlanFinanciero.class, id);        
    }

    @Override
    public void delete(Long id) {
    PlanFinanciero planfinanciero = getById(id); 
    em.remove(planfinanciero);
    }
    


    //FALTAN 5 ARCHIVOS QUE MODIFICAR 
}
