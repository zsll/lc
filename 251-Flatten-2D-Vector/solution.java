public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> row = null;
    Iterator<Integer> col = null;
    public Vector2D(List<List<Integer>> vec2d) {
        if(vec2d != null) {
            row = vec2d.iterator();
            if(row.hasNext()) {
                col = row.next().iterator();
            }
        }
    }

    @Override
    public Integer next() {
        return col.next();
    }

    @Override
    public boolean hasNext() {
        if(col == null) {
            return false;
        } else {
            while(row.hasNext() && !col.hasNext()) {
                col = row.next().iterator();
            }
        }
        return col.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */