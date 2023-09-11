package aplication.repository;

import aplication.model.Imagen;
import aplication.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IImagenRespository extends JpaRepository<Imagen,Long> {
}
