package Esercitazioni_mie;

import alberi.AlberoBin;

/*Si deve realizzare un metodo che calcola il numero di nodi contenenti valori maggiori di zero che si trovano
in un livello più profondo o uguale a l in a.*/

public class lug2020 {
    public static int countDeeperThan(AlberoBin<Integer> a, int l) {
        if(a == null) return 0;
        return conta(a, l, 0);
    }

    public static int conta(AlberoBin<Integer> a, int l, int k) {
        if(a == null) return 0;
        if(k >= l)
            return (conta(a.des(), l, k+1) + conta(a.sin(), l, k+1));
        if(a.getVal() > 0) return 1;
        return 0;
    }
}
