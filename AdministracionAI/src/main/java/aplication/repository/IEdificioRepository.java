package aplication.repository;

import aplication.model.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IEdificioRepository extends JpaRepository<Edificio,Long> {

}

