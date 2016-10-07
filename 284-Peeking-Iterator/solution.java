// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    Integer c = null;
    Iterator<Integer> i;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    i = iterator;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(c == null) {
            c = i.next();
        }
        return c;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    Integer res = c;
	    if(res == null) {
	        res = i.next();
	    } else {
	        c = null;
	    }
	    return res;
	}

	@Override
	public boolean hasNext() {
	    return c != null || i.hasNext();
	}
}