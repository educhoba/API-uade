package aplication.controlador;


import aplication.model.Imagen;
import aplication.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import aplication.service.*;

@RestController
@RequestMapping("/logs")
public class LogController {



    // DuenioService duenioService;
    @Autowired
    private LogService logService;

    private LogController() { }

    @GetMapping
    public ResponseEntity<List<Log>> listar() {
        return ResponseEntity.ok(logService.listar());
    }

    @PostMapping
    public Log cargarLog(@RequestBody Log log) {
        return logService.guardar(log);
    }


    // buscas las imagenes de un reclamo, devuelve una lista de imagenes
    @GetMapping("{idLog}")
    public ResponseEntity<List<Log>> buscar(@PathVariable Integer idLog) {
        List<Log> log = logService.buscarPorIdLog(idLog);
        if (log == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(log);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        logService.eliminarPorId(id);
        return ResponseEntity.ok("Log eliminado");
    }


}

