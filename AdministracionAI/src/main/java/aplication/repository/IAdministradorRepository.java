package aplication.repository;
import aplication.model.Administrador;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IAdministradorRepository extends JpaRepository<Administrador,Long> {
    public List<Administrador> findByDocumento(String documento);

    //public Optional<Duenio> findByDocumentoAndIdentificador(String documento, String identificador);
}