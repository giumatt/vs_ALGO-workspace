package verificaOrdinamento;

import alberi.AlberoBin;

public class verificaOrdinamento {
    protected AlberoBin<Integer> albero;

    public verificaOrdinamento(AlberoBin<Integer> x) {
        this.albero = x;
    }

    public boolean verificaOrd (AlberoBin<Integer> a) {
        if (a == null) return true;
        return ((a.sin() == null) || (a.des() == null)) ? false: verificaOrd(a.sin(), a.des());
    }

    public boolean verificaOrd (AlberoBin<Integer> a, AlberoBin<Integer> b) {
        if (((a != null) && (b == null)) || ((a == null) && (b != null)) || !(contiene(a.getVal(), b)))
            return false;
        return verificaOrd(a.sin(), b) && verificaOrd(a.des(), b) && verificaOrd(a.sin(), a.des())
                && verificaOrd(b.sin(), b.des());
    }

    public boolean contiene (int n, AlberoBin<Integer> a) {
        if (a == null)
            return false;
        return (n == a.getVal()) ? true: contiene(n, a.sin()) || contiene (n, a.des());
    }
}