/**
 * 
 */
package n2;

/**
 * @author HPProBook4520s Java aiutami, che io ti aiuto!!
 */
// Sia assegnato un vettore A di interi di dimensione N. Scrivere una funzione
// ricorsiva che calcoli il massimo valore degli elementi di A.
class CalcolaMassimoR
{

	/**
	 * @param args
	 */
	static int massimo(int vettore[], int i)
	{
		if (i + 1 == vettore.length)
			return vettore[i];
		int max = massimo(vettore, i + 1);
		if (max < vettore[i])
			max = vettore[i];
		return max;
	}// massimo

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		int vettore[] = { 1, 20, 300, 4, 6, 10, 2, 20, 1, 3, 1 };
		System.out.println(massimo(vettore, 0));
	}

}
