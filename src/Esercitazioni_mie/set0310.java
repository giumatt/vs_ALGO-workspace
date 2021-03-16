package Esercitazioni_mie;

import alberi.AlberoBin;

//Realizzare un metodo che restituisce true se e solo se almeno una delle foglie più profonde dell’albero contiene un valore maggiore o uguale a zero.

public class set0310 {
    public static boolean fogliaProfonda(AlberoBin<Integer> a) {
        int altezza = altezza(a);
        return verifica(a.sin(), 1, altezza) || verifica(a.des(), 1, altezza);
    }

    public static boolean verifica(AlberoBin<Integer> a, int h, int altezza) {
        if(a == null) return false;
        if((a.sin() == null && a.des() == null) && h == altezza) return a.getVal() >= 0;
        return verifica(a.sin(), h + 1, altezza) || verifica(a.des(), h + 1, altezza);
    }

    public static int altezza(AlberoBin<Integer> a) {
        if(a == null) return 0;
        int altezzaSin = altezza(a.sin());
        int altezzaDes = altezza(a.des());
        if (altezzaSin > altezzaDes)
            return 1 + altezzaSin;
        return 1 + altezzaDes;
    }

/*
Complessità temporale peggiore O(n^2)
Complessità temporale migliore O(n)

Complessità spaziale peggiore O(n^2)
Complessità spaziale migliore O(n)
*/

}
