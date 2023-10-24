package aplication.model;

import jakarta.persistence.*;

@Entity
@Table(name="imagenes")
public class Imagen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numero")
    private Integer numero;

    @Column(name = "path", length = 300, nullable = false)
    private String path;

    @Column(name = "tipo", length = 10)
    private String tipo;

    @Column(name = "idReclamo")
    private Integer idReclamo;

    @ManyToOne
    @JoinColumn(name = "idReclamo", referencedColumnName = "idReclamo", insertable = false, updatable = false)
    private Reclamo reclamo;



    public Imagen(){

    }


    public Reclamo getReclamo() {
        return this.reclamo;
    }



    //<editor-fold desc="Getters">
    public Integer getNumero(){
        return numero;
    }
    public String getPath(){
        return this.path;
    }
    public String getTipo(){
        return this.tipo;
    }
    public Integer getIdReclamo(){
        return this.idReclamo;
    }
    //</editor-fold>

    //<editor-fold desc="Setters">

    public void setNumero(Integer numero){
        this.numero = numero;
    }
    public void setPath(String path){
        this.path = path;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setContrasenia(Integer idReclamo){
        this.idReclamo = idReclamo;
    }
    //</editor-fold>
}
