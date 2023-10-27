package aplication.model;

import aplication.exceptions.UnidadException;
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
    private List<Inquilino> inquilinos;

    @OneToMany(mappedBy = "unidad")
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

    public Inquilino alquilar(Persona persona) throws UnidadException {
        if(!estaAlquilada())
            return agregarInquilinoPrivate(persona);
        else
            throw new UnidadException("Ya está alquilada.");
    }

    //todo testear
    public Inquilino agregarInquilino(Persona persona) throws UnidadException{
        if(estaAlquilada()){
            return agregarInquilinoPrivate(persona);
        }
        else
            throw new UnidadException("No está alquilada.");
    }

    private Inquilino agregarInquilinoPrivate(Persona persona) throws UnidadException {
        List<Persona> inq = this.getInquilinos();
        List<Persona> due = this.getDuenios();
        if(due.contains(persona))
            throw new UnidadException("No se puede alquilar al duenio.");
        if(!inq.contains(persona)) {
            Inquilino nuevoInquilino = new Inquilino(persona,this);
            this.inquilinos.add(nuevoInquilino);
            return nuevoInquilino;
        }
        else
            throw new UnidadException("Esa persona ya está alquilando.");
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
