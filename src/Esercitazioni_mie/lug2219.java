package Esercitazioni_mie;

import alberi.AlberoBin;

/*Si deve realizzare un metodo ricorsivo che restituisce true se e solo se esiste in a al livello l almeno un nodo foglia n
che è figlio unico e tale che n.val() è contenuto in almeno un altro nodo che si trova a un qualsiasi livello l1 tale che 
l1 != l.*/

public class lug2219 {
    
    public static boolean verifica(AlberoBin<Integer> a, int l) {
        if(a == null) return false;
        if(a.sin() != null || a.des() != null)
            return((ver(a.sin(), 0)) || (ver(a.des(), 0)));
    }

    public static boolean ver(AlberoBin<Integer> a, int liv) {
        if(a == null) return false;
        if(a.sin() == null && a.des() == null)
            if(a.)
    }


}
