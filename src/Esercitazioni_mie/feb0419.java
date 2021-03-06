package Esercitazioni_mie;

import java.util.HashSet;

import alberi.AlberoBin;

public class feb0419 {
    
    public static boolean valore(AlberoBin<Integer> a, int l) {
        if(a == null) return false;
        HashSet<Integer> s = new HashSet<Integer>();
        return ver2(a, l, 0, s);
    }

    public static boolean ver2(AlberoBin<Integer> a, int l, int somma, HashSet<Integer> s) {
        if(a == null) return false;
        if(l == 0) return (!s.add(a.getVal() + somma));
        else return (ver2(a.des(), l - 1, somma + a.getVal(), s) || ver2(a.sin(), l - 1, somma + a.getVal(), s));
    }
}
