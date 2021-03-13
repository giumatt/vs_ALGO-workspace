package Esercitazioni_mie;

import alberi.AlberoBin;

public class esercitazioniVarie {
    
    //Verifica se a profondità p esiste qualche foglia con valore maggiore di zero.
    public static boolean verifica(AlberoBin<Integer> a, int l) {
        if(a == null) return false;
        if(l > 0)
            return ((verifica(a.sin(), l - 1)) || (verifica(a.des(), l - 1)));
        if((a.sin() == null && a.des() == null) && a.getVal() > 0)
            return true;
        return false;
    }

    //Restituisce true se e solo se l’albero binario di ricerca bilanciato contiene un intero x di valore pari e compreso nell’intervallo [min,max].
    public static boolean minMax(AlberoBin<Integer> a, int min, int max) {
        if(a == null) return false;
        if((a.getVal() % 2 == 0) && (a.getVal() >= min && a.getVal() <= max))
            return true;
        return ((minMax(a.sin(), min, max)) || (minMax(a.des(), min, max)));
    }

    //Restituisce true se e solo se gli alberi a1 e a2 sono identici, ossia sono uno la copia dell’altro.
    public static boolean identici(AlberoBin<Integer> a, AlberoBin<Integer> b) {
        if (a == null || a == null) return false;
        if (a.getVal() == b.getVal()) return true;
        return((identici(a.sin(), b.sin())) && (identici(a.des(), b.des())));
    }

    //Conta quante volte x è presente al livello l
    public static int conta(AlberoBin<Integer> a, int x, int l) {
        if(a == null) return 0;
        if(l > 0)
            return ((conta(a.sin(), x, l - 1)) + (conta(a.des(), x, l - 1)));
        if(a.getVal() == x) return 1;
        return 0;
    }

    //Restituisce true se e solo se vi è almeno un nodo n tale che x appartiene sia nel sottoalbero destro e sia nel sottoalbero sinistro
    public static boolean ver(AlberoBin<Integer> a, int x) {
        if(a == null) return false;
        return cerca(a, x) >= 1;
    }

    public static int cerca(AlberoBin<Integer> a, int x) {
        if(a == null) return 0;
        if (a.sin() != null || a.des() != null)
            return((cerca(a.sin(), x)) + (cerca(a.des(), x)));
        if(a.getVal() == x)
            return 1;
        return 0;
    }


}
