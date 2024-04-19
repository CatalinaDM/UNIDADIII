/**
 * @autor:Carmen Catalina Delgado Manzano 
 * @category:GDS0622
 * @since: 17-03-2024
 */

package mx.utng.sesion26.model.service;

import mx.utng.sesion26.model.entity.Installation;
import java.util.List;

public interface IInstallationService {
    List<Installation> list();
    void save (Installation installation); 
    Installation getById(Long id); 
    void delete (Long id);
}
