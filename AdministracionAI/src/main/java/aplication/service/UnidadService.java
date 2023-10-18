package aplication.service;

import aplication.model.Edificio;
import aplication.repository.IReclamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import aplication.model.Unidad;
import aplication.repository.IUnidadRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UnidadService implements IService<Unidad, Unidad> {
    private IUnidadRepository iRepository;
    @Autowired
    public UnidadService(IUnidadRepository iRepository){
        this.iRepository=iRepository;
    }
    @Override
    public List<Unidad> listar() {
        return iRepository.findAll();
    }

    @Override
    public Unidad guardar(Unidad entity) {
        return iRepository.save(entity);

    }


    @Override
    public Unidad buscarPorId(Long id) {
        Optional<Unidad> ret = iRepository.findById(id);
        return ret.orElse(null);
    }
/*
    @Override
    public Edificio buscarEdificioDeUnidad() {
        Optional<Edificio> ret = this.getEdificio();
        return ret.orElse(null);
    }
*/
    @Override
    public void eliminarPorId(Long id) {
        iRepository.deleteById(id);
    }

    @Override
    public void eliminar(Unidad entity) {
        iRepository.delete(entity);
    }







/*
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
    public Unidad buscarPorId(Long identificador) {
        return iUnidadRepository.findById(identificador).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void eliminarPorId(Long identificador) {
        this.buscarPorId(identificador);
        iUnidadRepository.deleteById(identificador);
    }


    //aca en el segundo (dto) tendria que ir el dto nuevo de la unidad
    //por ahora creamos un objeto nuevo unidad y se lo asignamos a esto
    @Override
    public Unidad modificar(Long identificador, Unidad dto) {
        Unidad uni = this.buscarPorId(identificador);
        return this.guardar(dto);
    }
    public Unidad save(Unidad unidad){
        return iUnidadRepository.save(unidad);
    }
*/

}