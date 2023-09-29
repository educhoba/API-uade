package aplication.service;

import aplication.model.Edificio;
import aplication.model.Unidad;
import aplication.repository.IEdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EdificioService implements IService<Edificio,Edificio> {
    private IEdificioRepository iRepository;

    @Autowired
    public EdificioService(IEdificioRepository iRepository){
        this.iRepository=iRepository;
    }

    @Override
    public List<Edificio> listar() {
        return iRepository.findAll();
    }

    @Override
    public Edificio guardar(Edificio entity) {
        return iRepository.save(entity);
    }

    @Override
    public Edificio buscarPorId(Long id) {
        Optional<Edificio> ret = iRepository.findById(id);
        return ret.orElse(null);
    }

    @Override
    public void eliminarPorId(Long id) {
        iRepository.deleteById(id);
    }

    @Override
    public void eliminar(Edificio entity) {
        iRepository.delete(entity);
    }


    public List<Unidad> getUnidades() {
        return null; //todo
    }
}