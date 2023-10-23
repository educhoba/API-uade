
package aplication.controlador;

import aplication.model.*;
import aplication.service.ReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        Reclamo reclamo = reclamoService.buscarPorCodigo(id);
        if (reclamo == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(reclamo);
    }


    @GetMapping("/edificioByIdReclamo/{codigo}")
    public ResponseEntity<Edificio> edificioByReclamo(@PathVariable Long codigo)  {
        Reclamo reclamo = reclamoService.buscarPorCodigo(codigo);

        if (reclamo == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Edificio edificio = reclamo.getEdificio();
        if (edificio == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.status(HttpStatus.OK).body(edificio);
    }

    @GetMapping("/personaByIdReclamo/{codigo}")
    public ResponseEntity<Persona> personaByReclamo(@PathVariable Long codigo)  {
        Reclamo reclamo = reclamoService.buscarPorCodigo(codigo);

        if (reclamo == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Persona persona = reclamo.getPersona();
        if (persona == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.status(HttpStatus.OK).body(persona);
    }
/*
    @PostMapping
    public ResponseEntity<?> cargarReclamo() {
        Club club = clubService.buscar(idClub);
        Beneficio beneficio = beneficioService.buscar(idBeneficio);

        if (club != null && beneficio != null) {
            List<Beneficio> beneficios = club.getBeneficios();

            if (!beneficios.contains(club)) {
                beneficios.add(beneficio);
                beneficio.getClubes().add(club);
                beneficioService.save(beneficio);  // Guardar el beneficio para actualizar la asociación
                clubService.save(club);  // Guardar la club para actualizar la asociación
            }

            return ResponseEntity.status(HttpStatus.OK).build();
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
*/
    @PostMapping
    public Reclamo cargarReclamo(@RequestBody Reclamo reclamo) {
        return reclamoService.guardar(reclamo);
    }


}




