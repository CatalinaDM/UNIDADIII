/**
 * @autor:Carmen Catalina Delgado Manzano 
 * @category:GDS0622
 * @since: 17-03-2024
 */

package mx.utng.sesion26.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mx.utng.sesion26.model.dao.IInstallationDao;
import mx.utng.sesion26.model.entity.Installation;
/*
 * Una clase service, esta basada aen el patrón de diseño fachada 
 * Es un único punto de acceso hacia los DAO(Date access object)
 * .Dentro de la clase service, podemos operar
 * con distintas clases DAO.  
 */
@Service
public class InstallationServiceImpl implements IInstallationService {
    //Inyectamos la interfaz para utilizar los métodos de CRUD. 
    //C-Create, R-Read Retrieve, U-Update,D-Delete. 
    @Autowired
    private IInstallationDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<Installation> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(Installation installation) {
        dao.save(installation);
    }

    @Transactional(readOnly =  true)
    @Override
    public Installation getById(Long id) {
       return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
       dao.delete(id);
    }

    
}
