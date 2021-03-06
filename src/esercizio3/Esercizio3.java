/**
 * 
 */
package esercizio3;

import visita.VisitaAlbero;
import alberi.AlberoBinLF;

/**
 * @author HpProBook4520s
 * Java aiutami, che io ti aiuto!!
 */
public class Esercizio3 {
	public static boolean sonoIdentici (AlberoBinLF<Integer> a,AlberoBinLF<Integer> b) {
		if (a==null && b==null)
			return true;
		if (a.getVal() != b.getVal()
				||
			a==null || b==null)
			return false;
		return sonoIdentici((AlberoBinLF<Integer>)a.sin(), 
				(AlberoBinLF<Integer>)b.sin()) &&
				sonoIdentici( (AlberoBinLF<Integer>)a.des(),
				(AlberoBinLF<Integer>) b.des());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AlberoBinLF<Integer> a=new AlberoBinLF<Integer>();
		VisitaAlbero.crea(a);
		if( sonoIdentici(a, a))
			System.out.println("A == B");
		else
			System.out.println("A != B");
	}
}
