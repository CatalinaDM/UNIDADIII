package mx.utng.sesion25.testdb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pokemon {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @Column(length = 50,nullable = false)
    private String name; 
    @Column(nullable = false)
    private Type type;    

    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Type getType() {
        return type;
    }
    
}
