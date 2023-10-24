package aplication.service;

import aplication.model.Edificio;
import aplication.model.Unidad;
import aplication.repository.IEdificioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EdificioService implements IService<Edificio,Edificio> {
    private IEdificioRepository iRepository;

    @Autowired
    public EdificioService(IEdificioRepository iRepository){
        this.iRepository=iRepository;
    }

    @Override
    public List<Edificio> listar() {
        return iRepository.findAll();
    }

    @Override
    public Edificio guardar(Edificio edificio) {
        //no se puede guardar un edificio
        return null;
    }

    @Override
    public Edificio buscarPorCodigo(Long codigo) {
        Optional<Edificio> ret = iRepository.findById(codigo);
        return ret.orElse(null);
    }

    @Override
    public void eliminarPorId(Long id) {
        //no se puede guardar un edificio
    }

    @Override
    public void eliminar(Edificio entity) {
        //no se puede eliminar un edificio
    }

}