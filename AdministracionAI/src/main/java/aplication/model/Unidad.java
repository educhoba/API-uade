package aplication.model;

import aplication.views.UnidadView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="unidades")
public class Unidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identificador;
    private String piso;
    private String numero;
    private String habitado;
    private Integer codigoEdificio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigoEdificio", referencedColumnName = "codigo", insertable = false, updatable = false)
    private Edificio edificio;


    @OneToMany(mappedBy = "unidad")
    @JsonIgnore
    private List<Reclamo> reclamos;

    @OneToMany(mappedBy = "unidad")
    @JsonIgnore
    private List<Inquilino> inquilinos;

    @OneToMany(mappedBy = "unidad")
    @JsonIgnore
    private List<Duenio> duenios;

    public Unidad() {

    }

    // Getters y setters

    public Edificio getEdificio() {
        return this.edificio;
    }

    public Integer getIdentificador() { return identificador;  }
    public void setIentificador(Integer identificadorNuevo) {
        this.identificador=identificadorNuevo;
        return;
    }

    public String getPiso() {
        return this.piso;
    }
    public void setPiso(String pisoNuevo) {
        this.piso=pisoNuevo;
        return;
    }

    private void setHabitado(String habitadoNuevo) {
        this.habitado=habitadoNuevo;
        return;
    }

    public String getNumero(){return this.numero;}


    public UnidadView toView() {
        return null; //todo
    }

    public List<Persona> getDuenios() {
        List<Persona> resultado = new ArrayList<Persona>();
        for (Duenio d : this.duenios) {
            if(d != null)
                resultado.add(d.getPersona());
        }
        return resultado;
    }

    public List<Persona> getInquilinos() {
        List<Persona> resultado = new ArrayList<Persona>();
        for (Inquilino i : this.inquilinos) {
            if(i != null)
                resultado.add(i.getPersona());
        }
        return resultado;
    }

    public void transferir(Persona persona) {
        //todo
    }

    public void agregarDuenio(Persona persona) {
        //todo
    }

    public void alquilar(Persona persona) {
        //todo
    }

    public void agregarInquilino(Persona persona) {
        //todo
    }

    public void liberar() {
        this.setHabitado("N");
    }

    public void habitar() {
        this.setHabitado("Y");
    }
    public boolean estaHabitada(){return this.habitado == "Y";}
}
