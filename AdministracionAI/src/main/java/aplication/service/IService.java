package aplication.service;

import java.util.List;

public interface IService<T, R> {

    List<T> listar();

    T guardar(R entity);

    T buscarPorCodigo(Long id);


    void eliminarPorId(Long id);

    void eliminar(R entity);

}
