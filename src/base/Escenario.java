package base;


import java.util.List;



public class Escenario {

	private List<Reina> reinas;
	private int dimTablero;
	
	public List<Reina> getReinas() {
		return reinas;
	}


	public void setReinas(List<Reina> reinas) {
		this.reinas = reinas;
	}


	public int getDimTablero() {
		return dimTablero;
	}


	public void setDimTablero(int dimTablero) {
		this.dimTablero = dimTablero;
	}


	public Escenario(List<Reina> reinas, int dimensionTablero) {
		this.reinas = reinas;
		this.dimTablero = dimensionTablero;		
	}

	
	public Escenario solucion(){
		
		int cantReinas = reinas.size();		
		int posAct=0;
		
		for(Reina rAct: reinas) {
			for(int i=posAct+1;i<cantReinas;i++) {
				if(rAct.puedeHaberConflicto()) {
					if(rAct.hayConflicto(reinas.get(i)))
						rAct.conflicto(reinas.get(i));
				}
				else
					break;
			}
			posAct++;
		}
		
		
		return this;
	}


	public void mostrar() {
		// TODO Auto-generated method stub
		for (Reina r : reinas) {
			r.mostrarConfilcto();
		}
	}


}
