
package aplication.controlador;

        import aplication.model.*;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

        import aplication.service.*;

@RestController
@RequestMapping("/administradores")
public class AdministradorController {


    // DuenioService duenioService;
    @Autowired
    private AdministradorService administradorService;

    private AdministradorController() { }

    @GetMapping
    public ResponseEntity<List<Administrador>> listar() {
        return ResponseEntity.ok(administradorService.listar());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Administrador> buscar(@PathVariable Long id) {
        Administrador administrador = administradorService.buscarPorCodigo(id);
        if (administrador == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(administrador);
    }

    @PostMapping
    public Administrador cargarAdministrador(@RequestBody Administrador administrador) {
        return administradorService.guardar(administrador);
    }


}

