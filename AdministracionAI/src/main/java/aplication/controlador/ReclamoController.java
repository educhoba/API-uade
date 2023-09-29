
package aplication.controlador;

import aplication.model.Reclamo;
import aplication.service.ReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import aplication.model.Imagen;

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

}

