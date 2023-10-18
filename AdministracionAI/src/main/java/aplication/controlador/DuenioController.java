package aplication.controlador;

import aplication.exceptions.UnidadException;
import aplication.model.*;
import aplication.model.Unidad;
import aplication.service.EdificioService;
import aplication.views.PersonaView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import aplication.service.*;



import java.util.List;

@RestController
@RequestMapping("/duenios")
public class DuenioController {

    private static Controlador instancia;


   // DuenioService duenioService;
    @Autowired
    private DuenioService duenioService;

    private DuenioController() { }

    @GetMapping
    public ResponseEntity<List<Duenio>> listar() {
        return ResponseEntity.ok(duenioService.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Duenio> buscar(@PathVariable Long id) {
        Duenio duenio = duenioService.buscarPorId(id);
        if (duenio == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(duenio);
    }

    @PostMapping
    public Duenio cargarDuenio(@RequestBody Duenio duenio) {
        return duenioService.guardar(duenio);
    }

}

