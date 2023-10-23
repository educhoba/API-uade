package aplication.service;

import aplication.model.Imagen;
import aplication.repository.IDuenioRepository;
import aplication.repository.IImagenRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImagenService implements IService<Imagen, Imagen> {
    private IImagenRespository iRepository;
    @Autowired
    public ImagenService(IImagenRespository iRepository){
        this.iRepository=iRepository;
    }
    @Override
    public List<Imagen> listar() {
        return iRepository.findAll();
    }

    @Override
    public Imagen guardar(Imagen imagen) {
        if( imagen.getPath() == null || imagen.getIdReclamo()==null || imagen.getTipo()==null) {
            return null;
        }
        return iRepository.save(imagen);
    }

    @Override
    public Imagen buscarPorCodigo(Long id) {
        Optional<Imagen> ret = iRepository.findById(id);
        return ret.orElse(null);
    }

    @Override
    public void eliminarPorId(Long id) {
        iRepository.deleteById(id);
    }

    @Override
    public void eliminar(Imagen entity) {
        iRepository.delete(entity);
    }



}