package aplication.repository;

import aplication.model.Duenio;
import aplication.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IPersonaRepository extends JpaRepository<Persona,Long> {
    public Optional<Persona> findByDocumento(String documento);
    public Optional<Persona>  findByMail(String mail);

}
