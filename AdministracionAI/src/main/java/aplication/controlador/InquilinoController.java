

package aplication.controlador;
import aplication.model.Duenio;
import aplication.model.Edificio;
import aplication.model.Inquilino;
import aplication.service.InquilinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import aplication.model.Imagen;

import java.util.List;

import aplication.service.*;


@RestController
@RequestMapping("/inquilinos")
public class InquilinoController {



    // DuenioService duenioService;
    @Autowired
    private InquilinoService inquilinoService;

    private InquilinoController() { }

    @GetMapping
    public ResponseEntity<List<Inquilino>> listar() {
        return ResponseEntity.ok(inquilinoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Inquilino> buscar(@PathVariable Long id) {
        Inquilino inquilino = inquilinoService.buscarPorId(id);
        if (inquilino == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(inquilino);
    }

    @PostMapping
    public Inquilino cargarInquilino(@RequestBody Inquilino inquilino) {
        return inquilinoService.guardar(inquilino);
    }
}

