package aplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "duenios")
public class Duenio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "identificador", nullable = false)
    private int identificador;

    @Column(name = "documento", length = 20, nullable = false)
    @JsonIgnore
    private String documento;

    @ManyToOne
    @JoinColumn(name = "documento", referencedColumnName = "documento", insertable = false, updatable = false)
    private Persona persona;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "identificador", referencedColumnName = "identificador", insertable = false, updatable = false)
    private Unidad unidad;

    public Duenio(){

    }
    public Duenio(Persona p, Unidad u){
        identificador = u.getIdentificador();
        documento = p.getDocumento();
        persona = p;
        unidad = u;
    }
    public Persona getPersona() {
        return this.persona;
    }

    public Unidad getUnidad() {
        return this.unidad;
    }


    public int getId() {
        return id;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

}