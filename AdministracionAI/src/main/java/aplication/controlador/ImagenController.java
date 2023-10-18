package aplication.controlador;

import aplication.model.Imagen;
import aplication.model.Reclamo;
import aplication.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import aplication.model.Imagen;

import java.util.List;

import aplication.service.*;

@RestController
@RequestMapping("/imagenes")
public class ImagenController {



    // DuenioService duenioService;
    @Autowired
    private ImagenService imagenService;

    private ImagenController() { }

    @GetMapping
    public ResponseEntity<List<Imagen>> listar() {
        return ResponseEntity.ok(imagenService.listar());
    }

    @PostMapping
    public Imagen cargarImagen(@RequestBody Imagen imagen) {
        return imagenService.guardar(imagen);
    }


}

