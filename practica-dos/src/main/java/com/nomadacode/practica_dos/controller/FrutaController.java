package com.nomadacode.practica_dos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nomadacode.practica_dos.model.FrutaEntity;
import com.nomadacode.practica_dos.service.ITiendaFrutasService;

//@Slf4j
@RestController
@RequestMapping(value = "/api")
public class FrutaController {

	@Autowired
	ITiendaFrutasService service;

	@GetMapping(value = "/frutas")
	public List<FrutaEntity> getFruta() {
		return service.getFrutas();
	}

	@GetMapping(value = "/frutas/{id}")
	public FrutaEntity getFrutaById(@PathVariable("id") Integer id) {
		return service.getFrutasById(id);
	}

	@PutMapping(value = "/frutas/crear")
	public FrutaEntity addFruta(@RequestBody FrutaEntity request) {
		return service.addFrutas(request.getNombre(), request.getCantidad());
	}

//	@PostMapping(value="/frutas/{id}/actualizar", params="nombre")
//	public FrutaEntity updateNombre(@PathVariable("id") Integer id, @RequestParam String nombre) {
//		return service.updateNombre(id, nombre);
//	}

	@PostMapping(value = "/frutas/{id}/actualizar/nombre")
	public FrutaEntity updateNombre(@PathVariable("id") Integer id, @RequestBody FrutaEntity request) {
		return service.updateNombre(id, request.getNombre());
	}

//	@PostMapping(value = "/frutas/{id}/actualizar", params="cantidad")
//	public FrutaEntity updateCantidad(@PathVariable("id") Integer id, @RequestParam Integer cantidad) {
//		return service.updateCantidad(id, cantidad);
//	}

	@PostMapping(value = "/frutas/{id}/actualizar/cantidad")
	public FrutaEntity updateCantidad(@PathVariable("id") Integer id, @RequestBody FrutaEntity request) {
		return service.updateCantidad(id, request.getCantidad());
	}

	@PutMapping(value = "/frutas/{id}/agregar/cantidad")
	public FrutaEntity addCantidad(@PathVariable("id") Integer id, @RequestBody FrutaEntity request) {
		return service.addCantidad(id, request.getCantidad());
	}

	@PutMapping(value = "/frutas/{id}/quitar/cantidad")
	public FrutaEntity removeCantidad(@PathVariable("id") Integer id, @RequestBody FrutaEntity request) {
		return service.removeCantidad(id, request.getCantidad());
	}

	@DeleteMapping(value = "/frutas/{id}/eliminar")
	public FrutaEntity deleteFruta(@PathVariable("id") Integer id) {
		return service.deleteFruta(id);
	}

	@GetMapping(value = "/frutas/reporte")
	public String getReporte() {
		return service.reporte();
	}
}