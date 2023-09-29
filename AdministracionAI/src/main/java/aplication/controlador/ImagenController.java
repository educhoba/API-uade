package aplication.controlador;

import aplication.model.Imagen;
import aplication.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

}

