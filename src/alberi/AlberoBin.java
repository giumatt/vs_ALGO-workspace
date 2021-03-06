package alberi;

import java.util.*;

public interface AlberoBin<T> extends Albero<T> {
	
        public AlberoBin<T> padreBin();

        public T getVal();
        
        public AlberoBin<T> sin();
        
        public AlberoBin<T> des();
        
        public List<T> visitaInfissa();
        
        public Iterator<T> iteratorVI();
}