package aplication.controlador;

import aplication.model.Edificio;
import aplication.model.Unidad;
import aplication.service.UnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidades")
public class UnidadController {



    // DuenioService duenioService;
    @Autowired
    private UnidadService unidadService;

    private UnidadController() { }

    @GetMapping
    public ResponseEntity<List<Unidad>> listar() {
        return ResponseEntity.ok(unidadService.listar());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Unidad> buscar(@PathVariable Long id) {
        Unidad unidad = unidadService.buscarPorCodigo(id);
        if (unidad == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(unidad);
    }


    @GetMapping("/edificioByIdUnidad/{codigo}")
    public ResponseEntity<Edificio> edificioPorUnidad(@PathVariable Long codigo)  {
        Unidad unidad = unidadService.buscarPorCodigo(codigo);

        if (unidad == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Edificio edificio = unidad.getEdificio();
        if (edificio == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.status(HttpStatus.OK).body(edificio);
    }


    @PostMapping
    public Unidad cargarUnidad(@RequestBody Unidad unidad) {
        return unidadService.guardar(unidad);
        /*
        Meeting meeting =
                meetingRepository.findByMeetingId(meetingId)
                        .orElseThrow(() -> new MeetingDoesNotExistException(meetingId));
                        */
    }
}