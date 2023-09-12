package aplication.repository;
import aplication.model.Duenio;
import aplication.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IDuenioRepository extends JpaRepository<Duenio,Long> {
}
