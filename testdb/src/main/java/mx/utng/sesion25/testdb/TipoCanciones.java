package mx.utng.sesion25.testdb;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class TipoCanciones {

    //Primer atributo
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private int id; 

//Segundo ATRIBUTO
      @Column(length = 30,nullable = false)
    private String name; 

//Tercer atributo
    @Column(nullable = false)
    private TypeCanciones type;  
    
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public TypeCanciones getType() {
        return type;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(TypeCanciones type) {
        this.type = type;
    }
}
