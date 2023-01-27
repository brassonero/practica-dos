package com.nomadacode.practica_dos.service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import com.nomadacode.practica_dos.model.FrutaEntity;

public interface ITiendaFrutasService {

	List<FrutaEntity> getFrutas();

	FrutaEntity getFrutasById(Integer id);

	FrutaEntity addFrutas(String nombre, Integer cantidad);

	FrutaEntity updateNombre(Integer id, String nombre);

	FrutaEntity updateCantidad(Integer id, Integer cantidad);

	FrutaEntity addCantidad(Integer id, Integer cantidad);

	FrutaEntity removeCantidad(Integer id, Integer cantidad);

	FrutaEntity deleteFruta(Integer id);

	String reporte();
}