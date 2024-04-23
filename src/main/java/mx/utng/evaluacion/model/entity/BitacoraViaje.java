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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


@Entity
public class BitacoraViaje {
    
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

     @NotEmpty //    NO ACEPTA VALORES NULL
    @Column (length = 90)
    private String destino; 
    @NotEmpty //    NO ACEPTA VALORES NULL
    @Column (length = 90)
    private String actividades; 

    @NotNull
    private Double presupuesto; 

    @NotEmpty
    @Column (length = 25)
    private String transporte; 
    
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaDeViaje;

@PrePersist
public void prePersist(){
    fechaDeViaje = new Date();
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getDestino() {
	return destino;
}

public void setDestino(String destino) {
	this.destino = destino;
}

public String getActividades() {
	return actividades;
}

public void setActividades(String actividades) {
	this.actividades = actividades;
}

public Double getPresupuesto() {
	return presupuesto;
}

public void setPresupuesto(Double presupuesto) {
	this.presupuesto = presupuesto;
}

public String getTransporte() {
	return transporte;
}

public void setTransporte(String transporte) {
	this.transporte = transporte;
}

public Date getFechaDeViaje() {
	return fechaDeViaje;
}

public void setFechaDeViaje(Date fechaDeViaje) {
	this.fechaDeViaje = fechaDeViaje;
}



}
