package nz.ac.auckland.se281.Strategies;

import nz.ac.auckland.se281.Main.Choice;

public class StrategyProcessor {
  private Strategy strategy;

  public StrategyProcessor(Strategy strategy) {
    this.strategy = strategy;
  }

  public int executeStrategy(Choice userChoice, int oddPlayed, int evenPlayed) {
    return this.strategy.getFingerChoice(userChoice, oddPlayed, evenPlayed);
  }
}
