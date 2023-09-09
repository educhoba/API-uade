package aplication.model;

import jakarta.persistence.*;

@Entity
@Table(name="personas")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String documento;
    private String nombre;
    private String mail;
    private String contrasenia;

    /*
     @OneToOne
    @JoinColumn(name = "documento",referencedColumnName = "documento")
    private Persona personas;
    */
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
    //</editor-fold>
}
