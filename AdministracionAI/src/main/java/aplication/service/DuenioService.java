package aplication.service;

import aplication.model.Duenio;
import aplication.model.Edificio;
import aplication.model.Inquilino;
import aplication.repository.IDuenioRepository;
import aplication.repository.IEdificioRepository;

import java.util.List;
import java.util.Optional;

public class DuenioService implements IService<Duenio,Duenio>{
    private IDuenioRepository iRepository;

    @Override
    public List<Duenio> listar() {
        return iRepository.findAll();
    }

    @Override
    public Duenio guardar(Duenio entity) {
        return iRepository.save(entity);
    }

    @Override
    public Duenio buscarPorId(Long id) {
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
    public Duenio buscarPorDocumento(String documento) {
        Optional<Duenio> ret = iRepository.findByDocumento(documento);
        return ret.orElse(null);
    }
}
