package aplication.model;

import jakarta.persistence.*;

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



    public Edificio(){

    }
    public Edificio(Integer id, String nombre, String direccion){
        this.codigo=id;
        this.nombre=nombre;
        this.direccion=direccion;

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
    //</editor-fold>

    //<editor-fold desc="Setters">

    public void setNombre(String nombre){
        this.nombre = nombre;
    }



    public void setDireccion(String desc){
        direccion = desc;
    }
    //</editor-fold>
}
