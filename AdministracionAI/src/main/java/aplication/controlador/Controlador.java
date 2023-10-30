package aplication.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import aplication.exceptions.PersonaException;
import aplication.model.*;
import aplication.service.*;
import aplication.views.*;
import aplication.exceptions.EdificioException;
import aplication.exceptions.ReclamoException;
import aplication.exceptions.UnidadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/negocio")
public class Controlador {

	private static Controlador instancia;

	@Autowired
	private UnidadService unidadService;
	@Autowired
	private PersonaService personaService;
	@Autowired
	private InquilinoService inquilinoService;;
	@Autowired
	private DuenioService duenioService;



	UnidadService uniSvc;
	private Controlador() { }
	
	public static Controlador getInstancia() {
		if(instancia == null)
			instancia = new Controlador();
		return instancia;
	}

	//<editor-fold desc="cruzadas">

	//transferir
	@PostMapping("/transferirUnidad/edificio/{codigoEdificio}/piso/{piso}/numero/{numero}/documento/{documento}")
	public ResponseEntity<String> transferirUnidad(@PathVariable Integer codigoEdificio, @PathVariable String piso,@PathVariable String numero,@PathVariable String documento){
		try{
			Unidad unidad = unidadService.buscarPorEdificioPisoNumero(codigoEdificio,piso,numero);
			Persona persona = personaService.buscarPersona(documento);
			List<Duenio> duenios = duenioService.buscarPorUnidadId(unidad.getIdentificador());
			for(Duenio d : duenios){
				duenioService.eliminar(d);
			}
			Duenio nuevoDuenio = unidad.transferir(persona);
			duenioService.guardar(nuevoDuenio);
		}
		catch (Exception ex){
			return ResponseEntity.badRequest()
					.body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body("Unidad transferida.");
	}
	//agregarDuenio
	@PostMapping("/agregarDuenioUnidad/edificio/{codigoEdificio}/piso/{piso}/numero/{numero}/documento/{documento}")
	public ResponseEntity<String> agregarDuenioUnidad(@PathVariable Integer codigoEdificio, @PathVariable String piso,@PathVariable String numero,@PathVariable String documento){
		try{
			Unidad unidad = unidadService.buscarPorEdificioPisoNumero(codigoEdificio,piso,numero);
			Persona persona = personaService.buscarPersona(documento);
			Duenio posibleDuenio = unidad.agregarDuenio(persona);
			if(posibleDuenio != null)
				duenioService.guardar(posibleDuenio);
		}
		catch (Exception ex){
			return ResponseEntity.badRequest()
					.body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body("Duenio agregado.");
	}
	//alquilar
	@PostMapping("/alquilarUnidad/edificio/{codigoEdificio}/piso/{piso}/numero/{numero}/documento/{documento}")
	public ResponseEntity<String> alquilarUnidad(@PathVariable Integer codigoEdificio, @PathVariable String piso,@PathVariable String numero,@PathVariable String documento){
		try{
			Unidad unidad = unidadService.buscarPorEdificioPisoNumero(codigoEdificio,piso,numero);
			Persona persona = personaService.buscarPersona(documento);
			Inquilino inq = unidad.alquilar(persona);
			inquilinoService.guardar(inq);
		}
		catch (Exception ex){
			return ResponseEntity.badRequest()
					.body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body("Unidad alquilada.");
	}

	//agregarInquilino
	@PostMapping("/agregarInquilinoUnidad/edificio/{codigoEdificio}/piso/{piso}/numero/{numero}/documento/{documento}")
	public ResponseEntity<String> agregarInquilinoUnidad(@PathVariable Integer codigoEdificio, @PathVariable String piso,@PathVariable String numero,@PathVariable String documento){
		try{
			Unidad unidad = unidadService.buscarPorEdificioPisoNumero(codigoEdificio,piso,numero);
			Persona persona = personaService.buscarPersona(documento);
			Inquilino posibleInquilino = unidad.agregarInquilino(persona);
			if(posibleInquilino != null)
				inquilinoService.guardar(posibleInquilino);
		}
		catch (Exception ex){
			return ResponseEntity.badRequest()
					.body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body("Inquilino agregado.");
	}

	//</editor-fold>





}
