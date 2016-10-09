public class SnakeGame {

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.food = food;
        this.width = width;
        this.height = height;
        q = new LinkedList<Integer>();
        q.add(0);
        
    }
    int [][] food;
    int width, height;
    int foodIndex = 0;
    LinkedList<Integer> q;  //head
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int res = -1;
        int [][] dir = {
            {-1, 0},
                {0, -1},
                {0, 1},
                {1, 0}
        };
        int dirIndex = 0;
        switch(direction) {
            case "U":
                dirIndex = 0;
                break;
            case "L":
                dirIndex = 1;
                break;
            case "R":
                dirIndex = 2;
                break;
            default:
                dirIndex = 3;
                break;
        }
        int x = dir[dirIndex][0] + q.get(0)/width, y = dir[dirIndex][1] + q.get(0)%width;
        if(x >= 0 && x < height && y >= 0 && y < width && (q.indexOf(x*width + y) == -1 || q.indexOf(x*width + y) == q.size() - 1)) {
             q.add(0, x*width + y);
            if(foodIndex < food.length && food[foodIndex][0] == x && food[foodIndex][1] == y) {
               
                foodIndex++;
            } else {
                q.removeLast();
                
            }
            res = foodIndex;
        }
        return res;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */