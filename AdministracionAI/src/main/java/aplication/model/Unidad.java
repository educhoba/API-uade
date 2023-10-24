package aplication.model;

import aplication.views.UnidadView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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
    public String getPiso() {
        return this.piso;
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
    public List<Reclamo> getReclamos() {
        return this.reclamos;
    }
    //todo testear
    public void transferir(Persona persona) {
        //eliminar duenios
        this.duenios = new ArrayList<Duenio>();
        this.duenios.add(new Duenio(persona,this));
    }
    //todo testear
    public void agregarDuenio(Persona persona) {
        List<Persona> due = this.getDuenios();
        if(!due.contains(persona)) {
            this.duenios.add(new Duenio(persona,this));
        }
    }
    //todo testear
    public void alquilar(Persona persona) {
        if(!estaAlquilada())
            agregarInquilino(persona);
    }

    //todo testear
    public void agregarInquilino(Persona persona) {
        List<Persona> inq = this.getInquilinos();
        if(!inq.contains(persona)) {
            this.inquilinos.add(new Inquilino(persona,this));
        }
    }
    //todo testear
    public void liberar() {
        this.setHabitado("N");
    }
    //todo testear
    public void habitar() {
        this.setHabitado("Y");
    }
    //todo testear
    public boolean estaHabitada(){return Objects.equals(this.habitado, "Y");}
    //todo testear
    public boolean estaAlquilada(){
        List<Persona> inq = this.getInquilinos();
        return inq != null && !inq.isEmpty();
    }
}
