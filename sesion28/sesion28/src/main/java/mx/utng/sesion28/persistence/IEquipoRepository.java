package mx.utng.sesion28.persistence;

import org.springframework.data.repository.CrudRepository;

import mx.utng.sesion28.model.Equipo;

public interface IEquipoRepository extends CrudRepository<Equipo,Long> {

    Iterable<Equipo>findAllByNombre(String nombre);    
    

}
