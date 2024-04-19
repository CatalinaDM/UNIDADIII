package mx.utng.sesion26.model.dao;
import java.util.List;
import mx.utng.sesion26.model.entity.Administrative;


public interface IAdministrativeDao {
    List<Administrative>list(); 
    void save(Administrative administrative);
    Administrative getById(Long id);
    void delete (Long id);

}
