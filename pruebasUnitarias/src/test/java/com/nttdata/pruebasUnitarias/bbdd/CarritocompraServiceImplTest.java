package com.nttdata.pruebasUnitarias.bbdd;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.nttdata.pruebasUnitarias.model.Articulo;
@TestMethodOrder(OrderAnnotation.class)	
@ExtendWith(MockitoExtension.class)	
class CarritocompraServiceImplTest {
	

	@InjectMocks
	private  CarritocompraServiceImpl carrito = new CarritocompraServiceImpl();
	
	@Mock
	private BaseDatosServiceImpl BaseService;
	
	private List<Articulo> listArticulos;
	
	
	@BeforeEach
	void testinitBD()  {
		listArticulos = carrito.getArticulos();
	
	}

	@Test
	@Order(4)
	void testlimpiarCesta() {
		System.out.println("Test Total Price");
		assertTrue(listArticulos.isEmpty());
		carrito.addArticulo(new Articulo ("Gorra", 30.15));
		assertFalse(listArticulos.isEmpty());
		carrito.limpiarCesta();
		assertTrue(listArticulos.isEmpty());
		
	}

	@Test
	@Order(1)
	void testAddArticulo() {
		System.out.println("Test add articulo");
		assertTrue(listArticulos.isEmpty());
		carrito.addArticulo(new Articulo("Articulo nuevo",30.10));
		assertFalse(listArticulos.isEmpty());
		assertEquals(1,2);
		
	}

	@Test
	@Order(2)
	void testTotalPrice() {
		System.out.println("Test Total Price");
		carrito = new CarritocompraServiceImpl();
		carrito.addArticulo(new Articulo ("Gorra", 10.15));
		carrito.addArticulo(new Articulo ("Sombrero", 35.35));
		carrito.addArticulo(new Articulo ("Boina", 30.50));
		Double resultado = carrito.totalPrice();
		assertEquals(resultado,76.00);
		
		
	}
	

	@Test
	@Order(3)
	void testCalculadoraDescuento() {
		System.out.println("Test calculadora descuento");
		
		assertEquals(25,carrito.calculadoraDescuento(50.00, 50.00));
		
	}
	
	@Test
	@Order(5)	
	
	void testGetNumArticulo() {
		System.out.println("Test numero articulo");
		assertEquals(listArticulos.size(),carrito.getArticulos().size());
	}
	
	@Test
	@Order(6)
	void testGetArticulos() {
		System.out.println("Test get articulos");
		assertTrue(carrito.getArticulos().containsAll(listArticulos));
	}

	
	
	
}


