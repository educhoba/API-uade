
package aplication.controlador;

import aplication.exceptions.ReclamoException;
import aplication.model.*;
import aplication.service.ReclamoService;
import aplication.views.Estado;
import aplication.views.ReclamoView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @GetMapping("/reclamosPorPersona/{documento}")
    public ResponseEntity<List<Reclamo>> reclamosPorPersona(@PathVariable String documento) {
        List<Reclamo> resultado = new ArrayList<Reclamo>();
        List<Reclamo> reclamos = reclamoService.listar();

        if (reclamos == null || reclamos.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        for(Reclamo R :reclamos)
        {
            Persona aux = R.getPersona();
            if(aux != null && Objects.equals(aux.getDocumento(), documento))
                resultado.add(R);
        }

        if (resultado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.status(HttpStatus.OK).body(resultado);
    }

    @GetMapping("/reclamosPorEdificio/{codigo}")
    public ResponseEntity<List<Reclamo>> reclamosPorEdificio(@PathVariable int codigo) {
        List<Reclamo> resultado = new ArrayList<Reclamo>();
        List<Reclamo> reclamos = reclamoService.listar();

        if (reclamos == null || reclamos.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        for(Reclamo R :reclamos)
        {
            Edificio aux = R.getEdificio();
            if(aux != null && Objects.equals(aux.getCodigo(), codigo))
                resultado.add(R);
        }

        if (resultado.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.status(HttpStatus.OK).body(resultado);
    }





    @PostMapping
    public Reclamo cargarReclamo(@RequestBody Reclamo reclamo) {
        return reclamoService.guardar(reclamo);
    }





    @PutMapping("/{codigo}")
    public ResponseEntity<Reclamo> cambiarEstado(@PathVariable Long codigo, @RequestBody Reclamo reclamoIn){
        /*if (reclamoIn.getEstado().equals("abierto")  || reclamoIn.getEstado().equals("desestimado") || reclamoIn.getEstado().equals("anulado") || reclamoIn.getEstado().equals("en proceso") || reclamoIn.getEstado().equals("terminado")  == false)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
*/

        Reclamo reclamo = reclamoService.buscarPorCodigo(codigo);  //busco el reclamo por codigo
        if (reclamo.cambiarEstado(reclamoIn.getEstado()) == false) // cambio el estado de ese reclamo en el objeto propiamente dicho
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        reclamoService.guardar(reclamo); //piso el anterior con este nuevo reclamo actualizado


        return ResponseEntity.status(HttpStatus.OK).body(reclamo);
    }



    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        reclamoService.eliminarPorId(id);
        return ResponseEntity.ok("Reclamo eliminado");
    }



/**
 *
 * para mi esto de agregar imagen a reclamo no va FER.
 */

/*
    public void agregarImagenAReclamo(Long codigo, String direccion, String tipo){
        //todo POST
        Reclamo reclamo = reclamoService.buscarPorCodigo(codigo);
        reclamo.agregarImagen(direccion, tipo);
    }
*/
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
}




