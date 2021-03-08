package Esercitazioni_mie;

import alberi.AlberoBin;

//Si realizzi un metodo ricorsivo che restituisce il numero di valori pari memorizzati nei nodi dell’albero a a livello k

public class giu10 {
    public static int contaLivello(AlberoBin<Integer> a, int k) {
        if(a == null) return 0;
        if((a.getVal() % 2) == 0)
            return 1;
        if(k < 0)
            return((contaLivello(a.sin(), k + 1)) + (contaLivello(a.des(), k + 1)));
        return ((contaLivello(a.sin(), k)) + (contaLivello(a.des(), k)));
    }

    public static int funz(AlberoBin<Integer> a, int k) {
        if(a == null) return 0;
        if(k > 0)
            return((conta(a.sin(), k, 0)) + (conta(a.des(), k, 0)));
        return 0;
    }

    public static int conta(AlberoBin<Integer> a, int k, int liv) {
        if (a == null) return 0;
        if (k == liv)
            if(a.getVal() % 2 == 0)
                return 1;
        return((conta(a.sin(), k, liv + 1)) + (conta(a.des(), k, liv + 1)));
    }
}
