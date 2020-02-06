package com.refactor;

public class Printer {
	private int PAGENUMBER;
	private int PAGEOFFSET;
	private int ROWOFFSET;
	private int RR;
	private int CC;
	private int M;
	final int ORDMAX = 30;
	
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
}
