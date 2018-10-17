package base;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArchivoReinas {

	
	public static Escenario read(String path) throws FileNotFoundException{
		
		Scanner sc = new Scanner(new File(path));
		int dimensionTablero = sc.nextInt();
		int cantReinas = sc.nextInt();
		List<Reina> reinas = new ArrayList<>();
		int fila, col;
		
		for(int i = 0 ; i<cantReinas; i++){
			fila = sc.nextInt();
			col = sc.nextInt();
			reinas.add(new Reina(fila,col,i+1));
		}
		Collections.sort((List<Reina>) reinas);
		sc.close();
		return new Escenario(reinas, dimensionTablero);
	}
	
	public static void write(String path, Escenario esc) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File(path));
		for(int pos=0;pos<esc.getReinas().size();pos++) {
			for (Reina r : esc.getReinas()) {
				if((pos+1) == r.getPosicionEntrada() ) {
					if(r.getConflictos().isEmpty())
						pw.print(0);
					else
					{
						pw.print(r.getConflictos().size() + " ");
						for (Integer i : r.getConflictos()) 
							pw.print(i + " ");
						
					}
					pw.println("");
				}
			}
			
		}

		pw.close();
	}
	
}
