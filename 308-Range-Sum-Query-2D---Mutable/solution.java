public class NumMatrix {
/**
	         * Intuitive solution uses row sum can reach O N for update and O M for sum
	         * If Using quad tree, update and sum would be logNlogM
	         */ 
	        QuadTreeNode root = null; 
	        public NumMatrix(int[][] matrix) {
	            if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	                return;
	            }
	            int bottom = 0, left = 0, right = matrix[0].length, top = matrix.length;
	            root = build(top, bottom, left, right);
	            for(int i = 0; i < matrix.length; i++) {
	                for(int j = 0; j < matrix[0].length; j++) {
	                    root.update(matrix[i][j], j, i);
	                }
	            }
	        }

	        public void update(int row, int col, int val) {
	            if(root != null) {
	                root.update(val, col, row);
	            }
	        }

	        public int sumRegion(int row1, int col1, int row2, int col2) {
	            if(root == null) return 0;
	            return root.sum(row2, row1, col1, col2);
	        }
	        
	         QuadTreeNode build(int top, int bottom, int left, int right) {
	                if(top < bottom || left > right) {
	                    return null;
	                }
	                QuadTreeNode r = new QuadTreeNode(top, bottom, left, right);
	                if(top == bottom && left == right) {
	                    return r;
	                } else {
	                    int mid1 = bottom + (top - bottom >> 1), mid2 = left + (right - left >> 1);
	                    r.lt = build(top, mid1 + 1, left, mid2);
	                    r.rt = build(top, mid1 + 1, mid2 + 1, right);
	                    r.lb = build(mid1, bottom, left, mid2);
	                    r.rb = build(mid1, bottom, mid2 + 1, right);
	                }
	                return r;
	            }
	        
	        class QuadTreeNode {
	            int top, bottom, left, right, sum;
	            QuadTreeNode lt, rt, lb, rb;//left top ...
	            
	            public QuadTreeNode(int top, int bottom, int left, int right) {
	                this.top = top;
	                this.bottom = bottom;
	                this.left = left;
	                this.right = right;
	            }
	            
	            
	            
	            public int sum(int top, int bottom, int left, int right) {
	                if(top < bottom || left > right) {
	                    return 0;
	                }
	                if(top >= this.top && bottom <= this.bottom && left <= this.left && right >= this.right) {
	                    return this.sum;
	                } else {
	                    int s1 = 0;
	                    int s2 = 0;
	                    int s3 = 0;
	                    int s4 = 0;
	                    if(lt != null) {
	                        s1 = this.lt.sum(top, bottom, left, right);
	                    }
	                    if(rt != null) {
	                        s2 = this.rt.sum(top, bottom, left, right);
	                    }
	                    if(lb != null) {
	                        s3 = this.lb.sum(top, bottom, left, right);
	                    }
	                    if(rb != null) {
	                        s4 = this.rb.sum(top, bottom, left, right);
	                    }
	                    return s1 + s2 + s3 + s4;
	                }
	            }
	            
	            public void update(int val, int x, int y) {
	                if(x >= left && x <= right && y >= bottom && y <= top) {
    	                if(this.top == this.bottom && this.bottom == y && this.left == this.right && this.left == x) {
    	                    this.sum = val;
    	                } else {//Without this condition, it will overwrite previous result
    	                    this.sum = 0;
    	                    if(lt != null) {
    	                        this.lt.update(val, x, y);
    	                        this.sum += lt.sum;
    	                    }
    	                    if(rt != null) {
    	                        this.rt.update(val, x, y);
    	                        this.sum += rt.sum;
    	                    }
    	                    if(lb != null) {
    	                        this.lb.update(val, x, y);
    	                        this.sum += lb.sum;
    	                    }
    	                    if(rb != null) {
    	                        this.rb.update(val, x, y);
    	                        this.sum += rb.sum;
    	                    }
    	                    
    	                }
	                }
	            }
	        }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.update(1, 1, 10);
// numMatrix.sumRegion(1, 2, 3, 4);