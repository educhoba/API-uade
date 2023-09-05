package aplication.service;

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
public class UnidadService implements IService<Unidad, Unidad> {
    private IUnidadRepository iUnidadRepository;


    @Autowired
    public UnidadService(IUnidadRepository iUnidadRepositor) {
        this.iUnidadRepository = iUnidadRepository;

    }

    @Override
    public List<Unidad> listar() {
        return iUnidadRepository.findAll();
    }

    @Override
    public Unidad guardar(Unidad unidad) {
        return iUnidadRepository.save(unidad);
    }
    @Override
    public Unidad buscar(Long identificador) {
        return iUnidadRepository.findById(identificador).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void eliminar(Long identificador) {
        this.buscar(identificador);
        iUnidadRepository.deleteById(identificador);
    }


    //aca en el segundo (dto) tendria que ir el dto nuevo de la unidad
    //por ahora creamos un objeto nuevo unidad y se lo asignamos a esto
    @Override
    public Unidad modificar(Long identificador, Unidad dto) {
        Unidad uni = this.buscar(identificador);
        return this.guardar(dto);
    }
    public Unidad save(Unidad unidad){
        return iUnidadRepository.save(unidad);
    }


}