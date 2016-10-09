public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int res = 0;
        if(n > 0 && primes != null && primes.length > 0) {
            PriorityQueue<PrimeProduct> q = new PriorityQueue<PrimeProduct>(10, new Comparator<PrimeProduct>() {
               public int compare(PrimeProduct a, PrimeProduct b) {
                   return a.product - b.product;
               } 
            });
            for(int p : primes) {
                q.offer(new PrimeProduct(p));
            }
            while(n > 0) {
                res = q.peek().product;
                while(q.peek().product == res) {
                    PrimeProduct cur = q.poll();
                    cur.product = res*cur.prime;
                    q.offer(cur);
                }
                n--;
            }
        }
        return res;
    }
    
    class PrimeProduct {
        int prime;
        int product;
        public PrimeProduct(int p) {
            this.prime = p;
        }
    }
}