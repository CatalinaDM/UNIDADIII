package mx.utng.sesion28.persistence;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import mx.utng.sesion28.model.Equipo;

@SpringBootTest 
    @ComponentScan(basePackages = "mx.utng.sesion28")
    @ExtendWith(SpringExtension.class)
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class IPartidoRepositoryTest {

    @Autowired
    private IEquipoRepository equipoRepository; 

    @Autowired 
    private IPartidoRepository partidoRepository; 
    @BeforeAll
    void cleanDatabase(){
        partidoRepository.deleteAll(null);
    }

    @Test
    @DisplayName ("Prueba guardar partido")
    void canSave(){
    
        Equipo equipo1 = new Equipo();
        Equipo equipo2 = new Equipo(); 



    }

}
