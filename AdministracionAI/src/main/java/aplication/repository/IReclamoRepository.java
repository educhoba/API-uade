package aplication.repository;

import aplication.model.Reclamo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReclamoRepository extends JpaRepository<Reclamo, Long> {
}
