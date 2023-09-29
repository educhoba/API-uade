package aplication.controlador;

import aplication.model.Unidad;
import aplication.service.UnidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
