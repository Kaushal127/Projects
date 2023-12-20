package Models;

public class Player {
    private char Symbol ;
    private String name ;
    private int id ;
    private PlayerType playerType ;

    public Player(char symbol, String name, int id, PlayerType playerType) {
        this.Symbol = symbol;
        this.name = name;
        this.id = id;
        this.playerType = playerType;
    }

    public char getSymbol() {
        return Symbol;
    }

    public void setSymbol(char symbol) {
        Symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
}
