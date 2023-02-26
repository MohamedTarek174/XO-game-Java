//SoftWare_Assignment_1
//Author_1 : Mohamed Tarek Abdelsattar - 20210343
//Author_2 : Omar Ibrahim Ibrahim - 20210256
//Author_3 : Yousif Ehab Mohamed - 20210466
//this game works with any size  [ (X-O) or (connect-4) ]
import Game.Game;
import Player.Player;


// Main class
public class App {
    public static void main(String[] args)  {
        Player[] players = new Player[2];
        Game game = new Game( players);
        game.play_game();
    }
}

