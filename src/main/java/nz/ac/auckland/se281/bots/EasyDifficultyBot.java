package nz.ac.auckland.se281.bots;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.strategies.RandomStrategy;
import nz.ac.auckland.se281.strategies.StrategyProcessor;

/**
 * The bot called for an easy difficulty game.
 * Only uses the random strategy.
 */
public class EasyDifficultyBot extends AiPlayer {
  public EasyDifficultyBot(Choice choice) {
    super(choice);
  }

  @Override
  public int getFinger() {
    RandomStrategy randomStrategy = new RandomStrategy();
    StrategyProcessor processor = new StrategyProcessor();
    processor.setStrategy(randomStrategy);
    return processor.executeStrategy(this.choice, this.oddPlayed, this.evenPlayed);
  }
}
