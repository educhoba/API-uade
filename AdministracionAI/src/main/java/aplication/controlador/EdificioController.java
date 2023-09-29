
package aplication.controlador;

import aplication.model.Edificio;
import aplication.service.EdificioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import aplication.model.Imagen;

import java.util.List;

import aplication.service.*;

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

}

