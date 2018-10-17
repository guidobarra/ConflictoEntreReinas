package base;

import java.io.FileNotFoundException;

public class AppReinas {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Escenario escenario = ArchivoReinas.read(".\\reina.in");
		ArchivoReinas.write(".\\reina.out", escenario.solucion());
	}

}
