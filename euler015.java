

/**
 * @author Kevin
 */
public class euler015 extends Euler{

    public static final int[] DIM = {20,20};
    
    public static void main(String[] args) {
        Start();
        
        long[][] grid = new long[DIM[1]][DIM[0]];
       
        for(int i = 0; i < DIM[0]; i++){
            for(int j = 0; j < DIM[1]; j++){
                if(i == 0 && j == 0)
                   grid[i][j] = 2;
                else if(i == 0 && j > 0)
                   grid[i][j] = grid[i][j-1] + 1;
                else if(j == 0 && i > 0)
                   grid[i][j] = grid[i-1][j] + 1;
                else if(j > 0 && i > 0)
                   grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }
         
        System.out.println(grid[DIM[1]-1][DIM[0]-1]);
    }

}