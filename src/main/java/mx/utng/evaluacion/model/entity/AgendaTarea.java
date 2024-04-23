/**
 * @autor:Carmen Catalina Delgado Manzano 
 * @category:GDS0622
 * @since: 17-03-2024
 */

package mx.utng.evaluacion.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;


@Entity
public class AgendaTarea {
    
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(length = 30)
    private String tarea; 

    @NotEmpty
    @Column(length = 30)
    private String materia; 

    @NotEmpty
    @Column(length = 20)
    private String propietario;

    @Min(1)
    @Max(10)
    private Float valorTarea; 
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

@PrePersist
public void prePersist(){
    fecha = new Date();
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getTarea() {
    return tarea;
}

public void setTarea(String tarea) {
    this.tarea = tarea;
}

public String getMateria() {
    return materia;
}

public void setMateria(String materia) {
    this.materia = materia;
}

public String getPropietario() {
    return propietario;
}

public void setPropietario(String propietario) {
    this.propietario = propietario;
}

public Float getValorTarea() {
    return valorTarea;
}

public void setValorTarea(Float valorTarea) {
    this.valorTarea = valorTarea;
}

public Date getFecha() {
    return fecha;
}

public void setFecha(Date fecha) {
    this.fecha = fecha;
}

}
