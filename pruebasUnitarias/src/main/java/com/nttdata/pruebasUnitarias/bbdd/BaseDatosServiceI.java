package com.nttdata.pruebasUnitarias.bbdd;

import com.nttdata.pruebasUnitarias.model.Articulo;

public interface BaseDatosServiceI {
	
	public void initBD();
	
	public Articulo findArticuloById(Integer identificador);
	public String insertarArticulo(Articulo articulo);
	public Integer lastIndex();

}
