package aplication.model;


import aplication.views.PersonaView;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="logs")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idLog;


    @Column(name = "mail", length = 100)
    private String mail;

    @Column(name = "operacion", length = 100)
    private String operacion;

    public Log(){

    }

    public Log(Integer idLog, String mail, String operacion){
        this.idLog= idLog;
        this.mail= mail;
        this.operacion= operacion;
    }

    public Integer getIdLog(){
        return idLog;
    }
    public String getMail(){
        return this.mail;
    }
    public String getOperacion(){
        return this.operacion;
    }


    public void setIdLog(Integer idLog){
        this.idLog = idLog;
    }

    public void setMail(String mail){
        this.mail = mail;
    }
    public void setOperacion(String operacion){
        this.operacion = operacion;
    }




}
