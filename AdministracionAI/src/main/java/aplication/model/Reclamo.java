package aplication.model;

import jakarta.persistence.*;

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
/*
    @ManyToOne
    @JoinColumn(name = "documento", referencedColumnName = "documento", insertable = false, updatable = false)
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    private Edificio edificio;
*/
    public Reclamo(){

    }
/*
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
*/
}
