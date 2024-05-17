package nz.ac.auckland.se281.strategies;

import nz.ac.auckland.se281.Main.Choice;

/**
 * Executes the given strategy
 */
public class StrategyProcessor {
  private Strategy strategy;

  public StrategyProcessor(Strategy strategy) {
    this.strategy = strategy;
  }

  /**
   * Gets the finger that the bot wants to play given the previous rounds played.
   *
   * @param userChoice the user choice of odd or even at the start of the game
   * @param oddPlayed the amount of times the player has played an odd number
   * @param evenPlayed the amount of times the player has played an even number
   * @return the finger that is returns from the strategy set
   */
  public int executeStrategy(Choice userChoice, int oddPlayed, int evenPlayed) {
    return this.strategy.getFingerChoice(userChoice, oddPlayed, evenPlayed);
  }
}
