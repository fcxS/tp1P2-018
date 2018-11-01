package uno;

import java.util.Iterator;

public class pruebaiterator {

	public static void main(String[] args) {
			Habitacion h1 = new Habitacion(10,20);
			h1.agregarCaja(3, 3, 4);
			h1.agregarCaja(3, 4, 4);
			h1.agregarCaja(3, 5, 4);
			
			/*for(Cajas c: h1) {
				System.out.println(c);
			}*/
			Iterator<Cajas> it = h1.iterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
		

}
