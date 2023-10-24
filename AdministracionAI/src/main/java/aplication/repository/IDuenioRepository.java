package aplication.repository;
import aplication.model.Duenio;
import aplication.model.Inquilino;
import aplication.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface IDuenioRepository extends JpaRepository<Duenio,Long> {
    public List<Duenio> findByDocumento(String documento);
    public Optional<Duenio> findByDocumentoAAndIdentificador(String documento, String identificador);
}
