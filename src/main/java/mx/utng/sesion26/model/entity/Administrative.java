/**
 * @autor:Carmen Catalina Delgado Manzano 
 * @category:GDS0622
 * @since: 17-03-2024
 */

package mx.utng.sesion26.model.entity;

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
public class Administrative {
    
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

     @NotEmpty //    NO ACEPTA VALORES NULL
    @Column (length = 90)
    private String name; 

    @NotEmpty
    @Column(length = 30)
    private String lastName; 

    @NotEmpty
    @Column(length = 30)
    private String jobTitle; 

    @NotEmpty
    @Column(length = 20)
    private String phone;

    @NotEmpty(message = "La dirección es requerida")
    @Column(length = 50)
    private String address;

    @Min(1)
    @Max(48)
    private Float hours; 
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date recordAt;

@PrePersist
public void prePersist(){
    recordAt = new Date();
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}

public String getPhone() {
    return phone;
}

public void setPhone(String phone) {
    this.phone = phone;
}

public String getAddress() {
    return address;
}

public void setAddress(String address) {
    this.address = address;
}

public Date getRecordAt() {
    return recordAt;
}

public void setRecordAt(Date recordAt) {
    this.recordAt = recordAt;
}

public String getJobTitle() {
    return jobTitle;
}

public void setJobTitle(String jobTitle) {
    this.jobTitle = jobTitle;
}

public Float getHours() {
    return hours;
}

public void setHours(Float hours) {
    this.hours = hours;
}

}
