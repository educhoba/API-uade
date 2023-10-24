package aplication.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import aplication.exceptions.PersonaException;
import aplication.model.Edificio;
import aplication.model.Persona;
import aplication.model.Reclamo;
import aplication.model.Unidad;
import aplication.service.*;
import aplication.views.*;
import aplication.exceptions.EdificioException;
import aplication.exceptions.ReclamoException;
import aplication.exceptions.UnidadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Controlador {

	private static Controlador instancia;

	EdificioService ediSvc;

	ImagenService imgSvc;


	PersonaService perSvc;


	ReclamoService recSvc;

	@Autowired
	private EdificioService edificioService;


	UnidadService uniSvc;
	private Controlador() { }
	
	public static Controlador getInstancia() {
		if(instancia == null)
			instancia = new Controlador();
		return instancia;
	}

	//<editor-fold desc="cruzadas">
	public void transferirUnidad(Long codigo, String piso, String numero, String documento) throws UnidadException, PersonaException {
		//Unidad unidad = buscarUnidad(codigo, piso, numero);
		//Persona persona = buscarPersona(documento);
		//unidad.transferir(persona);
	}

	public void agregarDuenioUnidad(Long codigo, String piso, String numero, String documento) throws UnidadException, PersonaException {
		//Unidad unidad = buscarUnidad(codigo, piso, numero);
		//Persona persona = buscarPersona(documento);
		//unidad.agregarDuenio(persona);
	}

	public void alquilarUnidad(Long codigo, String piso, String numero, String documento) throws UnidadException, PersonaException{
		//Unidad unidad = buscarUnidad(codigo, piso, numero);
		//Persona persona = buscarPersona(documento);
		//unidad.alquilar(persona);
	}

	public void agregarInquilinoUnidad(Long codigo, String piso, String numero, String documento) throws UnidadException, PersonaException{
		//Unidad unidad = buscarUnidad(codigo, piso, numero);
		//Persona persona = buscarPersona(documento);
		//unidad.agregarInquilino(persona);
	}

	public int agregarReclamo(Long codigo, String piso, String numero, String documento, String ubicacion, String descripcion){
		//Edificio edificio = buscarEdificio(codigo);
		//Unidad unidad = buscarUnidad(codigo, piso, numero);
		//Persona persona = buscarPersona(documento);
		//Reclamo reclamo = new Reclamo(persona, edificio, ubicacion, descripcion, unidad);
		//return reclamo.getIdentificador();
		return 0;
	}
	//</editor-fold>





}
