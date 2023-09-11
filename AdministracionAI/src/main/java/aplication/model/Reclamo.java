package aplication.model;

import jakarta.persistence.*;

@Entity
@Table(name="reclamos")
public class Reclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReclamo;
    private String documento;
    private int codigo;
    private String ubicacion;
    private String descripcion;
    private int identificador;

    /*
    @ManyToOne
    @JoinColumn(name = "codigoEdificio",referencedColumnName = "codigo")
    private Edificio edificio;
    */
    /*
    @OneToMany
    @JoinColumn(name = "idReclamo",referencedColumnName = "idReclamo")
    private Imagen imagen;
    */
    /*
    @OneToOne
    @JoinColumn(name = "documento",referencedColumnName = "documento")
    private Persona personas;
    */
    public Reclamo(){

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
    public int getIdentificador() {
        return identificador;
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
