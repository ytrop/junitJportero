package com.nttdata.pruebasUnitarias.bbdd;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nttdata.pruebasUnitarias.model.Articulo;
@Service
public class BaseDatosServiceImpl implements BaseDatosServiceI {
	
	Map<Integer,Articulo> storage;
	
	@Override
	
	public void initBD() {
		
		
		storage = new HashMap<>();
		storage.put(1, new Articulo("Camiseta", 18.25));
		storage.put(2, new Articulo("Pantalon", 19.35));
		storage.put(3, new Articulo("Bolso", 15.35));
		storage.put(4, new Articulo("Gafas", 11.45));
		storage.put(5, new Articulo("Collar", 10.55));
		
		
	}
	
	@Override
	
	public Articulo  findArticuloById(Integer identificador) {
		System.out.println("Buscando el ariculo con id: " + identificador);
		return  storage.get(identificador);
	}
	@Override
	public String insertarArticulo(Articulo articulo) {
		
		System.out.println("Insertado articulo con nombre: " + articulo.getNombre());
		 storage.put(storage.size()+1,articulo);
		return null;
	}
	@Override
	public Integer lastIndex() {
		return storage.size();
	}

}
