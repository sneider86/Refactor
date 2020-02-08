package com.refactor;

public class Printer {
	private int PAGENUMBER;
	private int PAGEOFFSET;
	private int ROWOFFSET;
	private int RR;
	private int CC;
	private int M;
	final int ORDMAX = 30;
	private int matriz[][];
	private int rporpagina;
	private int totalpaginas = 0;
	
	public Printer() {
		this.PAGENUMBER = 1;
		this.PAGEOFFSET = 1;
		this.ROWOFFSET 	= 0;
		this.RR = 50;
		this.CC = 4;
		this.M = 100;
	}
	public Printer(int filas,int columnas,int maximo) {
		this.PAGENUMBER = 1;
		this.PAGEOFFSET = 1;
		this.ROWOFFSET 	= 0;
		this.RR = filas;
		this.CC = columnas;
		this.M = maximo;
		this.rporpagina = 0;
		this.totalpaginas = 0;
	}
	public int getPageNumber() {
		return this.PAGENUMBER;
	}
	public void setPageNumber(int pg) {
		this.PAGENUMBER = pg;
	}
	public int getPageOffSet() {
		return this.PAGEOFFSET;
	}
	public void setPageOffSet(int PAGEOFFSET) {
		this.PAGEOFFSET = PAGEOFFSET;
	}
	public int getRowOffSet() {
		return this.ROWOFFSET;
	}
	public void setRowOffSet(int ROWOFFSET) {
		this.ROWOFFSET = ROWOFFSET;
	}
	public void procesar() {
		int P[] = new int[this.M+1];
		boolean JPRIME;
		int ORD;
		int SQUARE;
		int N=0;
		int MULT[] = new int[this.ORDMAX+1];
		int J=1;
		int K=1;
		int C;
		P[1] = 2;
		ORD = 2;
		SQUARE = 9;
		while (K < this.M) {
			do {
				J += 2;
				if( J == SQUARE) {
					ORD++;
					SQUARE=P[ORD]*P[ORD];
					MULT[ORD-1]=J;
				}
				N=2;
				JPRIME=true;
				while (N < ORD && JPRIME) {
					while (MULT[N]<J)
						MULT[N] += P[N] + P[N];
					if (MULT[N] == J)
						JPRIME=false;
					N++;
				}
			}while (!JPRIME);
			K++;
			P[K]=J;
		}
		while (this.PAGEOFFSET <= this.M) {
			System.out.print("The First ");
			System.out.print(Integer.toString(this.M));
			System.out.print(" Prime Numbers === Page ");
			System.out.print(Integer.toString(this.PAGENUMBER));
			System.out.println("\n");
			for (this.ROWOFFSET=this.PAGEOFFSET; this.ROWOFFSET <= this.PAGEOFFSET+this.RR-1;this.ROWOFFSET++) {
				for (C = 0; C <= this.CC - 1; C++)
					if (this.ROWOFFSET + C * this.RR <= this.M)
						System.out.printf("%10d", P[this.ROWOFFSET + C * this.RR]);
					System.out.println();
			}
			System.out.println("\f");
			this.PAGENUMBER++;
			this.PAGEOFFSET += this.RR*this.CC;
		}
		this.PAGENUMBER--;
	}
	public int getFilasXmostrar() {
		return this.RR;
	}
	public void setFilasXmostrar(int row) {
		this.RR = row;
	}
	public int getColumnasXmostrar() {
		return this.CC;
	}
	public void setColumnasXmostrar(int columnas) {
		this.CC = columnas;
	}
	public int getMaximodeNumeros() {
		return this.M;
	}
	public void setMaximodeNumeros(int m) {
		this.M = m;
	}
	public void generarMatrizPrimo() {
		this.rporpagina = this.RR * this.CC;
		this.totalpaginas = (int)Math.ceil(this.M / this.rporpagina);
		int nrows = totalpaginas*this.RR;
		this.matriz = new int[nrows][this.CC];
		int i=-1;
		int j=0;
		int numero = 2;
		boolean buscarnumeros = true;
		int primosencontrados = 0;
		int pagina = 1;
		while(buscarnumeros) {
			if(this.isPrimo(numero)) {
				i=this.getFilaMatriz(i, this.RR, pagina-1);
				this.matriz[i][j] = numero;
				primosencontrados++;
				if(i==(this.RR*pagina)-1) {
					j++;
				}
				if(j==this.CC) {
					j=0;
					pagina++;
				}
				if(primosencontrados==this.M) {
					buscarnumeros=false;
				}
			}
			numero++;
		}
	}
	private boolean isPrimo(int numero) {
        boolean flag = false;
        for(int i = 2; i <= numero/2; ++i){
            if(numero % i == 0){
                flag = true;
                break;
            }
        }
        if (!flag) {
        	return true;
        }else {
        	return false;
        }
	}
	public void imprimirMatrizCompleta() {
		boolean imprimir = true;
		int i=0,j=0,cuenta=0;
		int pagina = 1;
		int total = 1;
		System.out.println("========================PAGINA Nro: "+pagina+"=========================================");
		while(imprimir) {
			System.out.printf("%10d", this.matriz[i][j]);
			j++;
			if(j==this.CC) {
				i++;
				j=0;
				System.out.println("");
				
			}
			if(cuenta==this.rporpagina-1 && total<this.M) {
				cuenta=0;
				pagina++;
				System.out.println("");
				System.out.println("\f");
				System.out.println("========================PAGINA Nro: "+pagina+"=========================================");
				System.out.println("");
			}else {
				cuenta++;
			}
			total++;
			if(total>this.M) {
				imprimir=false;
				System.out.println("");
				System.out.println("\f");
			}
		}
	}
	private int getFilaMatriz(int f,int maxrow,int pagina) {
		if(f==( maxrow*(pagina+1)-1)) {
			f=(maxrow*pagina)-1;
		}
		f++;
		return f;
	}
	public void imprimirxPagina(int pagina) {
		if(pagina>this.totalpaginas) {
			System.out.println("La matriz procesada no tiene tantas paginas");
		}else {
			boolean imprimir = true;
			int i=(pagina-1)*this.RR,j=0,cuenta=0;
			int total = 1;
			System.out.println("========================PAGINA Nro: "+pagina+"=========================================");
			while(imprimir) {
				System.out.printf("%10d", this.matriz[i][j]);
				j++;
				if(j==this.CC) {
					i++;
					j=0;
					System.out.println("");
					
				}
				if(cuenta==this.rporpagina-1 && total<this.M) {
					cuenta=0;
					pagina++;
					imprimir=false;
				}else {
					cuenta++;
				}
				total++;
				if(total>this.M) {
					imprimir=false;
					System.out.println("");
					System.out.println("\f");
				}
			}
		}
		
	}
	public int getTotalPaginas(){
		return this.totalpaginas;
	}
	public int getCantRegistrosPorPagina(){
		return this.rporpagina;
	}
	public int[][] getMatrizGenerada(){
		return this.matriz;
	}
}
