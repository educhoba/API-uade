package aplication.model;

import jakarta.persistence.*;

@Entity
@Table(name="imagenes")
public class Imagen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numero;
    private String path;
    private String tipo;
    private Integer idReclamo;

    /*
        @ManyToOne
       @JoinColumn(name = "idReclamo",referencedColumnName = "idReclamo")
       private Reclamo reclamo;
       */

    public Imagen(){

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
