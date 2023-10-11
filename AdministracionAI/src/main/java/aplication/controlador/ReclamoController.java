
package aplication.controlador;

import aplication.model.*;
import aplication.service.ReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import aplication.service.*;

@RestController
@RequestMapping("/reclamos")
public class ReclamoController {



    // DuenioService duenioService;
    @Autowired
    private ReclamoService reclamoService;

    private ReclamoController() { }

    @GetMapping
    public ResponseEntity<List<Reclamo>> listar() {
        return ResponseEntity.ok(reclamoService.listar());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Reclamo> buscar(@PathVariable Long id) {
        Reclamo reclamo = reclamoService.buscarPorId(id);
        if (reclamo == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(reclamo);
    }


    @GetMapping("/edificioByIdReclamo/{codigo}")
    public ResponseEntity<Edificio> edificioByReclamo(@PathVariable Long codigo)  {
        Reclamo reclamo = reclamoService.buscarPorId(codigo);

        if (reclamo == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Edificio edificio = reclamo.getEdificio();
        if (edificio == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.status(HttpStatus.OK).body(edificio);
    }

    @GetMapping("/personaByIdReclamo/{codigo}")
    public ResponseEntity<Persona> personaByReclamo(@PathVariable Long codigo)  {
        Reclamo reclamo = reclamoService.buscarPorId(codigo);

        if (reclamo == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Persona persona = reclamo.getPersona();
        if (persona == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.status(HttpStatus.OK).body(persona);
    }


}




