public class Solution {
        public boolean isRectangleCover(int[][] rectangles) {
            /**
             * Firstly get max and min edges, also get all rectangle area
             * If the sum matches the large rectangle, we need to check if any of the two rectangles overlap
             * Using scan line and interval tree
             */ 
             boolean res = false;
             if(rectangles != null) {
                 if(rectangles.length == 1) {
                     res = true;
                 } else {
                     int [] largePoint = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};//left, bottom,right,top in a x-y plane
                     int sumArea = 0;
                     for(int [] r : rectangles) {
                         updateLargePoint(r, largePoint);
                         sumArea += area(r);
                     }
                     if(area(largePoint) == sumArea) {
                         res = true;
                         List<Segment> lines = getLines(rectangles);
                         SegmentTree st = new SegmentTree(largePoint[3], largePoint[1]);
                         for(Segment line : lines) {
                             if(line.isLeft) {
                                 if(st.insert(line.top, line.bottom)) {
                                     res = false;
                                     break;
                                 }
                             } else {
                                 st.remove(line.top, line.bottom);
                             }
                         }
                     }
                 }
             }
             return res;
        }
        
        void updateLargePoint(int [] r, int [] largePoint) {
            largePoint[0] = Math.min(largePoint[0], r[0]);
            largePoint[1] = Math.min(largePoint[1], r[1]);
            largePoint[2] = Math.max(largePoint[2], r[2]);
            largePoint[3] = Math.max(largePoint[3], r[3]);
        }
        
        int area(int [] r) {
            return (r[2] - r[0]) * (r[3] - r[1]);
        }
        
        List<Segment> getLines(int[][] rectangles) { //generate segments to swipe through
            List<Segment> res = new ArrayList<Segment>();
            for(int [] r : rectangles) {
                res.add(new Segment(r[0], r[3] - 1, r[1], true));//r[3] - 1 Because for a line 1 to 3, it actually occupies 1-2, 2-3, two grids
                res.add(new Segment(r[2], r[3] - 1, r[1], false));
            }
            Collections.sort(res, new Comparator<Segment>() {
                @Override
                public int compare(Segment a, Segment b) {
                    if(a.x != b.x) {
                        return a.x - b.x;
                    } else {
                        if(!a.isLeft && b.isLeft) {
                            return -1;
                        } else if(!b.isLeft && a.isLeft) {
                            return 1;
                        }
                    }
                    return 0;
                }
            });
            return res;
        }
        
        class Segment {
            int x, top, bottom;
            boolean isLeft;
            public Segment(int x, int top, int bottom, boolean isLeft) {
                this.x = x;
                this.top = top;
                this.bottom = bottom;
                this.isLeft = isLeft;
            }
        }
        
        class SegmentTreeNode {
            int val, top, bottom;   //In this problem, val = 1 means occupied
            SegmentTreeNode left;
            SegmentTreeNode right;
            public SegmentTreeNode(int val, int top, int bottom) {
                this.val = val;
                this.top = top;
                this.bottom = bottom;
            }
            
            public SegmentTreeNode(int top, int bottom) {
                this.top = top;
                this.bottom = bottom;
            }
            
            boolean insert(int top, int bottom) {//return if overlapped
                boolean overlapped = false;
                if(this.top > this.bottom) {
                    overlapped = this.left.insert(top, bottom) || this.right.insert(top, bottom);   //NoteNote
                } else if(top >= this.top && bottom <= this.top) {
                    if(this.val == 1) {
                        overlapped = true;
                    } else {
                        this.val = 1;   //overlapped is still 1
                    }
                } 
                return overlapped;
            }
            
            void remove(int top, int bottom) {
                if(this.top > this.bottom) {
                    this.left.remove(top, bottom);
                    this.right.remove(top, bottom);
                } else if(top >= this.top && bottom <= this.top) {
                    this.val = 0;
                }
            }
        }
        
        class SegmentTree {
            SegmentTreeNode root = null;
            
            public SegmentTree(int top, int bottom) {
                root = build(top, bottom);
            }
            
            SegmentTreeNode build(int top, int bottom) {
                SegmentTreeNode res = null;
                if(top >= bottom) {
                    res = new SegmentTreeNode(top, bottom);
                    if(top > bottom) {
                        int mid = bottom + (top - bottom >> 1);
                        res.left = build(top, mid + 1);
                        res.right = build(mid, bottom);
                    }
                }
                return res;
            }
            
            boolean insert(int top, int bottom) {//return true if overlaps with existing
                return root.insert(top, bottom);
            }
            
            void remove(int top, int bottom) {
                root.remove(top, bottom);
            }
        }
    
}