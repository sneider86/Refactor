import javax.swing.JOptionPane;

import com.refactor.Printer;

public class Inicio {
	
	public static void main(String args[]) {
		try {
			int fila = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de filas"));
			int columna = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero de comunas"));
			int numeros = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero maximo de numeros"));
			Printer p = new Printer(fila,columna,numeros);
			p.procesar();
			System.out.println("Numero maximo de paginas resultantes: "+p.getPageNumber());
		}catch(NumberFormatException e) {
			System.out.println("La información no pude ser: "+e.getMessage()+" debe ser numero");
		}
		
		
	}

}
