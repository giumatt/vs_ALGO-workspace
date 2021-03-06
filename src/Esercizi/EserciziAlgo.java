package Esercizi;

//import alberi.AlberoBinLF;
//import alberi.AlberoLF;
import java.util.HashSet;

import alberi.AlberoBin;

//ATTENZIONE: NEI SEGUENTI ESERCIZI, LA RADICE DELL'ALBERO È CONSIDERATA CON LIVELLO UGUALE A 0.
//IL MAIN CONTIENE UN ALBERO GIÀ FORMATO SUL QUALE PROVARE I VARI ESERCIZI.
//OCCORRE AVERE I FILE DALLA CARTELLA GITHUB DEL PROFESSORE
public class EserciziAlgo {
	//restituisce true se, per ogni nodo foglia (chiamiamolo k)
	//di a, esiste un nodo NON FOGLIA in b tale che
	//il suo valore sia uguale a quello di k
	public static boolean verifica (AlberoBin<Integer> a, AlberoBin<Integer> b) {
		if (a == null)
			return false;
		else if (a.sin() == null && a.des() == null)
			return ver(b, a.getVal());
		else
			return (verifica(a.des(), b) && verifica(a.sin(), b));
	}
	
	public static boolean ver (AlberoBin<Integer> b, int z) {
		if (b == null)
			return false;
		if (b.sin() == null && b.des() == null)
			return false;
		if (b.getVal().equals(z))
			return true;
		return (ver(b.des(), z) || ver(b.sin(), z));
	}

	//ritorna true se esiste un nodo FOGLIA di a tale che i suoi antenati siano tutti
	//maggiori di 0 ed esso sia, invece, minore di 0
	public static boolean verifica2 (AlberoBin<Integer> a) {
		if (a == null)
			return false;
		if (a.sin() == null && a.des() == null && a.getVal() < 0)
			return true;
		if (a.getVal() < 0)
			return false;
		return (verifica2(a.sin()) || verifica2(a.des()));
	}

	//ritorna true se esiste almeno un nodo in cui i figli destro e sinistro hanno entrambi
	//valore x
	public static boolean eRipetuto (AlberoBin<Integer> a, int x) {
		if (a == null)
			return false;
		if(a.sin() == null || a.des() == null)
			return false;
		if(a.sin().getVal() == x && a.des().getVal() == x)
			return true;
		return(eRipetuto(a.sin(), x) || eRipetuto(a.des(), x));
	}

	//ritorna vero se esiste almeno un nodo in a ad un livello liv contenuto, in b,
	//ad un livello maggiore di liv
	public static boolean VerificaLiv (AlberoBin<Integer> a, AlberoBin<Integer> b) {
		if (a == null)
			return false;
		return VerificaLiv2(a, b, 0, 0);
	}

	public static boolean VerificaLiv2 (AlberoBin<Integer> a, AlberoBin<Integer> b, int liv, int h) {
		if (b == null)
			return false;
		if (a == null)
			return false;
		if (h > liv)
			if (b.getVal() == a.getVal())
				return true;
		return (VerificaLiv2(a, b.sin(), liv, h + 1) || VerificaLiv2(a, b.des(), liv, h + 1) || VerificaLiv2(a.des(), b, liv + 1, 0) || VerificaLiv2(a.sin(), b, liv + 1, 0));
	}

	//ritorna numero di valori pari memorizzati nell'albero a a livello k
	public static int contaLivello (AlberoBin<Integer> a, int k) {
	if (a == null)
		return 0;
	if (k > 0)
		return (contaLivello(a.sin(), k - 1) + contaLivello(a.des(), k - 1));
	if (a.getVal()%2 == 0)
		return 1;
	return 0;
	}

	//ritorna vero se tutti i valori di a sono contenuti in b
	public static boolean maggiore (AlberoBin<Integer> a, AlberoBin<Integer> b) {
		if (a == null)
			return true;
		if (b == null)
			return false;
		if (a.getVal() == b.getVal())
			return (maggiore(a.sin(), b) && maggiore(a.des(), b));
		return (maggiore(a, b.sin()) || maggiore(a, b.des()));
		
	}

	//ritorna vero solo se tutti i nodi FOGLIA a livello l dell'albero a sono
	//maggiori o uguali a 0
	public static boolean verifica3 (AlberoBin<Integer> a, int l) {
		if (a == null) return false;
		return verifica3_2(a, 0, l);
	}

	public static boolean verifica3_2 (AlberoBin<Integer> a, int liv, int l) {
		if (a == null)
			return true;
		if (liv==l) {
			if (a.sin() == null && a.des() == null) {
				if (a.getVal() >= 0)
					return true;
				else
					return false;
			}
			else
				return true;
		}
		return (verifica3_2(a.des(), liv + 1, l) && verifica3_2(a.sin(), liv + 1, l));
	}

	//ritorna true se tutti i nodi non foglia di a contengono un valore che appare
	//almeno in un nodo foglia di a
	public static boolean verifica4 (AlberoBin<Integer> a) {
		if (a == null)
			return false;
		return verifica4_2(a, a.getVal()) && verifica4_2(a, a.des().getVal()) && verifica4_2(a, a.sin().getVal());
	}

	public static boolean verifica4_2 (AlberoBin<Integer> a, int k) {
		if (a == null)
			return false;
		else if (a.des() == null && a.sin() == null) {
			if(a.getVal() == k)
				return true;
			else if(a.getVal() != k)
				return false;
		}
			return ((verifica4_2(a.sin(), k) || verifica4_2(a.des(), k)));
	}

	//ritorna true se esistono almeno due nodi tali che la somma tra il loro valore e il valore del livello in cui si trovano è minore di zero
	//N.B. POSSONO ESSERE IN LIVELLI DIVERSI, QUALUNQUE LIVELLO VA BENE
	public static boolean verificaDueNodi(AlberoBin<Integer> a) {
		return verificaDueNodi2(a, 0, 0) >= 2;
	}

	public static int verificaDueNodi2(AlberoBin<Integer> a, int liv, int temp) {
		if (a == null)
			return temp;
		if((a.getVal() + liv) < 0)
			return (verificaDueNodi2(a.des(), liv + 1, temp) + verificaDueNodi2(a.sin(), liv + 1, temp + 1));
		return (verificaDueNodi2(a.des(), liv + 1, temp) + verificaDueNodi2(a.sin(), liv + 1, 0));
	}

	//ritorna true se esistono due nodi n ed m al livello l tali che n.val()==m.val()
	public static boolean dueNodiLivello (AlberoBin<Integer> a, int liv) {
		if (a == null)
			return false;
		HashSet<Integer> values = new HashSet<Integer>();
		return riempi(a, liv, values);
	}

	public static boolean riempi (AlberoBin<Integer> a, int liv, HashSet<Integer> values) {
		if (a == null)
			return false;
		if (liv == 0)
			if (values.add(a.getVal()) == false)
				return true;
		return (riempi(a.sin(), liv - 1, values) || riempi(a.des(), liv-1, values));
	}

	//ritorna true se, per ogni nodo foglia, il padre di quel nodo contiene un valore maggiore di 0
	public static boolean verificapadrefoglia (AlberoBin<Integer> a) {
		if (a == null)
			return false;
		if (a.des() == null && a.sin() == null)
			return false;
		if (a.des().des() == null && a.sin().sin() == null && a.des().sin() == null && a.sin().des() == null)
			if (a.getVal() > 0)
				return true;
		return (verificapadrefoglia(a.des()) && verificapadrefoglia(a.sin()));
	}
	
	//ritorna true se esiste almeno un nodo a liv liv con valore=0 e del quale tutti i discendenti abbiano valore=0
	public static boolean verificaCammino(AlberoBin<Integer> a, int liv) {
		if (a == null)
			return false;
		if (liv > 0)
			return (verificaCammino(a.sin(), liv - 1) || verificaCammino(a.des(), liv - 1));
		if (a.getVal() != 0)
			return false;
		if (a.des() == null && a.des() == null)
			return (a.getVal() == 0);
		if (a.des() == null && (a.sin() != null))
			return (verificaCammino(a.sin(), liv));
		if (a.des() != null && (a.sin() == null))
			return (verificaCammino(a.des(), liv));
		return(verificaCammino(a.sin(), 0) && verificaCammino(a.des(), 0));
	}

	//ritorna true se al livello l esistono due nodi n ed m tali che n.val()+x=m.val()+y, dove x è la somma
	//di tutti i valori degli antenati di n ed y è la somma di tutti i valori degli antenati di m
	public static boolean verificasomma(AlberoBin<Integer> a, int l) {
		if (a == null)
			return false;
		HashSet<Integer> z = new HashSet<Integer>();
		return verificasomma2(a, l, 0, z);
	}

	public static boolean verificasomma2(AlberoBin<Integer> a, int l, int sum, HashSet<Integer> z) {
		if (a == null)
			return false;
		if (l == 0)
			return (!z.add(a.getVal() + sum));
		else
			return (verificasomma2(a.des(), l - 1, sum + a.getVal(), z) || verificasomma2(a.sin(), l - 1, sum + a.getVal(), z));
	}

	/*@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws AlberiDiversiException{
		AlberoBinLF<Integer> a=new AlberoBinLF(5);
		AlberoBinLF<Integer> b=new AlberoBinLF(1);
		AlberoBinLF<Integer> c=new AlberoBinLF(10);
		AlberoBinLF<Integer> d=new AlberoBinLF(0);
		AlberoBinLF<Integer> e=new AlberoBinLF(18);
		AlberoBinLF<Integer> f=new AlberoBinLF(9);
		AlberoBinLF<Integer> g=new AlberoBinLF(2);
		a.setFiglio(b, 0);
		a.setFiglio(c, 1);
		b.setFiglio(d, 0);
		b.setFiglio(e, 1);
		c.setFiglio(f, 0);
		c.setFiglio(g, 1);
	}*/
}
