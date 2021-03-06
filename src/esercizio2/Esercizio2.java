package esercizio2;

import visita.VisitaAlbero;
import alberi.AlberoBinLF;

public class Esercizio2 {
	public static int contaDispari (AlberoBinLF<Integer> a) {
		if(a==null)
			return 0;
		int contatoreDispari=contaDispari((AlberoBinLF<Integer>) a.sin()) +
				contaDispari((AlberoBinLF<Integer>) a.des());
		if (a.getVal()%2!=0)
			return contatoreDispari+1;
		return contatoreDispari;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlberoBinLF<Integer> a=new AlberoBinLF<Integer>();
		VisitaAlbero.crea(a);
		System.out.println("Visita anticipata\n\n");
		VisitaAlbero.visitaAnticipata(a);
		System.out.println("\n\n\n");
		VisitaAlbero.stampaAlbero(a);
		System.out.println(contaDispari(a));
	}
}
