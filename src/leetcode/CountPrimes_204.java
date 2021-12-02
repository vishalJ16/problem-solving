/**
 * 
 */
package leetcode;

/**
 * @author v0j008y
 * 21 Sept 2021
 * 23:23:05
 */
public class CountPrimes_204 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 1500000;
		int ans = countPrimes(n);
		System.out.println(ans);
	}

    static int countPrimes(int n) {
        if(n<=2) {
            return 0;
        }
        int[] isPrime = new int[n]; // 1 means not prime
        int count = 1;
        for(int i=3; i<n; i=i+2) {
            if(isPrime[i]==0 && isPrime(i)) {
                count++;
                isPrime[i] = 1;
            }
            mark(isPrime, i, n-1);
        }
        return count;
    }
    
    static boolean isPrime(int x) {
        for(int i=2; i<=x/i; i++) {
            if(x%i == 0) {
                return false;
            }
        }
        return true;
    }
    
    static void mark(int[] isPrime, int x, int n) {
        for(int i=x; i<=n/x; i++) {
            isPrime[i*x] = 1;
        }
    }
}
