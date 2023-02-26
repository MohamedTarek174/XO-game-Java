package Game;
import Board.Board;
import Player.Player;
import java.util.Scanner;

public class Game {
    private Player[] players = new Player[2];
    private int turn = 0;

    // Constructor initializes the game with a board and players
    public Game( Player[] players){
        for(int i = 0;i < 2;i++){
            this.players[i] = players[i];
        }
    }

    // It runs the game and switches turns, until one wins or draw
    public void play_game() {
        int x, y, n;
        //Enter Board size
        Scanner num = new Scanner(System.in);
        System.out.print("Enter Size of Grid: ");
        while(true){
            try {
                n = num.nextInt();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.println("pls Enter integers , try again");
                num.nextLine();
            }
        }

        Board board = new Board(n);
        //Player 1 ------------------------
        Scanner sca= new Scanner(System.in);
        System.out.print("Enter player 1 name : ");
        String name1 = sca.nextLine();
        System.out.print("Enter player 1 symbol : ");
        char symbol1 = sca.next().charAt(0);
        players[0] = new Player(name1,symbol1);
        //Player 2 -----------------------
        Scanner sca2 = new Scanner(System.in);
        System.out.print("Enter player 2 name : ");
        String name2 = sca2.nextLine();
        System.out.print("Enter player 2 symbol : ");
        char symbol2 = sca2.next().charAt(0);
        while(symbol2 == symbol1){
            System.out.println("sorry,this symbol is already token");
            System.out.print("Enter player 2 symbol : ");
            symbol2 = sca2.next().charAt(0);
        }
        players[1] = new Player(name2,symbol2);

        // print the board
        board.boardPrint();
        while (true) {
            //player1
            Scanner sc= new Scanner(System.in);
            System.out.println(players[turn].get_name() +" ("+players[turn].get_symbol()+") enter your move");
            //make sure if the inputs are valid
            while(true){
                try {
                    x=sc.nextInt();
                    y=sc.nextInt();
                    break;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("pls Enter integers , try again");
                    sc.nextLine();
                }
            }
            board.update_board(x, y, players[turn].get_symbol());
            board.boardPrint();
            if (board.is_winner()){
                System.out.println(players[turn].get_name() + " wins");
                return;
            }
            if (board.is_draw()){
                System.out.println("DRAW !!");
                return;
            }
            turn = 1;
            //player2
            System.out.println(players[turn].get_name() +" ("+players[turn].get_symbol()+") enter your move");
            //make sure if the inputs are valid
            while(true){
                try {
                    x=sc.nextInt();
                    y=sc.nextInt();
                    break;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("pls Enter integers , try again");
                    sc.nextLine();
                }
            }
            board.update_board(x, y, players[turn].get_symbol());
            board.boardPrint();
            if (board.is_winner()){
                System.out.println(players[turn].get_name() + " wins ");
                return;
            }
            if (board.is_draw()){
                System.out.println("DRAW !!");
                return;
            }
            turn = 0;

        }
    }
}

