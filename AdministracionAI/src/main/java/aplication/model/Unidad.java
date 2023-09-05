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

/*

    @ManyToOne
    @JoinColumn(name = "codigoEdificio",referencedColumnName = "codigo")
    private Edificio edificio;
*/

    public Unidad() {

    }

    public Integer getIdentificador() { return identificador;  }
    public void setdentificador(Integer identificadorNuevo) {
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
