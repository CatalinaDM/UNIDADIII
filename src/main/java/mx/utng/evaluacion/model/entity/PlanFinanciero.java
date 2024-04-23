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
 public class PlanFinanciero {
     
     @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
     private Long id;
 
     @NotEmpty
     @Column(length = 30)
     private String nombrePlan; 
 
     @NotEmpty
     @Column(length = 30)
     private String descripcion; 
 

@NotNull
     private Float monto; 
     
     @Temporal(TemporalType.TIMESTAMP)
     private Date fechaEstimada;
 
 @PrePersist
 public void prePersist(){
     fechaEstimada = new Date();
 }
 
 public Long getId() {
     return id;
 }
 
 public void setId(Long id) {
     this.id = id;
 }

public String getNombrePlan() {
	return nombrePlan;
}

public void setNombrePlan(String nombrePlan) {
	this.nombrePlan = nombrePlan;
}

public String getDescripcion() {
	return descripcion;
}

public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}

public Float getMonto() {
	return monto;
}


public Date getFechaEstimada() {
	return fechaEstimada;
}

public void setFechaEstimada(Date fechaEstimada) {
	this.fechaEstimada = fechaEstimada;
}

public void setMonto(Float monto) {
	this.monto = monto;
}

 }
 