/**
 * @autor:Carmen Catalina Delgado Manzano 
 * @category:GDS0622
 * @since: 17-03-2024
 */

package mx.utng.evaluacion.model.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.evaluacion.model.dao.IAgendaTareaDao;
import mx.utng.evaluacion.model.entity.AgendaTarea;
/*
 * Una clase service, esta basada aen el patrón de diseño fachada 
 * Es un único punto de acceso hacia los DAO(Date access object).
 * Dentro de la clase service, podemos operar
 * con distintas clases DAO.  
 */
@Service
public class AgendaTareaServiceImpl implements IAgendaTareaService {
    //Inyectamos la interfaz para utilizar los métodos de CRUD. 
    //C-Create, R-Read Retrieve, U-Update,D-Delete. 
    @Autowired
    private IAgendaTareaDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<AgendaTarea> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(AgendaTarea agendatarea) {
        dao.save(agendatarea);
    }

    @Transactional(readOnly =  true)
    @Override
    public AgendaTarea getById(Long id) {
       return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
       dao.delete(id);
    }

    
}
