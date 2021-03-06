package Esercitazioni_mie;

import alberi.AlberoBin;

public class maggio2020 {
    public static boolean verifica(AlberoBin<Integer> a) {
        if (a == null) return false;
        if (a.sin() != null || a.des() != null) {
            return ((verSin(a.sin(), 0)) == (verDes(a.des(), 0)));
        }
        return false;
    }

    private static int verSin(AlberoBin<Integer> a, int s) {
        if(a == null) return s + 0;
        if(a.sin() == null && a.des() == null) return s + a.getVal();
        return verSin(a.sin(), s);
    }

    private static int verDes(AlberoBin<Integer> a, int d) {
        if(a == null) return d + 0;
        if(a.sin() == null && a.des() == null) return d + a.getVal();
        return verSin(a.des(), d);
    }
}
