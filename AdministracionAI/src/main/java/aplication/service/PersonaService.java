package aplication.service;

import aplication.exceptions.PersonaException;
import aplication.model.Duenio;
import aplication.model.Inquilino;
import aplication.model.Persona;
import aplication.model.Unidad;
import aplication.repository.IDuenioRepository;
import aplication.repository.IInquilinoRepositoy;
import aplication.repository.IPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Transactional
public class PersonaService implements IService<Persona, Persona> {
    @Autowired
    private IPersonaRepository iRepository;
    @Autowired
    private IDuenioRepository iDuenioRepository;
    @Autowired
    private IInquilinoRepositoy iInquilinoRepository;

    @Autowired
    public PersonaService(IPersonaRepository iRepository){
        this.iRepository=iRepository;
    }

    @Override
    public List<Persona> listar() {
        return iRepository.findAll();
    }

    @Override
    public Persona guardar(Persona entity) {
        return iRepository.save(entity);
    }


    public Persona buscarPorDocumento(String id) {
        Optional<Persona> ret = iRepository.findByDocumento(id);
        return ret.orElse(null);
    }

    @Override
    public Persona buscarPorCodigo(Long id) {
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

    public Persona buscarPersona(String documento) throws PersonaException {
        Optional<Persona> personaRet = iRepository.findByDocumento(documento);
        if(personaRet.isPresent())
        {
            return personaRet.get();
        }
        else
            throw new PersonaException("contactese a la admin para registrarse.");
    }
    public void registrarUsuario(String documento, String mail, String contrasenia) throws PersonaException {

        Persona p = buscarPersona(documento);
        p.setMail(mail.trim());
        p.setContrasenia(contrasenia.trim());
        guardar(p);

    }
    public void cambiarContrasenia(String documento, String mail, String contrasenia){
        //todo cambiar password
    }
}