/**
 * @autor:Carmen Catalina Delgado Manzano 
 * @category:GDS0622
 * @since: 17-03-2024
 */

package mx.utng.sesion26.model.service;

import mx.utng.sesion26.model.entity.Administrative;
import java.util.List;

public interface IAdministrativeService {
    List<Administrative> list();
    void save (Administrative administrative); 
    Administrative getById(Long id); 
    void delete (Long id);
}
