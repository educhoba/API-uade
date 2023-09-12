package aplication;

;
/*
import model.*;

import service.*;
import repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


@SpringBootApplication
@SpringBootConfiguration
public class apiApplication implements CommandLineRunner {
    @Autowired
    IUnidadRepository unidadRepositorio;
    public static void main(String[] args) {
        SpringApplication.run(apiApplication.class, args);

           }

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub

        System.out.println("Hola Mundo Spring");
        List<Unidad> unidades = unidadRepositorio.findAll();
        for(Unidad p : unidades)
            System.out.println(p.toString());
/*
        Unidad nueva = new Provincia(51, "Mi Provincia");
        provinciaRepositorio.save(nueva);

        Optional<Provincia> recuperada = provinciaRepositorio.findById(17);
        if(recuperada.isPresent())
            System.out.println(recuperada.toString());

        recuperada = provinciaRepositorio.findByNombre("San Juan");
        if(recuperada.isPresent())
            System.out.println(recuperada.toString());

        List<Club> clubes = clubRepositorio.findAll();
        for(Club c : clubes)
            System.out.println(c.toString());*/
   // }
//}

/*
    public ResponseEntity<List<Beneficio>> listar() {
        return ResponseEntity.ok(beneficioService.listar());
    }
*/

//package com.example.administracionai;
/*
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdministracionAiApplication {

    public static void main(String[] args) {
        System.out.println("hola");

        SpringApplication.run(AdministracionAiApplication.class, args);
    }

}
*/

import aplication.model.Edificio;
import aplication.model.Unidad;
import aplication.model.*;


import aplication.repository.IDuenioRepository;
import aplication.repository.IEdificioRepository;
import aplication.repository.IImagenRespository;
import aplication.repository.IUnidadRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@SpringBootApplication
@SpringBootConfiguration
public class ApiApplication implements CommandLineRunner {
    @Autowired
    IUnidadRepository unidadRepositorio;

    @Autowired
    IEdificioRepository edificioRepositorio;

    @Autowired
    IImagenRespository imagenRepositorio;

    @Autowired
    IDuenioRepository duenioRepositorio;

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub

        System.out.println("Hola Mundo Spring");
        List<Unidad> unidades = unidadRepositorio.findAll();
        for (Unidad p : unidades) {
            System.out.println("----------- Departamento ------------");

            System.out.println("Identificador::" + p.getIdentificador().toString());

            // de cada unidad obtengo su edificio
            Edificio edificioDeMiUnidad = p.getEdificio();
            if (edificioDeMiUnidad != null) {
                String nombreDelEdificio = edificioDeMiUnidad.getNombre();
                System.out.println("Nombre dificio SIN cambio :" + nombreDelEdificio);

                if(nombreDelEdificio.equals("Lizard Plaza")) {
                    edificioDeMiUnidad.setNombre("Lizard");
                    //para actualizar algo, primero get con el repositorio segun el id, set algo y despues save
                    edificioRepositorio.save(edificioDeMiUnidad);
                    System.out.println("Nombre dificio CON cambio :" + edificioDeMiUnidad.getNombre());
                    }
            }

        }
            List<Edificio> edificio = edificioRepositorio.findAll();
            for (Edificio e : edificio)
                System.out.println("Direccion --:" + e.getDireccion().toString());


            List<Imagen> imagen = imagenRepositorio.findAll();
            for (Imagen e : imagen)
                System.out.println("Path --:" + e.getPath().toString());




        }
    }
