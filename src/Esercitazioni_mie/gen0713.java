package Esercitazioni_mie;

import alberi.AlberoBin;

/*Si deve realizzare un metodo ricorsivo che restituisce true se e solo se esiste almeno un valore
che appare in un nodo di a che si trova ad un livello liv e tale valore appare anche in b in un nodo che si trova ad un livello maggiore di liv.*/

public class gen0713 {
    public static boolean verifica(AlberoBin<Integer> a, AlberoBin<Integer> b) {
        if(a == null || b == null) return false;
        return ver(a, b, 0, 0);
    }

    public static boolean ver(AlberoBin<Integer> a, AlberoBin<Integer> b, int liv, int l) {
        if(a == null || b == null) return false;
        if((liv > l) && (a.getVal() == b.getVal())) return true;
        return(ver(a, b.sin(), liv, l + 1) || ver(a, b.des(), liv, l + 1) || ver(a.sin(), b, liv + 1, l) || ver(a.des(), b, liv + 1, l));
    }
}
