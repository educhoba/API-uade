package aplication.controlador;

import aplication.exceptions.UnidadException;
import aplication.model.Unidad;
import aplication.model.Persona;
import aplication.model.Unidad;
import aplication.service.EdificioService;
import aplication.views.PersonaView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import aplication.model.Duenio;

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

}

