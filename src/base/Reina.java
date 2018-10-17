package base;

import java.util.ArrayList;

public class Reina implements Comparable<Reina>{

	private ArrayList<Integer> conflictos = new ArrayList<>();

	private int fila, columna;
	private int posicionEntrada;
	
	
	private boolean diagSec = true;
	private boolean diagPrin = true;
	private boolean abajo = true;
	private boolean izq = true;
	
	public Reina(int fila, int col, int i) {
		
		this.fila = fila;
		this.columna = col;
		this.posicionEntrada = i;
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<Integer> getConflictos() {
		return conflictos;
	}


	public void setConflictos(ArrayList<Integer> conflictos) {
		this.conflictos = conflictos;
	}


	public int getColumna() {
		return columna;
	}


	public void setColumna(int columna) {
		this.columna = columna;
	}


	public int getPosicionEntrada() {
		return posicionEntrada;
	}


	public void setPosicionEntrada(int posicionEntrada) {
		this.posicionEntrada = posicionEntrada;
	}


	public void setFila(int fila) {
		this.fila = fila;
	}

	
	
	public boolean hayConflicto(Reina obj){
		/// no hay reinas en la misma fila la pone en false, para que en hipotetico caso de que encuentre reinas en la demas direcciones, corte el for 
		if(this.fila == obj.fila && izq) {
			izq = false;
			return true;
		}
		else izq = false;
			
		if( (this.fila-this.columna) == (obj.fila -obj.columna) && diagSec) {
			diagSec = false;
			return true;
		}
			
		if((this.fila+this.columna) == (obj.fila +obj.columna) && diagPrin) {
			diagPrin = false;
			return true;
		}
		
		if(this.columna==obj.columna && abajo) {
			abajo = false;
			return true;
		}
		return false;
	}
	
	public void conflicto(Reina obj) {
		this.conflictos.add(obj.posicionEntrada);
		obj.conflictos.add(this.posicionEntrada);
	}
	
	public boolean puedeHaberConflicto() {
		return abajo || diagPrin || diagSec;
	}

	@Override
	public int compareTo(Reina obj) {
		
		if(this.fila == obj.fila)
			return this.columna - obj.columna;
		
		// TODO Auto-generated method stub
		return this.fila - obj.fila;
	}
	
	public int getFila(){
		return this.fila;
	}

	@Override
	public String toString() {
		return "Reina [fila=" + this.fila + ", columna=" + this.columna + ", posicionEntrada=" + this.posicionEntrada + "]";
	}


	public void mostrarConfilcto() {
		// TODO Auto-generated method stub
		System.out.print("\n numero de reina "+ this.posicionEntrada + "   ");
		for (Integer integer : conflictos) {
			System.out.print(integer +" ");
		}
	}

}
