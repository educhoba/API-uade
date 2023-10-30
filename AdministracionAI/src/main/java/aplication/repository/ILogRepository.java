package aplication.repository;

import aplication.model.Duenio;
import aplication.model.Inquilino;

import aplication.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ILogRepository extends JpaRepository<Log,Long> {
    public List<Log> findByIdLog(int IdLog);

}
