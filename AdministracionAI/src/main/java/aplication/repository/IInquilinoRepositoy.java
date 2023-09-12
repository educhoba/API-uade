package aplication.repository;

import aplication.model.Inquilino;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IInquilinoRepositoy extends JpaRepository<Inquilino,Long> {
}
