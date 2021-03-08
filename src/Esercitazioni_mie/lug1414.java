package Esercitazioni_mie;

import alberi.AlberoBin;

/*Si realizzi un metodo ricorsivo che restituisce true se e solo se esistono almeno due nodi dell'albero che soddisfano la proprietà A.
Un nodo soddisfa la proprietà A se la somma tra il valore contenuto in esso ed il valore del livello in cui si trova è minore di zero.*/

public class lug1414 {
    public static boolean verifica(AlberoBin<Integer> a) {
        if(a == null) return false;
        return ver(a, 0, 0) >= 2;
    }

    public static int ver(AlberoBin<Integer> a, int liv, int k) {
        if(a == null) return k;
        if((a.getVal() + liv) < 0)
            return((ver(a.sin(), liv + 1, k + 1)) + (ver(a.des(), liv + 1, k + 1)));
        return ((ver(a.sin(), liv + 1, 0)) + (ver(a.des(), liv + 1, 0)));
    }
}
