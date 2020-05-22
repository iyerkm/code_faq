package graph;

public class NumberOfIslands {
    public static void main(String[] args){

        char[][] grid = new char[][] {{'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}};
        System.out.println(numberOfIslands(grid));
        //expected 3
    }
    public static int numberOfIslands(char[][] grid){
        if(grid==null || grid.length==0) return 0;
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    count++;
                    search(grid,i,j);
                }
            }
        }
        return count;
    }
    public static void search(char[][] grid,int i,int j){
        if(i<0 || j<0 || i>grid.length-1 || j>grid[0].length-1 || grid[i][j]!='1') {
            return;
        }
        grid[i][j]='X';
        search(grid,i-1,j);
        search(grid,i+1,j);
        search(grid,i,j-1);
        search(grid,i,j+1);

    }
}
//    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
// You may assume all four edges of the grid are all surrounded by water.
//
//        Example 1:
//
//        Input:
//        11110
//        11010
//        11000
//        00000
//
//        Output: 1
//        Example 2:
//
//        Input:
//        11000
//        11000
//        00100
//        00011
//
//        Output: 3