public class Nqueens {
    public static void main(String[] args) {
        int n=4;
        boolean[][] board = new boolean[n][n];
        System.out.println(queen(board, 0));
        
    }
    static int queen(boolean[][] board, int row){
        if(row == board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count =0;
        for (int col=0; col<board.length; col++){
            if(isSafe(board,row, col)){
                board[row][col] = true;
                count += queen(board, row+1);
                board[row][col] = false;
            }
        }
        return count;
    }
        private static boolean isSafe(boolean[][] board , int row, int col){
            for(int i=0; i<row; i++){
                if(board[i][col]){
                    return false;
                }
                
            }
            int MaxR = Math.min(row, col);

            for(int i=0; i<=MaxR; i++){
                if(board[row-i][col-i]){
                    return false;
                }
            }
            int MaxL = Math.min(row, board.length-col-1);
                for(int i=0; i<=MaxL; i++){
                if(board[row-i][col+i]){
                    return false;
                }
            }
        
        return true;
        }
        private static void display(boolean[][] board){
            for(boolean[] row : board){
                for(boolean element : row){
                    if(element){
                        System.out.print("Q ");
                    }
                    else{
                        System.out.print("X ");
                    }
                }
                System.out.println();
            }
        }
    
}
