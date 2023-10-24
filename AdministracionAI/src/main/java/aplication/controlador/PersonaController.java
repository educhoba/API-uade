
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
    public ResponseEntity<String> cargarPersona(@RequestBody Persona persona) {
        try{
            personaService.agregarPersona(persona);
        }
        catch (PersonaException ex){
            return ResponseEntity.badRequest()
                    .body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body("Persona cargada.");
    }

    @PostMapping()
    public ResponseEntity<String> registrarUsuario(@RequestBody Persona persona){
        try{
            personaService.registrarUsuario(persona);
        }
        catch (PersonaException ex){
            return ResponseEntity.badRequest()
                    .body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body("Usuario registrado.");
    }

    @PostMapping
    public ResponseEntity<String> eliminarPersona(@RequestBody Persona persona) {
        try{
            personaService.eliminarPersona(persona);
        }
        catch (PersonaException ex){
            return ResponseEntity.badRequest()
                    .body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body("Persona eliminada.");
    }
    @PostMapping
    public ResponseEntity<String> cambiarContraseña(@RequestBody Persona persona) {
        try{
            personaService.cambiarContrasenia(persona);
        }
        catch (PersonaException ex){
            return ResponseEntity.badRequest()
                    .body(ex.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body("Contraseña cambiada.");
    }
}

