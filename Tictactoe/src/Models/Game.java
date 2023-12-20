package Models;

import Exceptions.DuplicateSymbolException;
import Exceptions.MorethanOneBotException;
import Exceptions.PlayersCountMismatchException;
import winningstrategies.WinningStartegy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {
    private List<Player> players ;
    private Board board ;
    private List<Move> moves ;
    private GameState gameState;
    private int nextPlayerIndex;
    private  Player winner ;
    private List<WinningStartegy> winningStartegy ;

    public Game(int dimension ,List<Player> players, List<WinningStartegy> winningStartegy) {
        this.board = new Board(dimension) ;
        this.players = players;
        this.winningStartegy = winningStartegy;

    }
    public static Builder getBuilder(){
        return new Builder() ;
    }

    public static class Builder {
        private List<Player> players ;
        private List<WinningStartegy> winningStartegies ;
        private  int dimension ;


        private Builder() {
             this.players = new ArrayList<>() ;
             this.winningStartegies = new ArrayList<>() ;
             this.dimension = 0 ;
         }

         public Game build() throws MorethanOneBotException, DuplicateSymbolException, PlayersCountMismatchException {
             validateBotCount() ;
             validateUniqueSymbolForPlayers() ;
             validateDimensionsAndPlayerCount() ;

             return  new Game(dimension , players , winningStartegies) ;
         }

        private void validateDimensionsAndPlayerCount() throws PlayersCountMismatchException {
            if(players.size()!=(dimension-1)){
                throw new PlayersCountMismatchException();
            }
        }

        private void validateUniqueSymbolForPlayers() throws DuplicateSymbolException {
            Set<Character> symbols = new HashSet<>() ;
              for (Player player : players){
                  if (symbols.contains(player.getSymbol())){
                      throw new DuplicateSymbolException();
                  }
              }

        }

        private void validateBotCount() throws MorethanOneBotException {
              int botCount = 0 ;
               for (Player player : players){
                   if (player.getPlayerType().equals(PlayerType.BOT)){
                       botCount++;
                   }
               }
               if (botCount>1){
                   throw new MorethanOneBotException() ;
               }
         }
        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStartegies(List<WinningStartegy> winningStartegies) {
            this.winningStartegies = winningStartegies;
            return  this ;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this ;
        }

    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public int getNextPlayerIndex() {
        return nextPlayerIndex;
    }

    public void setNextPlayerIndex(int nextPlayerIndex) {
        this.nextPlayerIndex = nextPlayerIndex;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }
}
