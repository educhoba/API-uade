package aplication.controlador;

import aplication.exceptions.UnidadException;
import aplication.model.Edificio;
import aplication.model.Persona;
import aplication.model.Reclamo;
import aplication.model.Unidad;
import aplication.service.UnidadService;
import aplication.views.ReclamoView;
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
    @GetMapping("/edificio/{codigoEdificio}/piso/{piso}/numero/{numero}")
    public ResponseEntity<Unidad> buscarPorEdificioPisoNumero(@PathVariable Integer codigoEdificio, @PathVariable String piso,@PathVariable String numero){
        //List<PersonaView> resultado = new ArrayList<PersonaView>();
        Unidad unidad = unidadService.buscarPorEdificioPisoNumero(codigoEdificio,piso,numero);
        if(unidad == null)
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

    @GetMapping("/inquilinosByIdUnidad/{codigo}")
    public ResponseEntity<List<Persona>> inquilinosPorUnidad(@PathVariable Long codigo){
        //List<PersonaView> resultado = new ArrayList<PersonaView>();
        Unidad unidad = unidadService.buscarPorCodigo(codigo);
        if(unidad == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        List<Persona> inquilinos = unidad.getInquilinos();
        if(inquilinos == null || inquilinos.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        //for(Persona persona : inquilinos)
        //    resultado.add(persona.toView());
        return ResponseEntity.ok(inquilinos);
    }
    @GetMapping("/inquilinosByEdificioAndPisoAndNumeroUnidad/edificio/{codigoEdificio}/piso/{piso}/numero/{numero}")
    public ResponseEntity<List<Persona>> inquilinosPorEdificioPisoNumero(@PathVariable Integer codigoEdificio, @PathVariable String piso,@PathVariable String numero){
        //List<PersonaView> resultado = new ArrayList<PersonaView>();
        Unidad unidad = unidadService.buscarPorEdificioPisoNumero(codigoEdificio,piso,numero);
        if(unidad == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        List<Persona> inquilinos = unidad.getInquilinos();
        if(inquilinos == null || inquilinos.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        //for(Persona persona : inquilinos)
        //    resultado.add(persona.toView());
        return ResponseEntity.ok(inquilinos);
    }

    @GetMapping("/reclamosPorUnidad/edificio/{codigoEdificio}/piso/{piso}/numero/{numero}")
    public ResponseEntity<List<Reclamo>> reclamosPorUnidad(@PathVariable Integer codigoEdificio, @PathVariable String piso, @PathVariable String numero) {
        Unidad unidad = unidadService.buscarPorEdificioPisoNumero(codigoEdificio,piso,numero);
        if(unidad == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        List<Reclamo> reclamos = unidad.getReclamos();
        if(reclamos == null || reclamos.isEmpty())
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        //for(Persona persona : inquilinos)
        //    resultado.add(persona.toView());
        return ResponseEntity.ok(reclamos);
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
    //todo TEST
    @PostMapping("/liberarUnidad/edificio/{codigoEdificio}/piso/{piso}/numero/{numero}")
    public Unidad liberarUnidad(@PathVariable Integer codigoEdificio, @PathVariable String piso,@PathVariable String numero){
        Unidad unidad = unidadService.buscarPorEdificioPisoNumero(codigoEdificio,piso,numero);
        if(unidad != null)
            unidad.liberar();
        //todo que pasa  si es null?
        return unidadService.guardar(unidad);
    }
    //todo TEST
    @PostMapping("/habitarUnidad/edificio/{codigoEdificio}/piso/{piso}/numero/{numero}")
    public Unidad habitarUnidad(@PathVariable Integer codigoEdificio, @PathVariable String piso,@PathVariable String numero){
        Unidad unidad = unidadService.buscarPorEdificioPisoNumero(codigoEdificio,piso,numero);
        if(unidad != null)
            unidad.habitar();
        //todo que pasa  si es null?
        return unidadService.guardar(unidad);
    }

    //transferir

    //agregarDuenio

    //alquilar

    //agregarInquilino

    //

}