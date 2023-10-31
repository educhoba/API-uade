
package aplication.service;

        import aplication.exceptions.PersonaException;
        import aplication.model.Administrador;
        import aplication.model.Edificio;
        import aplication.model.Inquilino;
        import aplication.model.Persona;
        import aplication.repository.IAdministradorRepository;
        import aplication.repository.IEdificioRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;

        import java.util.List;
        import java.util.Optional;

@Service
@Transactional
public class AdministradorService implements IService<Administrador,Administrador>{
    private IAdministradorRepository iRepository;

    @Autowired
    public AdministradorService(IAdministradorRepository iRepository){
        this.iRepository=iRepository;
    }

    @Override
    public List<Administrador> listar() {
        return iRepository.findAll();
    }

    @Override
    public Administrador guardar(Administrador administrador) {
        if(administrador.getDocumento()==null) {
            return null;
        }
        return iRepository.save(administrador);
    }

    @Override
    public Administrador buscarPorCodigo(Long id) {
        Optional<Administrador> ret = iRepository.findById(id);
        return ret.orElse(null);
    }



    @Override
    public void eliminarPorId(Long id) {
        iRepository.deleteById(id);
    }
    @Override
    public void eliminar(Administrador entity) {
        iRepository.delete(entity);
    }


    @Override
    public Administrador modificar(Administrador administrador, String cambio) {
        //hacer
        return null;
    }


}
