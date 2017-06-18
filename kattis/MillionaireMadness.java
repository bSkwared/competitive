// Problem statement: https://open.kattis.com/problems/millionairemadness

import java.util.Arrays;
import java.util.Scanner;

public class MillionaireMadness {
    
    static boolean mark[][];
    static int middle;
    static int grid[][];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int r = scan.nextInt();
        int c = scan.nextInt();
        grid = new int[r][c];
        mark = new boolean[r][c];
        
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                grid[i][j] = scan.nextInt();
            }
        }
        
        // Binary search on min ladder height O(32n)
        int low = 0;
        int high = 1000000000;
        
        while (high > low) {
            middle = (low + high) / 2;
            
            // reset mark array for dfs
            for (int i = 0; i < r; ++i) {
                Arrays.fill(mark[i], false);
            }
            
            // perform dfs
            boolean isPath = dfs(0, 0);
            
            if (isPath) {
                high = middle;
            } else {
                low = middle+1;
            }
        }
        System.out.println(low);
    }
    

    static boolean dfs(int x, int y) {
        // we are at the destination
        if (x == grid.length - 1 && y == grid[0].length -1) {
            return true;
        }
        // check if already visited
        if (mark[x][y]) return false;
        mark[x][y] = true;
        
        
        boolean isPath = false;
        
        if (x > 0 && grid[x-1][y] - grid[x][y] <= middle) {
            isPath = isPath || dfs(x-1, y);
        }
        
        if (x < grid.length-1 && grid[x+1][y] - grid[x][y] <= middle) {
            isPath = isPath || dfs(x+1, y);
        }
        
        if (y > 0 && grid[x][y-1] - grid[x][y] <= middle) {
            isPath = isPath || dfs(x, y-1);
        }
        
        if (y < grid[0].length-1 && grid[x][y+1] - grid[x][y] <= middle) {
            isPath = isPath || dfs(x, y+1);
        }
        
        return isPath;
    }
 
}
