package uno;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class Testtp1 {
	private Habitacion h1,h2,h3;
	
	@Before
	public void setUp() {
		h1= new Habitacion(10,20);
		h1.agregarCaja(3, 3, 4);
		h1.agregarCaja(3, 4, 4);
		h1.agregarCaja(3, 5, 4);
		
		h2= new Habitacion(20,15);
		h2.agregarCaja(3, 3, 4);
		
		
		h3=new Habitacion(10,20);
		h3.agregarCaja(3, 3, 4);
		h3.agregarCaja(3, 4, 4);
		h3.agregarCaja(3, 4, 4);
		h3.agregarCaja(3, 5, 4);
	}
	
	@Test
	public void testHabitacion() {
		assertTrue(h1.equals(h3));
		assertTrue(!h1.equals(h2));
	}
	@Test
	public void testPuedoAgregarCaja() {
		assertTrue(!h1.puedoAgregarCaja(100, 10));
	}
	@Test 
	public void testAGregarCaja() {
		int cant = h1.cantCajas();
		h1.agregarCaja(1, 1, 2);
		assertTrue(h1.cantCajas()!=cant);
	}
	@Test
	public void testReacomodarCajas() {
		int cant = h3.cantCajas();
		assertTrue(h1.cantCajas()== cant);
	}

}
