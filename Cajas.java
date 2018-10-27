package uno;

import java.util.Iterator;

public class Cajas{
	private int _ancho;
	private int _largo;
	private int _elemento;
	
	Cajas( int ancho , int largo , int elemento) {
		_ancho = ancho;
		_largo = largo;
		_elemento = elemento;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cajas [_ancho=");
		builder.append(_ancho);
		builder.append(" ,_Largo=");
		builder.append(_largo);
		builder.append(",_elemento=");
		builder.append(_elemento);
		builder.append("]");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + _ancho;
		result = prime * result + _largo;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Cajas other = (Cajas) obj;
		
		if(_ancho != other._ancho)
			return false;
		if(_elemento != other._elemento)
			return false;
		if(_largo != other._largo)
			return false;
		return true;
		
	}
	int area() {
		return 1;
	}
	
	
}
