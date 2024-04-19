
/*
 * @autor:Carmen Catalina Delgado Manzano 
 * @category:GDS0622
 * @since: 17-03-2024
 */
package mx.utng.sesion26.model.dao;
import java.util.List;
import mx.utng.sesion26.model.entity.Subject;


public interface ISubjectDao {
    List<Subject>list(); 
    void save(Subject subject);
    Subject getById(Long id);
    void delete (Long id);

}
