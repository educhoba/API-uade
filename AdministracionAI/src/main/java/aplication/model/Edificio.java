package aplication.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name="edificios")
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "direccion", length = 100, nullable = false)
    private String direccion;

    @OneToMany(mappedBy = "edificio")
    @JsonIgnore
    private List<Reclamo> reclamos;


   // @JsonIgnore
   //@OneToMany(mappedBy = "edificio")
    //@JoinColumn(name = "codigoEdificio", referencedColumnName = "codigo", insertable = false, updatable = false)
    @OneToMany(mappedBy = "edificio")
    //@JoinColumn(name="codigoEdificio")
    @JsonIgnore
    private List<Unidad> unidades;


    public Edificio(){

    }

    //<editor-fold desc="Getters">
    public Integer getCodigo(){
        return codigo;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getDireccion(){
        return this.direccion;
    }
    public List<Unidad> getUnidades(){
        return this.unidades;
    }
    //</editor-fold>

    //<editor-fold desc="Setters">

    public List<Persona> habilitados() {
        List<Persona> resultado = new ArrayList<Persona>();
        List<Unidad> unidades = this.unidades;

        List<Persona> duenioAux = new ArrayList<Persona>();
        List<Persona> inqAux = new ArrayList<Persona>();
        for (Unidad u : unidades) {
            duenioAux = u.getDuenios();
            if(duenioAux != null)
                resultado.addAll(duenioAux);
            inqAux = u.getInquilinos();
            if(inqAux != null)
                resultado.addAll(inqAux);
        }
        return resultado;
    }

    public List<Persona> duenios() {
        List<Persona> resultado = new ArrayList<Persona>();
        List<Unidad> unidades = this.unidades;

        List<Persona> duenioAux = new ArrayList<Persona>();
        for (Unidad u : unidades) {
            duenioAux = u.getDuenios();
            if(duenioAux != null)
                resultado.addAll(duenioAux);
        }
        return resultado;
    }
    //si tiene inquilino ignoro al duenio como habitante
    public List<Persona> habitantes() {
        List<Persona> resultado = new ArrayList<Persona>();
        List<Unidad> unidades = this.unidades;

        List<Persona> duenioAux = new ArrayList<Persona>();
        List<Persona> inqAux = new ArrayList<Persona>();
        for (Unidad u : unidades) {
            if(u.estaHabitada()){
                inqAux = u.getInquilinos();
                if(inqAux != null)
                    resultado.addAll(inqAux);
                else{
                    duenioAux = u.getDuenios();
                    if(duenioAux != null)
                        resultado.addAll(duenioAux);
                }
            }
        }
        return resultado;
    }

    //</editor-fold>
}
