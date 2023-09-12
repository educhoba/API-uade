package aplication.service;

import aplication.model.Edificio;
import aplication.model.Inquilino;
import aplication.repository.IDuenioRepository;
import aplication.repository.IInquilinoRepositoy;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;

public class InquilinoService implements IService<Inquilino,Inquilino> {
    private IInquilinoRepositoy iRepository;
    @Override
    public List<Inquilino> listar() {
        return iRepository.findAll();
    }

    @Override
    public Inquilino guardar(Inquilino entity) {
        return iRepository.save(entity);
    }

    @Override
    public Inquilino buscarPorId(Long id) {
        Optional<Inquilino> ret = iRepository.findById(id);
        return ret.orElse(null);
    }

    @Override
    public void eliminarPorId(Long id) {
        iRepository.deleteById(id);
    }

    @Override
    public void eliminar(Inquilino entity) {
        iRepository.delete(entity);
    }
    public List<Inquilino> buscarPorDocumento(String documento) {
        List<Inquilino> ret = iRepository.findByDocumento(documento);
        return ret;
    }
}
