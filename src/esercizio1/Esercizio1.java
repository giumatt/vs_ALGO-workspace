/**
 * 
 */
package esercizio1;

import alberi.AlberoBinLF;
import visita.*;

/**
 * @author HpProBook4520s
 * Java aiutami, che io ti aiuto!!
 */
class Esercizio1 {
	
	public static boolean maggiore(AlberoBinLF<Integer> a, int k) {
		if(a==null)
			return true;
		if(a.sin()==null && a.des()==null)
			//sono ad una foglia
			return a.getVal()>=k;
		return maggiore((AlberoBinLF<Integer>)a.sin(), k) &&
				maggiore((AlberoBinLF<Integer>)a.des(),k);
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlberoBinLF<Integer> a=new AlberoBinLF<Integer>();
		VisitaAlbero.crea(a);
		VisitaAlbero.stampaAlbero(a);
		//System.out.println(maggiore(a,50));
	}
}
