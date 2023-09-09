package aplication.service;

import aplication.model.Persona;
import aplication.repository.IPersonaRepository;
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
public class PersonaService implements IService<Persona, Persona> {
    private IPersonaRepository iRepository;

    @Override
    public List<Persona> listar() {
        return null;
    }

    @Override
    public Persona guardar(Persona item) {
        return null;
    }

    @Override
    public Persona buscar(Long id) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public Persona modificar(Long id, Persona i) {
        return null;
    }
}