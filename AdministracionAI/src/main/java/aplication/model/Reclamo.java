package aplication.model;

import aplication.views.Estado;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="reclamos")
public class Reclamo {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReclamo;

    @Column(name = "documento", length = 20, nullable = false)
    private String documento;

    @Column(name = "codigo", nullable = false)
    private int codigo;

    @Column(name = "ubicacion", length = 300)
    private String ubicacion;

    @Column(name = "descripcion", length = 1000)
    private String descripcion;

    @Column(name = "identificador")
    private int identificador;

    // edifico reclamo
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    private Edificio edificio;

    // persona reclamo
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "documento", referencedColumnName = "documento", insertable = false, updatable = false)
    private Persona persona;


    @ManyToOne
    @JoinColumn(name = "identificador", referencedColumnName = "identificador", insertable = false, updatable = false)
    private Unidad unidad;


    @OneToMany(mappedBy = "reclamo")
    @JsonIgnore
    private List<Imagen> imagens;


    public Reclamo() {

    }

    public Reclamo(Persona persona, Edificio edificio, String ubicacion, String descripcion, Unidad unidad){

    }


    public int getIdentificador() {
        return this.identificador;
    }

    public void agregarImagen(String direccion, String tipo) {
        //todo
    }

    public void cambiarEstado(Estado estado) {
        //todo
    }

    public Edificio getEdificio() {
        return this.edificio;
    }
    public Persona getPersona() {
        return this.persona;
    }






    //<editor-fold desc="Getters">
    public String getDocumento() {
        return documento;
    }
    public int getCodigo(){
        return codigo;
    }
    public String getUbicacion(){
        return ubicacion;
    }
    public String getDescripcion(){
        return descripcion;
    }

    //</editor-fold>

    //<editor-fold desc="Setters">
    public void setCodigo(int codigoEdificio){
        codigo = codigoEdificio;
    }
    public void setDocumento(String doc){
        documento = doc;
    }
    public void setDescripcion(String desc){
        descripcion = desc;
    }
    public void setUbicacion(String ubicacion){
        this.ubicacion = ubicacion;
    }
    public void setIdentificador(int id){
        identificador = id;
    }
    //</editor-fold>

}
