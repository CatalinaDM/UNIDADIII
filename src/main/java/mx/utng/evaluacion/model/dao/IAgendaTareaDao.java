package mx.utng.evaluacion.model.dao;
import java.util.List;

import mx.utng.evaluacion.model.entity.AgendaTarea;


public interface IAgendaTareaDao {
    List<AgendaTarea>list(); 
    void save(AgendaTarea agendatarea);
    AgendaTarea getById(Long id);
    void delete (Long id);

}
