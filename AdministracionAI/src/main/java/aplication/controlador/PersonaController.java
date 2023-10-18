
package aplication.controlador;

import aplication.model.Edificio;
import aplication.model.Persona;
import aplication.model.Reclamo;
import aplication.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import aplication.model.Imagen;

import java.util.List;

import aplication.service.*;

@RestController
@RequestMapping("/personas")
public class PersonaController {



    // DuenioService duenioService;
    @Autowired
    private PersonaService personaService;

    private PersonaController() { }

    @GetMapping
    public ResponseEntity<List<Persona>> listar() {
        return ResponseEntity.ok(personaService.listar());
    }


    @GetMapping("/{documento}")
    public ResponseEntity<Persona> buscar(@PathVariable String documento) {
        Persona persona = personaService.buscarPorDocumento(documento);
        if (persona == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(persona);
    }




}

