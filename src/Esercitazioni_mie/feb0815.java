package Esercitazioni_mie;

import alberi.AlberoBin;

//Realizzare un metodo che restituisce true se e solo se tutti i nodi non foglia di a contengono un valore che appare in almeno un nodo foglia di a.

public class feb0815 {
    
    public static boolean verifica(AlberoBin<Integer> a) {
        if(a == null) return false;
        if(a.des() != null || a.sin() != null)
            return ver(a, a.val());
        return verifica(a.sin()) || verifica(a.des());
    }

    public static boolean ver(AlberoBin<Integer> a, int val) {
        if(a == null) return false;
        if((a.sin() == null && a.des() == null) && a.val() == val) return true;
        return ver(a.sin(), val) || ver(a.des(), val);
    }
}
