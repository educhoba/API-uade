
package aplication.service;
import aplication.model.Log;
import aplication.repository.ILogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class LogService implements IService<Log, Log> {
    private ILogRepository iRepository;

    @Autowired
    public LogService(ILogRepository iRepository) {
        this.iRepository = iRepository;
    }

    @Override
    public List<Log> listar() {
        return iRepository.findAll();
    }

    @Override
    public Log guardar(Log log) {
        return iRepository.save(log);
    }

    public Log guardarLog(String mail, String mensaje) {
        Log log = new Log();
        log.setMail(mail);
        log.setOperacion(mensaje);

        return iRepository.save(log);
    }


    public Log buscarPorCodigo(Long id) {
        Optional<Log> ret = iRepository.findById(id);
        return ret.orElse(null);
    }

    @Override
    public void eliminarPorId(Long id) {
        iRepository.deleteById(id);

    }

    @Override
    public void eliminar(Log entity) {
        iRepository.delete(entity);

    }

    @Override
    public Log modificar(Log entity, String cambio) {
        // TODO Auto-generated method stub
        return null;
    }



    public List<Log> buscarPorIdLog(Integer idLog) {
        return iRepository.findByIdLog(idLog);

    }
}
