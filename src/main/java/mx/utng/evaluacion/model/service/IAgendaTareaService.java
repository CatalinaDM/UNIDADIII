/**
 * @autor:Carmen Catalina Delgado Manzano 
 * @category:GDS0622
 * @since: 17-03-2024
 */

package mx.utng.evaluacion.model.service;

import java.util.List;

import mx.utng.evaluacion.model.entity.AgendaTarea;

public interface IAgendaTareaService {
    List<AgendaTarea> list();
    void save (AgendaTarea agendatarea); 
    AgendaTarea getById(Long id); 
    void delete (Long id);
}
