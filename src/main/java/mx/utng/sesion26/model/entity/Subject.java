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
public class Subject {
    
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

     @NotEmpty //    NO ACEPTA VALORES NULL
    @Column (length = 90)
    private String subjectName; 

     @Min(1)
     @Max(2)
    private Float semester;

    @NotEmpty
    @Column (length = 3)
    private String units;

    @Min(1)
    @Max(89)
    private Float semesterHours; 

    @NotEmpty
    @Column (length = 25)
    private String level; 
    
    
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

public String getSubjectName() {
    return subjectName;
}

public void setSubjectName(String subjectName) {
    this.subjectName = subjectName;
}

public Float getSemester() {
    return semester;
}

public void setSemester(Float semester) {
    this.semester = semester;
}

public String getUnits() {
    return units;
}

public void setUnits(String units) {
    this.units = units;
}

public Float getSemesterHours() {
    return semesterHours;
}

public void setSemesterHours(Float semesterHours) {
    this.semesterHours = semesterHours;
}

public String getLevel() {
    return level;
}

public void setLevel(String level) {
    this.level = level;
}

public Date getRecordAt() {
    return recordAt;
}

public void setRecordAt(Date recordAt) {
    this.recordAt = recordAt;
}



}
