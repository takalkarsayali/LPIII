import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {

//    Saving all individual boards in allBoards List
    private static void saveBoard(char[][] board, List<List<String>> allBoards) {
        String row = "";

        List<String> newBoard = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            row = "";
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'Q'){
                    row += 'Q';
                }else {
                    row += '.';
                }
            }
            newBoard.add(row);
        }
        allBoards.add(newBoard);
    }

    private static boolean isSafe(int row, int col, char[][] board) {
        // Horizontal check
        for(int j = 0; j < board.length; j++){
            if(board[row][j] == 'Q'){
                return false;
            }
        }

        // Vertical check
        for(int i = 0; i < board.length; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //upper left
        int r = row;
        for(int c = col; c >= 0 && r >= 0; c--, r--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        // upper right
        r = row;
        for(int c = col; c < board.length && r >= 0; c++, r--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        // lower left
        r = row;
        for(int c = col; c >= 0 && r < board.length; r++, c--){
            if(board[r][c] == 'Q'){
                return false;
            }
        }

        //lower right
        r = row;
        for(int c = col; c < board.length && r < board.length; c++, r++){
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        return true;
    }

    public static void helperFunction(char[][] board, List<List<String>> allBoards, int col){

        if(col == board.length){
            saveBoard(board, allBoards);
            return;
        }

        for(int row = 0; row < board.length; row++){
            if(isSafe(row, col, board)){
                board[row][col] = 'Q';
                helperFunction(board, allBoards, col+1);
                board[row][col] = '.';
            }
        }
    }

    public static List<List<String>> solveNQueens (int n){
        List<List<String>> allBoards = new ArrayList<>();
        char[][] board = new char[n][n];

        helperFunction(board,allBoards,0);
        return allBoards;
    }

    public static void main(String[] args) {
        int n = 8;
        System.out.println(solveNQueens(n));
        
    }
}