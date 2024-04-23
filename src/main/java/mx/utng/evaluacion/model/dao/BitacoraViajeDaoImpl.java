package mx.utng.evaluacion.model.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import mx.utng.evaluacion.model.entity.BitacoraViaje;

/*
* Clase repositorio o Dao permite guardar datos y estar trabajando con ellos
UTILIZARE LA ANOTACIÓN @Repository
Repositorios: Sirven para guardar info(CLASES,METODOS,ETC)
 */

 @Repository
public class BitacoraViajeDaoImpl implements IBitacoraViajeDao {

    //Entity manager y contexto de persistencia  = Gestor de entidad persistencia nos permite ver los datos mas de una vez como la base de datos donde puedes acceder a la info
    //Guarda internamente todas las entidades y utiliza como una chache datos de DB

     @Autowired
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<BitacoraViaje> list() {
        return em.createQuery("from BitacoraViaje").getResultList();
    }

    @Override
    public void save(BitacoraViaje bitacoraviaje) {
        if(bitacoraviaje.getId()!=null && bitacoraviaje.getId()>0){
            //Actualizar si Bitacora no es null 
            em.merge(bitacoraviaje);
        }else{
            //Crear un nuevo Bitacora
            em.persist(bitacoraviaje);
        }
        
    }

    @Override
    public BitacoraViaje getById(Long id) {
        //PARA ENCONTRAR A UN ESTUDIANTE CON EL id que esta en los PARAMETROS

        return em.find(BitacoraViaje.class, id);        
    }

    @Override
    public void delete(Long id) {
   BitacoraViaje bitacoraviaje = getById(id); 
    em.remove(bitacoraviaje);
    }

}
