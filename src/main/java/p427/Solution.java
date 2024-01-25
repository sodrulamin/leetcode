package p427;

public class Solution {
    // Definition for a QuadTree node.
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;
        
        
        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }
        
        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }
        
        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
    
    public Node construct(int[][] grid) {
        return createNode(grid, 0, 0, grid.length);
    }
    
    /**
     * Create an instance of {@link Node} from given information.
     * @param grid contains the grid information.
     * @param x starting x index of current position.
     * @param y starting y index of current position.
     * @param l length of the grid for the node to be constructed.
     * @return the instance of {@link Node} constructed from given information.
     */
    private Node createNode(int [][] grid, int x, int y, int l) {
        if(l == 1) {
            return new Node(grid[x][y] == 1, true);
        }
        
        boolean allSame = true;
        for(int i = 0; i < l; i++) {
            for(int j = 0; j < l; j++) {
                if(grid[x + i][y + j] != grid[x][y]) {
                    allSame = false;
                    break;
                }
            }
            
            if(!allSame)
                break;
        }
        
        if(allSame)
            return new Node(grid[x][y] == 1, true);
        
        l = l / 2;
        
        return new Node(grid[x][y] == 1, false, createNode(grid, x, y, l), createNode(grid, x, y + l, l),
                createNode(grid, x + l, y, l), createNode(grid, x + l, y + l, l));
    }
    
}
