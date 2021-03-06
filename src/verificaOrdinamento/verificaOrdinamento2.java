package verificaOrdinamento;

import alberi.AlberoBin;

public class verificaOrdinamento2 {
    protected AlberoBin<Integer> albero;

    public verificaOrdinamento2 (AlberoBin<Integer> a) {
        this.albero = a;
    }

    public boolean verificaOrd2 (AlberoBin<Integer> a) {
        if (a == null)
            return true;
        boolean uguali = sottoAlberiIdentici(a.sin(), a.des());
        if (!uguali)
            return false;
        return verificaOrd2(a.sin()) && verificaOrd2(a.des());
    }

    public boolean sottoAlberiIdentici (AlberoBin<Integer> a, AlberoBin<Integer> b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;
        if (a.getVal() != b.getVal()) return false;
        return sottoAlberiIdentici(a.sin(), b.sin()) && sottoAlberiIdentici(a.des(), b.des());
    }
}