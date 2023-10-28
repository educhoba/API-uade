
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
        try{
            Persona persona = personaService.buscarPersona(documento);
            return ResponseEntity.ok(persona);
        }
        catch (PersonaException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/cargar")
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

    @PostMapping("/registrarUsuario")
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

    @PostMapping("/eliminar")
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
    @PostMapping("/cambiarContraseña")
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

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        personaService.eliminarPorId(id);
        return ResponseEntity.ok("Inquilino eliminado");
    }



}

