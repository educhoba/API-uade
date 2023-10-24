
package aplication.controlador;

import aplication.exceptions.PersonaException;
import aplication.model.*;
import aplication.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if (persona == null || persona.getDocumento() == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(persona);
    }

    @PostMapping
    public Persona cargarPersona(@RequestBody Persona persona) {
        return personaService.guardar(persona);
    }

    @PostMapping("/registrarUsuario/documento/{documento}/mail/{mail}/contrasenia/{contrasenia}")
    public ResponseEntity<String> registrarUsuario(@PathVariable String documento, @PathVariable String mail, @PathVariable String contrasenia){
        try{
            personaService.registrarUsuario(documento,mail,contrasenia);
        }
        catch (PersonaException ex){
            return ResponseEntity.badRequest()
                    .body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body("Usuario creado.");
    }

}

