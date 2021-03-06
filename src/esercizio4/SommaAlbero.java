/**
 * 
 */
package esercizio4;

import visita.VisitaAlbero;
import alberi.AlberoBinLF;

/**
 * @author HpProBook4520s
 * Java aiutami, che io ti aiuto!!
 */
class SommaAlbero {
	
	@SuppressWarnings("deprecation")
	public static void creaAlbero (AlberoBinLF<Integer> a) {
		// radice dell'albero
		a.setVal(new Integer(2));
		
		// sotto-albero sinistro
		AlberoBinLF<Integer> figlioSx = new AlberoBinLF<Integer>();
		figlioSx.setVal(new Integer(10));
		a.setSin(figlioSx);
		
		// sotto-albero destro
		AlberoBinLF<Integer> figlioDx = new AlberoBinLF<Integer>();
		figlioDx.setVal(new Integer(10));
		a.setDes(figlioDx);
	}//crea
	
	public static int sommaAlbero (AlberoBinLF<Integer> a) {
		if( a == null )
			return 0;
		int somma = sommaAlbero( (AlberoBinLF<Integer>) a.sin() ) + 
				sommaAlbero( (AlberoBinLF<Integer>) a.des());
		return somma + a.getVal();
	}//sommaAlbero
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlberoBinLF<Integer> a = new AlberoBinLF<Integer>();
		creaAlbero(a);
		VisitaAlbero.visitaAnticipata(a);
		System.out.println("somma albero binario = "+sommaAlbero(a));
	}
}
