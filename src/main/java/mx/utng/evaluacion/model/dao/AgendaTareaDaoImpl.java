package mx.utng.evaluacion.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.evaluacion.model.entity.AgendaTarea;

 @Repository
public class AgendaTareaDaoImpl implements IAgendaTareaDao {

    //Entity manager y contexto de persistencia  = Gestor de entidad persistencia nos permite ver los datos mas de una vez como la base de datos donde puedes acceder a la info
    //Guarda internamente todas las entidades y utiliza como una chache datos de DB

     @Autowired
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<AgendaTarea> list() {
        return em.createQuery("from AgendaTarea").getResultList();
    }

    @Override
    public void save(AgendaTarea agendatarea) {
        if(agendatarea.getId()!=null && agendatarea.getId()>0){
            //Actualizar si Student no es null 
            em.merge(agendatarea);
        }else{
            //Crear un nuevo Student
            em.persist(agendatarea);
        }
        
    }

    @Override
    public AgendaTarea getById(Long id) {
        //PARA ENCONTRAR A UN ESTUDIANTE CON EL id que esta en los PARAMETROS

        return em.find(AgendaTarea.class, id);        
    }

    @Override
    public void delete(Long id) {
    AgendaTarea agendatarea = getById(id); 
    em.remove(agendatarea);
    }
    


    //FALTAN 5 ARCHIVOS QUE MODIFICAR 
}
