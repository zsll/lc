public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        List<Integer> res = new ArrayList<Integer>();
        if(n > 0 && primes != null && primes.length > 0) {
            PriorityQueue<PrimeProduct> q = new PriorityQueue<PrimeProduct>(10, new Comparator<PrimeProduct>() {
               public int compare(PrimeProduct a, PrimeProduct b) {
                   return a.product - b.product;
               } 
            });
            for(int p : primes) {
                q.offer(new PrimeProduct(p));
            }
            res.add(1);
            n--;
            while(n > 0) {
                res.add(q.peek().product);  //smallest get(pos)*prime
                while(q.peek().product == res.get(res.size() - 1)) {
                    PrimeProduct cur = q.poll();
                    cur.pos++;
                    cur.product = res.get(cur.pos)*cur.prime;
                    q.offer(cur);
                }
                n--;
            }
        }
        return res.get(res.size() - 1);
    }
    
    class PrimeProduct {
        int prime;
        int product;
        int pos;    //pos in res list
        public PrimeProduct(int p) {
            this.prime = p;
            this.product = p;//NoteNote: initialize (This is product of list.get(pos)*prime
            pos = 0;
        }
    }
}