package uno;

import java.util.HashMap;

public class Habitacion {
	private int _ancho;
	private int _largo;
	
	private HashMap<Coordenadas , Cajas> _cajas;
	boolean [][] _habitacion;
	
	Habitacion (int ancho , int largo){
		_ancho = ancho;
		_largo = largo;
		_cajas = new HashMap<Coordenadas , Cajas>();
		_habitacion = new boolean [largo][ancho];
	}
	public void agregarCaja(int ancho , int largo, int elemento) {
		Coordenadas c = new Coordenadas (0,0);
		if(factibilidad (ancho,largo,c)) {
			for(int i=c.y ; i < c.y+largo;i++) {
				for( int j =c.x;j<c.x+ancho;j++) {
					_habitacion[i][j]= true;
				}
			}
			_cajas.put(c, new Cajas(ancho,largo,elemento));
		}else {
			throw new RuntimeException("Caja infactible");
		}
		
	}

	public boolean puedoAgregarCaja(int ancho , int largo) {
		Coordenadas c = new Coordenadas(0,0);
		return factibilidad(ancho ,largo ,c);
	}
	private boolean factibilidad(int ancho, int largo, Coordenadas c) {
		if(ancho > _ancho || largo > _largo)
			return false;
		c.x=0;
		c.y=0;
		boolean ok = false;
		//buscar una coordenada factible y la asigna
		while(!ok && c.y <_largo) {
			ok= fact2(c.x,c.y,ancho,largo);
			if(!ok) incrementar(c);
		}
		return ok;
	}
	private void incrementar(Coordenadas c) {
		if(c.x < _ancho-1)
			c.x=c.x+1;
		else {
			c.x=0;
			c.y=c.y+1;
		}
	}
	private boolean fact2(int x , int y, int ancho , int largo) {
		boolean ret = false;
		
		if(x+ancho < _ancho && y+largo < _largo) {
			ret = true;
			
			for(int i = y; i< y+largo;i++) {
				for(int j=x; j<x+largo;j++) {
					ret = ret && !_habitacion[i][j];
				}
			}
		}
		return ret;
	}
	@Override
	public boolean equals (Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Habitacion other = (Habitacion) obj;
		if(_ancho != other._ancho)
			return false;
		if(_largo != other._largo)
			return false;
		if(_cajas.size() != other._cajas.size())
			return false;
		
		for(Coordenadas c: _cajas.keySet()) {//tengo la misma coordenada en la otra habitacion
			if(other._cajas.keySet().contains(c)) { // me fijo si es la misma caja
				if(!_cajas.get(c).equals(other._cajas.get(c))) { 
					return false; //era la misma
				}
			}else {
				return false;
			}
		}
		return true;
	}
	

	

}
