package mx.utng.sesion26.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.sesion26.model.entity.Teacher;

@Repository
public class TeacherDaoImpl implements ITeacherDao{
    @Autowired
    private EntityManager em;
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Teacher> list() {
        return em.createQuery("from Teacher").getResultList();
    }

    @Override
    public void save(Teacher teacher) {
        if(teacher.getId()!=null && teacher.getId()>0){
            //Actualizar si Student no es null 
            em.merge(teacher);
        }else{
            //Crear un nuevo Student
            em.persist(teacher);
        }
        
    }

    @Override
    public Teacher getById(Long id) {
        //PARA ENCONTRAR A UN ESTUDIANTE CON EL id que esta en los PARAMETROS

        return em.find(Teacher.class, id);        
    }

    @Override
    public void delete(Long id) {
    Teacher teacher  = getById(id); 
    em.remove(teacher);
    }
    
    
}
