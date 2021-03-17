package Esercitazioni_mie;

import alberi.AlberoBin;

public class senzaData {
    
/*Si deve realizzare un metodo che restituisce true se e solo se esiste un nodo che si trova al livello l nell'albero a
che ha valore 0 ed i cui discendenti hanno tutti valore 0*/

    public static boolean verificaCammini(AlberoBin<Integer> a, int l) {
        if(a == null) return false;
        if(l > 0)
            return verificaCammini(a.sin(), l - 1) && verificaCammini(a.des(), l - 1);
        if(l <= 0)
            return a.getVal() == 0;
        return verificaCammini(a.sin(), l - 1) && verificaCammini(a.des(), l - 1);            
    }
/*
Complessità spaziale migliore Theta(l)
Complessità spaziale peggiore Theta(n)

Complessità temporale migliore Theta(l) o in caso di albero AVL sarebbe Theta(log(n))
Complessità temporale peggiore Theta(n)
*/
}


