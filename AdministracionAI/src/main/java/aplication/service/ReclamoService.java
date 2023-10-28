package aplication.service;

import aplication.model.Reclamo;
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

    @Override
    public Reclamo modificar(Reclamo reclamo, String estado) {

        if((estado != "nuevo" ) || (estado != "abierto") || estado != "en proceso" || estado != "terminado" || estado != "desestimado" || estado != "anulado")
            return null;

        if(reclamo.getEstado()== "nuevo" && (estado == "abierto" || estado == "desestimado" || estado == "anulado")){
            reclamo.cambiarEstado(estado);
        }
        if(reclamo.getEstado()== "abierto" && (estado == "en proceso"|| estado == "desestimado" || estado == "anulado")){
            reclamo.cambiarEstado(estado);
        }
        if(reclamo.getEstado()== "en proceso" && estado == "terminado"){
            reclamo.cambiarEstado(estado);
        }
        if(reclamo.getEstado()== "en proceso" && estado == "anulado"){
            reclamo.cambiarEstado(estado);
        }
        //print
        System.out.println("El estado del reclamo es: " + reclamo.getEstado());
        //iRepository.save(reclamo);
        System.out.println("El  reclamo es: " + reclamo);
        this.guardar(reclamo);
        return reclamo;



    }
}