package aplication.controlador;

import aplication.exceptions.UnidadException;
import aplication.model.Unidad;
import aplication.model.Persona;
import aplication.model.Unidad;
import aplication.service.EdificioService;
import aplication.views.PersonaView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import aplication.model.Duenio;

import java.util.ArrayList;
import java.util.List;

import aplication.service.*;



import java.util.List;

@RestController
@RequestMapping("/duenios")
public class DuenioController {

    private static Controlador instancia;


   // DuenioService duenioService;
    @Autowired
    private DuenioService duenioService;

    private DuenioController() { }

    @GetMapping
    public ResponseEntity<List<Duenio>> listar() {
        return ResponseEntity.ok(duenioService.listar());
    }


    @GetMapping("/dueniosPorUnidad/{codigo}/{piso}/{numero}")
    //public ResponseEntity<?> buscarBeneficiosTarjeta(@PathVariable Long idTarjeta) {
    public ResponseEntity<List<PersonaView>> dueniosPorUnidad(@PathVariable Long codigo,@PathVariable String piso,@PathVariable String numero) throws UnidadException {
        List<PersonaView> resultado = new ArrayList<PersonaView>();
        Unidad unidad = listar(codigo, piso, numero);
        List<Persona> duenios = unidad.getDuenios();
        for(Persona persona : duenios)
            resultado.add(persona.toView());
        return ResponseEntity.ok(resultado);

    }

}

