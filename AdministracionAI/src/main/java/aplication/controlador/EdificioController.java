
package aplication.controlador;

import aplication.exceptions.EdificioException;
import aplication.model.*;
import aplication.service.EdificioService;
import aplication.views.PersonaView;
import aplication.views.UnidadView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import aplication.model.Unidad;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/edificios")
public class EdificioController {

    // DuenioService duenioService;
    @Autowired
    private EdificioService edificioService;

    private EdificioController() { }

    @GetMapping
    public ResponseEntity<List<Edificio>> listar() {
        return ResponseEntity.ok(edificioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Edificio> buscar(@PathVariable Long id) {
        Edificio edificio = edificioService.buscarPorCodigo(id);
        if (edificio == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(edificio);
    }


    @PostMapping
    public Edificio cargarEdificio(@RequestBody Edificio edificio) {
        return edificioService.guardar(edificio);
    }

    //trae todas las unidades del edificio
    @GetMapping("/unidadesByIdEdificio/{codigo}")
    public ResponseEntity<List<Unidad>> getUnidadesPorEdificio(@PathVariable Long codigo){

        Edificio edificio = edificioService.buscarPorCodigo(codigo);
        List<Unidad> unidades = edificio.getUnidades();
        return ResponseEntity.ok(unidades);
    }

    //trae todos los duenios e inquilinos del edificio
    @GetMapping("/habilitadosByIdEdificio/{codigo}")
    public ResponseEntity<List<Persona>> habilitadosPorEdificio(@PathVariable Long codigo){
        //List<PersonaView> resultado = new ArrayList<PersonaView>();
        Edificio edificio = edificioService.buscarPorCodigo(codigo);
        List<Persona> habilitados = edificio.habilitados();

        //for(Persona persona : habilitados)
        //    resultado.add(persona.toView());

        return ResponseEntity.ok(habilitados);
    }
}


