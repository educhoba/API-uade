package aplication.service;

import aplication.model.Imagen;
import aplication.model.Inquilino;
import aplication.repository.IDuenioRepository;
import aplication.repository.IImagenRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
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

    public List<Imagen> buscarPorIdReclamo(Integer id) {
        List<Imagen> ret = iRepository.findAll();
        List<Imagen> imagenes = new LinkedList<Imagen>();

        for (Imagen imag : ret) {
            if (imag.getIdReclamo() == id)
                imagenes.add(imag);
        }
        return imagenes;
    }


    @Override
    public void eliminarPorId(Long id) {
        iRepository.deleteById(id);
    }

    @Override
    public void eliminar(Imagen entity) {
        iRepository.delete(entity);
    }

    @Override
    public Imagen modificar(Imagen imagen, String cambio) {
        //hacer
        return null;
    }




}