package aplication.repository;

import aplication.model.Inquilino;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface IInquilinoRepositoy extends JpaRepository<Inquilino,Long> {
    public Optional<Inquilino> findByDocumento(String documento);
}
