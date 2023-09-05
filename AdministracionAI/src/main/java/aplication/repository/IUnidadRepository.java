package aplication.repository;

import aplication.model.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUnidadRepository extends JpaRepository<Unidad,Long> {
    //List<Beneficio> findAllByProducto_Id(Long id);
}
