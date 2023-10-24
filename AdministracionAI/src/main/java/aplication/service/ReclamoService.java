package aplication.service;

import aplication.model.Persona;
import aplication.model.Reclamo;
import aplication.model.Unidad;
import aplication.repository.IPersonaRepository;
import aplication.repository.IReclamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReclamoService implements IService<Reclamo, Reclamo> {
    private IReclamoRepository iRepository;

    @Autowired
    public ReclamoService(IReclamoRepository iRepository){
        this.iRepository=iRepository;
    }

    @Override
    public List<Reclamo> listar() {
        return iRepository.findAll();
    }

    @Override
    public Reclamo guardar(Reclamo reclamo) {

        if(reclamo.getDocumento()==null || reclamo.getUbicacion()==null || reclamo.getDescripcion() ==null || reclamo.getIdentificador() <= 0 || reclamo.getCodigo() <= 0) {
            return null;
        }
        return iRepository.save(reclamo);
    }


    @Override
    public Reclamo buscarPorCodigo(Long id) {
        Optional<Reclamo> ret = iRepository.findById(id);
        return ret.orElse(null);
    }

    @Override
    public void eliminarPorId(Long id) {
        iRepository.deleteById(id);

    }

    @Override
    public void eliminar(Reclamo entity) {
        iRepository.delete(entity);
    }
}