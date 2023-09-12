package aplication.repository;
import aplication.model.Duenio;
import aplication.model.Inquilino;
import aplication.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface IDuenioRepository extends JpaRepository<Duenio,Long> {
    public Optional<Duenio> findByDocumento(String documento);
}
