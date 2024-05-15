package nz.ac.auckland.se281.AiBots;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Strategies.RandomStrategy;
import nz.ac.auckland.se281.Strategies.Strategy;
import nz.ac.auckland.se281.Strategies.StrategyProcessor;
import nz.ac.auckland.se281.Strategies.TopStrategy;

/**
 * The bot used for a medium difficulty game. Uses a random strategy for the first 3 rounds then
 * switches to the top strategy afterwards.
 * 
 */
public class MediumDifficultyBot extends AiPlayer {
  public MediumDifficultyBot(Choice choice) {
    super(choice);
  }

  /** Does the random strategy for the first 3 rounds then switches to the top strategy */
  @Override
  public int getFinger() {
    Strategy strategy;

    if (this.round <= 3) { // Executes the random strategy
      strategy = new RandomStrategy();
    } else { // Executes the top strategy
      strategy = new TopStrategy();
    }

    StrategyProcessor processor = new StrategyProcessor(strategy);
    return processor.executeStrategy(choice, oddPlayed, evenPlayed);
  }
}
