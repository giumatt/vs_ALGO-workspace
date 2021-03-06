package Esercitazioni_mie;

import alberi.AlberoBin;

/*Si deve realizzare un metodo ricorsivo che restituisce true se e solo se esiste almeno un valore che appare in un nodo di a
(non foglia) che abbia due figli ed il valore del nodo sia maggiore di zero.*/

public class algo18 {
    public static boolean verifica(AlberoBin<Integer> a) {
        if(a == null) return false;
        if((a.sin() != null) && (a.des() != null))
            if(a.getVal() > 0)
                return true;
        return(verifica(a.sin()) || verifica(a.des()));
    }
}
