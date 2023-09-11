package aplication.service;

import aplication.model.Reclamo;
import aplication.repository.IReclamoRepository;
import aplication.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import aplication.model.Unidad;
import aplication.repository.IUnidadRepository;

import java.util.List;

@Service
@Transactional
public class ReclamoService implements IService<Reclamo, Reclamo> {
    private IReclamoRepository iRepository;

    @Override
    public List<Reclamo> listar() {
        return null;
    }

    @Override
    public Reclamo guardar(Reclamo item) {
        return null;
    }

    @Override
    public Reclamo buscar(Long id) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public Reclamo modificar(Long id, Reclamo i) {
        return null;
    }
}