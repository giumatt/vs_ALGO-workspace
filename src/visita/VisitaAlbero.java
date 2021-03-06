package visita;

import java.util.Random;

import alberi.AlberoBin;
import alberi.AlberoBinLF;

public class VisitaAlbero {
	private static Random random = new Random();
	
	public static void visitaAnticipata(AlberoBinLF<Integer> a)
	{
		if (a == null)
			return;
		System.out.println(a.getVal());
		visitaAnticipata((AlberoBinLF<Integer>) a.sin());
		visitaAnticipata((AlberoBinLF<Integer>) a.des());
	}//visitaAnticipata
	
	public static void visitaPosticipata(AlberoBinLF<Integer> a)
	{
		if(a == null)
			return;
		visitaPosticipata((AlberoBinLF<Integer>)a.sin());
		visitaPosticipata((AlberoBinLF<Integer>) a.des());
		System.out.println(a.getVal());
	}//visitaPosticipata

	public static void visitaInFissa(AlberoBinLF<Integer> a)
	{
		if(a == null)
			return;
		visitaInFissa((AlberoBinLF<Integer>)a.sin());
		System.out.println(a.getVal());
		visitaInFissa((AlberoBinLF<Integer>) a.des());
	}//visitaInFissa
	
	public static void crea(AlberoBinLF<Integer> a)
	{
		// radice dell'albero
		a.setVal(random.nextInt(50));
		// sotto-albero sinistro
		AlberoBinLF<Integer> figlioSx = new AlberoBinLF<Integer>();
		figlioSx.setVal(random.nextInt(50));
		a.setSin(figlioSx);
		// sotto-albero destro
		AlberoBinLF<Integer> figlioDx = new AlberoBinLF<Integer>();
		figlioDx.setVal(random.nextInt(50));
		a.setDes(figlioDx);
	}//crea
	
	public static void stampaAlbero(AlberoBin<Integer> alberoB, String before, String after) {
	    if(alberoB==null)
	      return;

	    stampaAlbero(alberoB.des(), before+"     ", before+"    |");

	    System.out.print(before.substring(0,before.length()-1));

	    System.out.println("+--["+alberoB.getVal()+"]");

	    stampaAlbero(alberoB.sin(), after+"    |", after+"     ");
	  }

	  public static void stampaAlbero(AlberoBinLF<Integer> a) {
	    if(a==null)
	      System.out.println("(albero vuoto)");
	    else
	      stampaAlbero(a, " ", " ");
	  }

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		AlberoBinLF<Integer> a=new AlberoBinLF<Integer>();
		crea(a);
		System.out.println("Visita ANTICIPATA");
		visitaAnticipata(a);
		System.out.println();
		System.out.println("Visita POSTICIPATA");
		visitaPosticipata(a);
		System.out.println();
		System.out.println("Visita INFISSA");
		visitaInFissa(a);
	}

}
