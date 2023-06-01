//Author : Mohamed Tarek Abdelsattar - 20210343
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

