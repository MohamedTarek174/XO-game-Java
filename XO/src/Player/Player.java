package Player;

public class Player {
    String name ;
    char symbol ;
    public Player (String name, char symbol){
        this.name = name;
        this.symbol = symbol;
    }
    
    public char get_symbol() {return symbol;}
    public String get_name(){return "player " + name;}

    
};