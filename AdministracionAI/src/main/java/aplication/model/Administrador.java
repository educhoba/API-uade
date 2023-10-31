package aplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(name = "administradores")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "documento", length = 20, nullable = false)
    @JsonIgnore
    private String documento;

    @ManyToOne
    @JoinColumn(name = "documento", referencedColumnName = "documento", insertable = false, updatable = false)
    private Persona persona;

    public Administrador(){

    }


    public Administrador(Persona p){
        documento = p.getDocumento();
        persona = p;
    }
    public Persona getPersona() {
        return this.persona;
    }



    public int getId() {
        return id;
    }



    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

}