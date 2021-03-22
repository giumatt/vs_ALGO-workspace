package Esercitazioni_mie;

import alberi.AlberoBin;

//Restituisce true se e solo se esiste un nodo non foglia n di a tale che tutti i nodi foglia che appaiono nel sottoalbero radicato in n hanno lo stesso valore.

public class lug0218 {
   public static boolean foglie(AlberoBin<Integer> a) {
       if(a == null) return false;
       if(a.sin() != null || a.des() != null)
            return verifica(a.sin(), a.getVal()) || verifica(a.des(), a.getVal());
       return foglie(a.sin()) || foglie(a.des()); 
   }

   public static boolean verifica(AlberoBin<Integer> a, int val) {
       if(a == null) return false;
       if(a.sin() == null && a.des() == null) return a.getVal() == val;
       return verifica(a.sin(), val) && verifica(a.des(), val);
   }

   /*
   Complessità temporale migliore Theta(log(n))
   Complessità temporale peggiore Thena(n^2)

   Complessità spaziale migliore Theta(log(n))
   Complessità spaziale peggiore Theta(n + n)
   */
}
