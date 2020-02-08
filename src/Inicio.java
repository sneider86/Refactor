import javax.swing.JOptionPane;

import com.refactor.Printer;

public class Inicio {
	
	public static void main(String args[]) {
		try {
			int fila = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de filas"));
			int columna = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de columnas"));
			int numeros = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero maximo de numeros"));
			Printer p = new Printer(fila,columna,numeros);
			//p.procesar();//función original
			p.generarMatrizPrimo();//refactor generar matriz
			p.imprimirMatrizCompleta();//refactor imprimir matriz
			p.imprimirxPagina(3);//imprime solo la pagina que se le pase por parametro
			/*
			 * NOTA: deje variables y metodos anteriores solo para que pueda ser comparado,
			 * pero tratandoce de refactor podrian ser eliminados.
			 * 
			 */
		}catch(NumberFormatException e) {
			System.out.println("La información no pude ser: "+e.getMessage()+" debe ser numero");
		}
		
		
	}

}
