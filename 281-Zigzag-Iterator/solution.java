public class ZigzagIterator {

    int turn = 0;
    List<Iterator<Integer>> itrs = new ArrayList<Iterator<Integer>>();
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if(v1.iterator().hasNext()) {
            itrs.add(v1.iterator());
        }
        if(v2.iterator().hasNext()) {
            itrs.add(v2.iterator());
        }
    }

    public int next() {
        int i = turn%itrs.size();
        turn++;
        int res = itrs.get(i).next();
        if(!itrs.get(i).hasNext()) {
            itrs.remove(i);
            turn--;
        }
        return res;
    }

    public boolean hasNext() {
        return itrs.size() > 0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */