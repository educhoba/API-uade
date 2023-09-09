package aplication.model;

import jakarta.persistence.*;

@Entity
@Table(name="edificios")
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String nombre;
    private String descripcion;
/*
    @OneToMany
    @JoinColumn(name = "codigo",referencedColumnName = "codigoEdificio")
    private Unidad unidad;
*/
 /*
    @OneToMany
    @JoinColumn(name = "codigo",referencedColumnName = "codigoEdificio")
    private Reclamo reclamo;
    */

    public Edificio(){

    }

    //<editor-fold desc="Getters">
    public int getCodigo(){
        return codigo;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    //</editor-fold>

    //<editor-fold desc="Setters">

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setDescripcion(String desc){
        descripcion = desc;
    }
    //</editor-fold>
}
