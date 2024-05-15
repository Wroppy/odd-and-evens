package nz.ac.auckland.se281.AIBots;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Strategies.RandomStrategy;
import nz.ac.auckland.se281.Strategies.StrategyProcessor;

public class EasyBot extends AIBot {
  public EasyBot(Choice choice) {
    super(choice);
  }


  @Override
  public int getFinger() {
    RandomStrategy randomStrategy = new RandomStrategy();
    StrategyProcessor processor = new StrategyProcessor(randomStrategy);
    return processor.executeStrategy(this.choice, this.oddPlayed, this.evenPlayed);
  }
}
