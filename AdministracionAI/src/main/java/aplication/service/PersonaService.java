package aplication.service;

import aplication.model.Duenio;
import aplication.model.Inquilino;
import aplication.model.Persona;
import aplication.repository.IDuenioRepository;
import aplication.repository.IInquilinoRepositoy;
import aplication.repository.IPersonaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonaService implements IService<Persona, Persona> {
    private IPersonaRepository iRepository;
    private IDuenioRepository iDuenioRepository;
    private IInquilinoRepositoy iInquilinoRepository;

    @Override
    public List<Persona> listar() {
        return iRepository.findAll();
    }

    @Override
    public Persona guardar(Persona entity) {
        return iRepository.save(entity);
    }

    @Override
    public Persona buscarPorId(Long id) {
        Optional<Persona> ret = iRepository.findById(id);
        return ret.orElse(null);
    }

    @Override
    public void eliminarPorId(Long id) {
    iRepository.deleteById(id);
    }

    @Override
    public void eliminar(Persona entity) {
        iRepository.delete(entity);
    }

    public void registrarUsuario(String documento, String nombre, String mail, String contrasenia){

        Optional<Duenio> duenioRet = iDuenioRepository.findByDocumento(documento);
        Optional<Inquilino> inquilinoRet = iInquilinoRepository.findByDocumento(documento);
        if(duenioRet.isPresent() || inquilinoRet.isPresent()){
            guardar(new Persona(documento,nombre,mail,contrasenia));
        }
        //else throw exception
    }
}