package com.nttdata.pruebasUnitarias.bbdd;

import java.util.List;

import com.nttdata.pruebasUnitarias.model.Articulo;

public interface CarritocompraServiceI {
	
	public void limpiarCesta();
	public void addArticulo(Articulo articulo);
	public Integer getNumbArticulo();
	public List<Articulo> getArticulos();
	public Double totalPrice();
	public Double calculadoraDescuento(Double precio, Double porcentajeDescuento);
	public double aplicarDescuento(Integer idArticulo, Double porcentaje);
	

}
