package com.nomadacode.practica_dos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nomadacode.practica_dos.model.FrutaEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TiendaFrutasServiceImpl implements ITiendaFrutasService {

	List<FrutaEntity> frutas = new ArrayList<>();

	@Override
	public List<FrutaEntity> getFrutas() {
		return frutas;
	}

	@Override
	public FrutaEntity getFrutasById(Integer id) {
		FrutaEntity frutaEncontrada = null;

		for (FrutaEntity fruta : frutas) {
			if (fruta.getId() == id) {
				frutaEncontrada = fruta;
			}
		}
		return frutaEncontrada;
	}

	@Override
	public FrutaEntity addFrutas(String nombre, Integer cantidad) {
		FrutaEntity fruta = new FrutaEntity();

		fruta.setId(frutas.size() + 1);
		fruta.setNombre(nombre);
		fruta.setCantidad(cantidad);

		frutas.add(fruta);

		return fruta;
	}

	@Override
	public FrutaEntity updateNombre(Integer id, String nombre) {
		FrutaEntity fruta = getFrutasById(id);
		fruta.setNombre(nombre);
		return fruta;
	}

	@Override
	public FrutaEntity updateCantidad(Integer id, Integer cantidad) {
		FrutaEntity fruta = getFrutasById(id);
		fruta.setCantidad(cantidad);
		return fruta;
	}

	@Override
	public FrutaEntity addCantidad(Integer id, Integer cantidad) {
		FrutaEntity fruta = getFrutasById(id);
		Integer suma = fruta.getCantidad() + cantidad;
		fruta.setCantidad(suma);
		return fruta;
	}

//	@Override
//	public FrutaEntity removeCantidad(Integer id, Integer cantidad) {
//		FrutaEntity fruta = getFrutasById(id);
//		if (fruta.getCantidad() > 0) {
//			Integer resta = fruta.getCantidad() - cantidad;
//			fruta.setCantidad(resta);
//		} else {
//			return fruta;
//		}
//		return fruta;
//	}

	@Override
	public FrutaEntity removeCantidad(Integer id, Integer cantidad) {
		FrutaEntity fruta = getFrutasById(id);
		Integer resta = fruta.getCantidad() - cantidad;
		fruta.setCantidad(resta);
		return fruta;
	}

	@Override
	public FrutaEntity deleteFruta(Integer id) {
		FrutaEntity fruta = getFrutasById(id);
		frutas.remove(fruta);
		return fruta;
	}

	@Override
	public String reporte() {
		String filas = "";

		log.info(frutas.toString());

		for (FrutaEntity fruta : frutas) {
			String tr = "<tr align=\"center\">" + "\n" + "<td>" + fruta.getId() + "</td>" + "\n" + "<td>"
					+ fruta.getNombre() + "</td>" + "\n" + "<td>" + fruta.getCantidad() + "</td>" + "\n" + "</tr>"
					+ "\n";
			filas += tr;
		}

		String tabla = "<h1 style=\"display:flex; justify-content:center;\">Listado de frutas</h1>" + "\n"
				+ "<table border=\"5\" cellpadding=\"5\" cellspacing=\"0\" style=\"display:grid; place-items:center; border-style:none\">"
				+ "\n" + "<tr align=\"center\">" + "\n" + "<th>ID</th>" + "\n" + "<th>Nombre</th>" + "\n"
				+ "<th>Cantidad</th>" + "\n" + "</tr>" + "\n" + filas + "</table>";

		return tabla;
	}
}