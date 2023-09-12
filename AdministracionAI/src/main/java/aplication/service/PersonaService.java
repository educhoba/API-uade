package aplication.service;

import aplication.model.Persona;
import aplication.repository.IPersonaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonaService implements IService<Persona, Persona> {
    private IPersonaRepository iRepository;

    @Override
    public List<Persona> listar() {
        return iRepository.findAll();
    }

    @Override
    public Persona guardar(Persona entity) {
        return iRepository.save(entity);
    }

    @Override
    public Persona buscarPorId(Long id) {
        Optional<Persona> ret = iRepository.findById(id);
        return ret.orElse(null);
    }

    @Override
    public void eliminarPorId(Long id) {
    iRepository.deleteById(id);
    }

    @Override
    public void eliminar(Persona entity) {
        iRepository.delete(entity);
    }

}