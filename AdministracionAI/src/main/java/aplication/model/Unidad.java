package aplication.model;

import jakarta.persistence.*;


@Entity
@Table(name="unidades")
public class Unidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identificador;
    private String piso;
    private String numero;
    private String habitado;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigoEdificio", referencedColumnName = "codigo", insertable = false, updatable = false)
    private Edificio edificio;

    public Unidad() {

    }

    // Getters y setters

    public Edificio getEdificio() {
        return this.edificio;
    }

    public Integer getIdentificador() { return identificador;  }
    public void setIentificador(Integer identificadorNuevo) {
        this.identificador=identificadorNuevo;
        return;
    }

    public String getPiso() {
        return this.piso;
    }
    public void setPiso(String pisoNuevo) {
        this.piso=pisoNuevo;
        return;
    }


    public String getHabitado(){return this.habitado;}
    public void setHabitado(String habitadoNuevo) {
        this.habitado=habitadoNuevo;
        return;
    }

    public String getNumero(){return this.numero;}
    public void setNumero(String numeroNuevo) {
        this.numero=numeroNuevo;
        return;
    }


}
