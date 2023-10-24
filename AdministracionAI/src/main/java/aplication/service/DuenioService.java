package aplication.service;

import aplication.model.Duenio;
import aplication.model.Edificio;
import aplication.model.Inquilino;
import aplication.repository.IDuenioRepository;
import aplication.repository.IEdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DuenioService implements IService<Duenio,Duenio>{
    private IDuenioRepository iRepository;

    @Autowired
    public DuenioService(IDuenioRepository iRepository){
        this.iRepository=iRepository;
    }

    @Override
    public List<Duenio> listar() {
        return iRepository.findAll();
    }

    @Override
    public Duenio guardar(Duenio entity) {
        return iRepository.save(entity);
    }

    @Override
    public Duenio buscarPorCodigo(Long id) {
        Optional<Duenio> ret = iRepository.findById(id);
        return ret.orElse(null);
    }

    @Override
    public void eliminarPorId(Long id) {
         iRepository.deleteById(id);
    }
    @Override
    public void eliminar(Duenio entity) {
        iRepository.delete(entity);
    }
    public List<Duenio> buscarPorDocumento(String documento) {
        return iRepository.findByDocumento(documento);
    }
}
