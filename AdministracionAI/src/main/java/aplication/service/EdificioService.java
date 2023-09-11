package aplication.service;

import aplication.model.Edificio;
import aplication.repository.IEdificioRepository;
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
public class EdificioService implements IService<Edificio,Edificio> {
    private IEdificioRepository iEdificioRepository;

    @Override
    public List<Edificio> listar() {
        return null;
    }

    @Override
    public Edificio guardar(Edificio item) {
        return null;
    }

    @Override
    public Edificio buscar(Long id) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public Edificio modificar(Long id, Edificio i) {
        return null;
    }
}