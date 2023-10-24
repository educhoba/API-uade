package aplication.repository;

import aplication.model.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUnidadRepository extends JpaRepository<Unidad,Long> {
    //List<Beneficio> findAllByProducto_Id(Long id);
    public Optional<Unidad> findByIdentificador(Integer identificador);
    public Optional<Unidad> findByCodigoEdificioAndPisoAndNumero(Integer codigoEdificio, String piso, String numero);


}
