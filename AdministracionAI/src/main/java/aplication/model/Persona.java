package aplication.model;

import aplication.views.PersonaView;
import jakarta.persistence.*;

@Entity
@Table(name="personas")
public class Persona {
    @Id
    @Column(name = "documento", length = 20, nullable = false)
    private String documento;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "mail", length = 100)
    private String mail;

    @Column(name = "contrasenia", length = 100)
    private String contrasenia;

    /*
     @OneToOne
    @JoinColumn(name = "documento",referencedColumnName = "documento")
    private Persona personas;
    */
    public Persona(String documento, String nombre, String mail, String contrasenia){
        this.documento= documento;
        this.nombre= nombre;
        this.mail= mail;
        this.contrasenia= contrasenia;
    }
    public Persona(){

    }
    //<editor-fold desc="Getters">
    public String getDocumento(){
        return documento;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getMail(){
        return this.mail;
    }
    public String getContrasenia(){
        return this.contrasenia;
    }
    //</editor-fold>

    //<editor-fold desc="Setters">

    public void setNombre(String documento){
        this.documento = documento;
    }
    public void setDocumento(String nombre){
        this.nombre = nombre;
    }
    public void setMail(String mail){
        this.mail = mail;
    }
    public void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia;
    }

    public PersonaView toView() {
        return null;
        //todo
    }
    //</editor-fold>
}
