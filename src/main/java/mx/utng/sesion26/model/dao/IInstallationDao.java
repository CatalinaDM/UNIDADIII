/**
 * @autor:Carmen Catalina Delgado Manzano 
 * @category:GDS0622
 * @since: 17-03-2024
 */

package mx.utng.sesion26.model.dao;
import java.util.List;
import mx.utng.sesion26.model.entity.Installation;


public interface IInstallationDao {
    List<Installation>list(); 
    void save(Installation installation);
    Installation getById(Long id);
    void delete (Long id);

}
