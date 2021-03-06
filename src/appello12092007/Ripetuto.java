/**
 * 
 */
package appello12092007;

import visita.VisitaAlbero;
import alberi.AlberoBinLF;

/**
 * @author HpProBook4520s
 * Java aiutami, che io ti aiuto!!
 */
public class Ripetuto {
	@SuppressWarnings("deprecation")
	public static void creaAlbero(AlberoBinLF<Integer> a) {
		// radice dell'albero
		a.setVal(new Integer(2));
		
		// sotto-albero sinistro
		AlberoBinLF<Integer> figlioSx = new AlberoBinLF<Integer>();
		figlioSx.setVal(new Integer(3));
		a.setSin(figlioSx);
		
		// sotto-albero destro
		AlberoBinLF<Integer> figlioDx = new AlberoBinLF<Integer>();
		figlioDx.setVal(new Integer(3));
		a.setDes(figlioDx);
	}//crea
	
	public static boolean eRipetuto( AlberoBinLF<Integer> a, int x)
	{
		// a non esiste
		if( a == null )
			return false;
		boolean trovato = trovaValore((AlberoBinLF<Integer>)
				a.sin(), x ) && 
				trovaValore((AlberoBinLF<Integer>) a.des(), x);
		if( trovato )
			return true;
		return eRipetuto((AlberoBinLF<Integer>) a.sin(), x ) ||
				eRipetuto((AlberoBinLF<Integer>) a.des(), x );
	}
	
	private static boolean trovaValore(AlberoBinLF<Integer> a, int x)
	{
		//sono arrivato ad una foglia
		if( a == null )
			return false;
		if( a.getVal() == x )
			return true;
		return trovaValore((AlberoBinLF<Integer>)a.sin(),x) ||
				trovaValore((AlberoBinLF<Integer>)a.des(), x);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		AlberoBinLF<Integer> a = new AlberoBinLF<Integer>();
		creaAlbero(a);
		VisitaAlbero.visitaAnticipata(a);
		int x=3;
		System.out.println("x="+x+" ripetuto nell'AlberoA? "+eRipetuto(
				(AlberoBinLF<Integer>)a,x));
		
	}

}
