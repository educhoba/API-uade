
package aplication.controlador;

import aplication.exceptions.PersonaException;
import aplication.model.*;
import aplication.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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


    /* este funcionaba mal
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
    */

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

    @PostMapping public Persona cargar(@RequestBody Persona persona) {
        try{
            personaService.agregarPersona(persona);
            return persona;
        }
        catch (PersonaException ex){
            return null;
        }

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

    //si esta autorizado devuelve la persona, sino devuelve 1
    @GetMapping("/login")
    public ResponseEntity<Persona> login(@RequestBody Map<String, String> requestBody) {
        String mail = requestBody.get("mail");
        String contrasenia = requestBody.get("contrasenia");

        System.out.println("entroo "+mail+" "+contrasenia);
        try {
            Persona persona1 = personaService.buscaPorMail(mail);
            if( persona1.getContrasenia().equals(contrasenia))
                return ResponseEntity.ok(persona1);
        }
        catch (PersonaException ex){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }


        /*try{
            //Persona persona = personaService.buscarPersona(documento);
            Persona persona1 = personaService.buscaPorMail(documento);
            if( persona.getContrasenia()== contrasenia)
            return ResponseEntity.ok(persona);
        }
        catch (PersonaException ex){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }*/
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }



}

