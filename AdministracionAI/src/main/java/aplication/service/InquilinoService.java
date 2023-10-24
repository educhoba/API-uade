package aplication.service;

import aplication.model.Edificio;
import aplication.model.Inquilino;
import aplication.repository.IDuenioRepository;
import aplication.repository.IImagenRespository;
import aplication.repository.IInquilinoRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class InquilinoService implements IService<Inquilino,Inquilino> {
    private IInquilinoRepositoy iRepository;

    @Autowired
    public InquilinoService(IInquilinoRepositoy iRepository){
        this.iRepository=iRepository;
    }
    @Override
    public List<Inquilino> listar() {
        return iRepository.findAll();
    }

    @Override
    public Inquilino guardar(Inquilino inquilino) {
        if(inquilino.getDocumento()==null || inquilino.getIdentificador() <= 0) {
            return null;
        }
        return iRepository.save(inquilino);
    }

    @Override
    public Inquilino buscarPorCodigo(Long id) {
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
    /*
    public List<Inquilino> buscarPorDocumento(String documento) {
        List<Inquilino> ret = iRepository.findByDocumento(documento);
        return ret;
    }
    */

}
