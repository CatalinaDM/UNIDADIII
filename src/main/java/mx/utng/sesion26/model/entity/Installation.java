package mx.utng.sesion26.model.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
/**
 * @autor:Carmen Catalina Delgado Manzano 
 * @category:GDS0622
 * @since: 17-03-2024
 */

@Entity
public class Installation {
    
    @Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

     @NotEmpty //    NO ACEPTA VALORES NULL
    @Column (length = 90)
    private String buildingName; 

    @NotEmpty
    @Column(length = 30)
    private String location; 

    @NotEmpty
    @Column(length = 30)
    private String condition; 

    @NotEmpty
    @Column(length = 2)
    private String floor;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }


}
