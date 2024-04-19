package mx.utng.sesion26.model.service;

import mx.utng.sesion26.model.entity.Student;
import java.util.List;

public interface IStudentService {
    List<Student> list();
    void save (Student student); 
    Student getById(Long id); 
    void delete (Long id);
}
