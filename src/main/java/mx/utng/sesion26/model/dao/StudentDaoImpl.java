package mx.utng.sesion26.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.sesion26.model.entity.Student;


/*
* Clase repositorio o Dao permite guardar datos y estar trabajando con ellos
UTILIZARE LA ANOTACIÓN @Repositorio
Repositorios: Sirven para guardar info(CLASES,METODOS,ETC)
 */

 @Repository
public class StudentDaoImpl implements IStudentDao {

    //Entity manager y contexto de persistencia  = Gestor de entidad persistencia nos permite ver los datos mas de una vez como la base de datos donde puedes acceder a la info
    //Guarda internamente todas las entidades y utiliza como una chache datos de DB

     @Autowired
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Student> list() {
        return em.createQuery("from Student").getResultList();
    }

    @Override
    public void save(Student student) {
        if(student.getId()!=null && student.getId()>0){
            //Actualizar si Student no es null 
            em.merge(student);
        }else{
            //Crear un nuevo Student
            em.persist(student);
        }
        
    }

    @Override
    public Student getById(Long id) {
        //PARA ENCONTRAR A UN ESTUDIANTE CON EL id que esta en los PARAMETROS

        return em.find(Student.class, id);        
    }

    @Override
    public void delete(Long id) {
    Student student = getById(id); 
    em.remove(student);
    }
    


    //FALTAN 5 ARCHIVOS QUE MODIFICAR 
}
