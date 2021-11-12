package com.nttdata.pruebasUnitarias;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.nttdata.pruebasUnitarias.bbdd.BaseDatosServiceImpl;
import com.nttdata.pruebasUnitarias.model.Articulo;

@SpringBootApplication
public class PruebasUnitariasApplication implements CommandLineRunner {
@Autowired
private BaseDatosServiceImpl  baseDatosService;


	public static void main(String[] args) {
		SpringApplication.run(PruebasUnitariasApplication.class, args);
	}
	
	@Override
	
	public void run( String... args) {
		
		baseDatosService.initBD();
		Articulo articulo = new Articulo("Calcetines", 5.95);
		baseDatosService.insertarArticulo(articulo);
		baseDatosService.findArticuloById(baseDatosService.lastIndex());
		
		
		
	}
}
