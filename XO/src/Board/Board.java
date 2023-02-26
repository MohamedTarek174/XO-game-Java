package Board;
import java.util.Scanner;

public class Board {
    int  n;
    int n_moves = 0;
    private char[][] board ;
    public Board (int n){
        board = new char[n][n];
        this.n = n;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                board[i][j] = '0';
            }
        }
    }

    public void update_board (int x, int y, char mark){
        Scanner sc= new Scanner(System.in);
        //check if the move is valid or not
        if (!(x < 0 || x > n-1 || y < 0 || y > n-1) && (board[x][y] == '0')) {
            board[x][y] = Character.toUpperCase(board[x][y]);
            board[x][y] = mark;
            n_moves++;
        }
        else{
            System.out.println("invalid move");
            System.out.println("Enter new move");
            x = sc.nextInt();
            y = sc.nextInt();
            update_board(x, y, mark);
        }
        
    }
    public boolean is_winner() {
        //for rows
        for(int i = 0;i < n;i++){
            int counter_rows = 0;
            for(int j = 0;j < n-1;j++)
                if(board[i][j] == board[i][j+1]&& (board[i][j] != '0'))
                    counter_rows++;

            if(counter_rows == n-1)
                return true;


        }
        //for colm
        int counter_colm = 0;
        for(int i = 0;i < n;i++){
            counter_colm = 0;
            for(int j = 0;j < n-1;j++)
                if(board[j][i] == board[j+1][i] && (board[j][i] != '0'))
                    counter_colm++;
            if(counter_colm == n-1)
                return true;

        }


        //diag right
        int counter_diaR = 0;
        for(int i = 0;i < n-1;i++)
            if(board[i][i] == board[i+1][i+1]&& (board[i][i] != '0'))
                counter_diaR++;

        if(counter_diaR == n-1)
            return true;

        //diag left
        int counter_diaL = 0;
        for(int i = 0;i < n-1;i++)
            if(board[i][n-i-1] == board[i+1][n-i-2]&& (board[i][n-i-1] != '0'))
                counter_diaL++;

        if(counter_diaL == n-1)
            return true;

        return false;
    }


    public boolean is_draw() {
        return (n_moves == n*n && !is_winner());
    }


    // Display the board and the pieces on it
    public void boardPrint(){
         for(int i = 0;i < n;i++){
             System.out.print("\n| ");
             for(int j = 0;j < n;j++){
                 System.out.print("(" + i + "," + j + ")");
                 if (board[i][j] != '0'){
                     System.out.print("  " + board[i][j] + " |");
                 }else
                     System.out.print("   " + " |");

             }

             System.out.print("\n -----------------------");
         }
         System.out.println();
    }
    
};
