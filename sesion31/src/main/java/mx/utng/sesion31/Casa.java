package mx.utng.sesion31;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Casa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    private String jefeDeFamilia;

    @ElementCollection
    @Column(name="Integrante")
    private Collection<String> otros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJefeDeFamilia() {
        return jefeDeFamilia;
    }

    public void setJefeDeFamilia(String jefeDeFamilia) {
        this.jefeDeFamilia = jefeDeFamilia;
    }

    public Collection<String> getOtros() {
        return otros;
    }

    public void setOtros(Collection<String> otros) {
        this.otros = otros;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((jefeDeFamilia == null) ? 0 : jefeDeFamilia.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Casa other = (Casa) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (jefeDeFamilia == null) {
            if (other.jefeDeFamilia != null)
                return false;
        } else if (!jefeDeFamilia.equals(other.jefeDeFamilia))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Casa [id=" + id + ", jefeDeFamilia=" + jefeDeFamilia + ", otros=" + otros + "]";
    }
}
 
//hashCode  sirve para comparar si es o no el objeto que se esta buscando 