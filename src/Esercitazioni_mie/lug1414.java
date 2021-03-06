package Esercitazioni_mie;

import alberi.AlberoBin;

/*Si realizzi un metodo ricorsivo che restituisce true se e solo se esistono almeno due nodi dell'albero che soddisfano la proprietà A.
Un nodo soddisfa la proprietà A se la somma tra il valore contenuto in esso ed il valore del livello in cui si trova è minore di zero.*/

public class lug1414 {
    public static boolean verifica(AlberoBin<Integer> a) {
        if(a == null) return false;
        return verificaDueNodi(a, 0, 0) >= 2;
    }

    public static int verificaDueNodi(AlberoBin<Integer> a, int l, int liv) {
        if((a.getVal() + l) < 0)
            return((verificaDueNodi(a.sin(), l + 1, liv + 1)) + (verificaDueNodi(a.des(), l + 1, liv)));
        return((verificaDueNodi(a.sin(), l + 1, liv + 1)) + (verificaDueNodi(a.des(), l + 1, liv)));
    }
}
