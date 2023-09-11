package aplication.service;

import aplication.model.Imagen;
import aplication.repository.IImagenRespository;
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
public class ImagenService implements IService<Imagen, Imagen> {
    private IImagenRespository iImagenRepository;

    @Override
    public List<Imagen> listar() {
        return null;
    }

    @Override
    public Imagen guardar(Imagen item) {
        return null;
    }

    @Override
    public Imagen buscar(Long id) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public Imagen modificar(Long id, Imagen i) {
        return null;
    }
}