package aplication.service;

import aplication.exceptions.PersonaException;
import aplication.exceptions.UnidadException;
import aplication.model.Persona;
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
    public Unidad guardar(Unidad unidad) {
        return iRepository.save(unidad);
    }


    @Override
    public Unidad buscarPorCodigo(Long id) {
        Optional<Unidad> ret = iRepository.findById(id);
        return ret.orElse(null);
    }
    public Unidad buscarPorIdentificador(Integer identificador) throws UnidadException{
        Optional<Unidad> ret = iRepository.findByIdentificador(identificador);
        if(ret.isPresent())
        {
            return ret.get();
        }
        else
            throw new UnidadException("No existe una unidad con ese identificador.");
    }
    public Unidad buscarPorEdificioPisoNumero(Integer codigoEdificio, String piso, String numero) throws UnidadException{
        Optional<Unidad> ret = iRepository.findByCodigoEdificioAndPisoAndNumero(codigoEdificio,piso,numero);
        if(ret.isPresent())
        {
            return ret.get();
        }
        else
            throw new UnidadException("No existe una unidad.");
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
        //no se puede elminar una unidad
    }

    @Override
    public void eliminar(Unidad entity) {
        //no se puede elminar una unidad
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