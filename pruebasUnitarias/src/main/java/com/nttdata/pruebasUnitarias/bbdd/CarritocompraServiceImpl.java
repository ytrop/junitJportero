package com.nttdata.pruebasUnitarias.bbdd;

import java.util.ArrayList;
import java.util.List;

import com.nttdata.pruebasUnitarias.model.Articulo;

public class CarritocompraServiceImpl implements CarritocompraServiceI {
	private BaseDatosServiceImpl baseDatos;

	List<Articulo> listaArticulos = new ArrayList<>();
	@Override
	public void limpiarCesta() {
		// TODO Auto-generated method stub
		listaArticulos.clear();
	}

	@Override
	public void addArticulo(Articulo articulo) {
		// TODO Auto-generated method stub
		listaArticulos.add(articulo);
		
		
	}

	@Override
	public Integer getNumbArticulo() {
		// TODO Auto-generated method stub
		return listaArticulos.size();
		
		
	}

	@Override
	public List<Articulo> getArticulos() {
		// TODO Auto-generated method stub
		return listaArticulos;
	}

	@Override
	public Double totalPrice() {
		// TODO Auto-generated method stub
		Double total = 0D;
		for(Articulo articulo:listaArticulos) {
			total = total + articulo.getPrecio();
			
		}
		return total;
	}

	@Override
	public Double calculadoraDescuento(Double precio, Double porcentajeDescuento) {
		// TODO Auto-generated method stub
		return precio = precio*porcentajeDescuento/100;
	}

	@Override
	public double aplicarDescuento(Integer idArticulo, Double porcentaje) {
		// TODO Auto-generated method stub
		
		Double resultado = 0D;
		Articulo articulo = baseDatos.findArticuloById(idArticulo);
		if(articulo != null) {
			resultado = calculadoraDescuento(articulo.getPrecio(), porcentaje);
			
		}else {
			System.out.println("No se ha encontradoningun articulo con ID: ");
		}
		
		return resultado;
	}
	
	
	

}
