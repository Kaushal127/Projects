package Models;

import botplayingstrategies.BotPlayingStrategy;

public class Bot extends Player {
    private DifficultyLevel difficultyLevel ;
    private BotPlayingStrategy botPlayingStrategy ;

    public Bot(char symbol, String name, int id, PlayerType playerType, DifficultyLevel difficultyLevel, BotPlayingStrategy botPlayingStrategy) {
        super(symbol, name, id, playerType);
        this.difficultyLevel = difficultyLevel;
        this.botPlayingStrategy = botPlayingStrategy;
    }
}
