package winningstrategies;

import Models.Board;
import Models.Move;

public class ColWinningStrategy implements WinningStartegy{
    @Override
    public boolean checkWinner(Board board, Move move) {
        return false;
    }
}
