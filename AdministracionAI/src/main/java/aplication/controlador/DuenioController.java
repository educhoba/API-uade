package aplication.controlador;

import aplication.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import aplication.service.*;

@RestController
@RequestMapping("/duenios")
public class DuenioController {


   // DuenioService duenioService;
    @Autowired
    private DuenioService duenioService;

    @Autowired
    private LogService logService;


    private DuenioController() { }

    @GetMapping
    public ResponseEntity<List<Duenio>> listar() {
        return ResponseEntity.ok(duenioService.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Duenio> buscar(@PathVariable Long id) {
        Duenio duenio = duenioService.buscarPorCodigo(id);
        if (duenio == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(duenio);
    }

    @PostMapping
    public Duenio cargarDuenio(@RequestBody Duenio duenio) {
        //log
//        logService.guardarLog(mail, "Se creo un duenio");

        return duenioService.guardar(duenio);
    }


}

