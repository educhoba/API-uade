package aplication.repository;

import aplication.model.Duenio;
import aplication.model.Inquilino;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface IInquilinoRepositoy extends JpaRepository<Inquilino,Long> {
    public List<Inquilino> findByDocumento(String documento);

    public List<Inquilino> findByIdentificador(int identificador);
}
