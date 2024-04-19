package mx.utng.sesion28.persistence;

import org.springframework.data.repository.CrudRepository;

import mx.utng.sesion28.model.Partido;

public interface IPartidoRepository extends CrudRepository<Partido, Long> {
    
}
