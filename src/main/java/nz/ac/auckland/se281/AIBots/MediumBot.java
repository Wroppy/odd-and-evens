package nz.ac.auckland.se281.AIBots;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Strategies.RandomStrategy;
import nz.ac.auckland.se281.Strategies.Strategy;
import nz.ac.auckland.se281.Strategies.StrategyProcessor;
import nz.ac.auckland.se281.Strategies.TopStrategy;

public class MediumBot extends AIBot {
  public MediumBot(Choice choice) {
    super(choice);
  }

  @Override
  public int getFinger() {
    Strategy strategy;
    if (this.round <= 3) {
      strategy = new RandomStrategy();
    } else {
      strategy = new TopStrategy();
    }

    StrategyProcessor processor = new StrategyProcessor(strategy);
    return processor.executeStrategy(choice, oddPlayed, evenPlayed);
  }
}
