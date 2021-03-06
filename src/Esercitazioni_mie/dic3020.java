package Esercitazioni_mie;

import java.util.HashSet;

import alberi.AlberoBin;
import java.util.HashSet;

@SuppressWarnings("unused")

/*Si deve realizzare un metodo ricorivo che riceve un albero binario di interi a e tre interi x, y e k e che ritorna true se e solo se x ed y appaiono
nell'albero a ed x appare come antenato di y a distanza (in termini di numero di livelli tra x ed y in a) almeno pari a k.*/

public class dic3020 {
    public static boolean verificaAntenato(AlberoBin<Integer> a, int x, int y, int k) {
        if(a == null) return false;
        HashSet<Integer> s = new HashSet<Integer>();
        return verifica(a, x, y, k, s, 0, 0);
    }

    public static boolean verifica(AlberoBin<Integer> a, int x, int y, int k, HashSet<Integer> s, int liv, int h) {
        if(a == null) return false;
        if(((liv - h) <= k) && !(s.add(a.getVal()))) return true;
        return (verifica(a.des(), x, y, k, s, liv + 1, h) || verifica(a.sin(), x, y, k, s, liv + 1, h) || verifica(a.des(), x, y, k, s, liv, h + 1) || 
                verifica(a.sin(), x, y, k, s, liv, h + 1));
    }
}
