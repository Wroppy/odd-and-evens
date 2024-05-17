package nz.ac.auckland.se281.bots;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.strategies.RandomStrategy;
import nz.ac.auckland.se281.strategies.Strategy;
import nz.ac.auckland.se281.strategies.StrategyProcessor;
import nz.ac.auckland.se281.strategies.TopStrategy;

/**
 * Implements the hard bot. Its strategy involves a combination of the top strategy and random
 * strategy, dependent on the round number or the previous user's action.
 */
public class HardDifficultyBot extends AiPlayer {
  private boolean winLastRound;
  private boolean randomStrategyPlayed;

  public HardDifficultyBot(Choice choice) {
    super(choice);
  }

  @Override
  public int getFinger() {
    Strategy strategy;
    
    if (round <= 3) { // If the round is less than 3, uses the random strategy
      strategy = new RandomStrategy();
    } else { // Switches strategy based on current strategy and round win/loss
      strategy = this.getNextStrategy();
    }

    this.setLastStrategy(strategy);
    StrategyProcessor strategyProcessor = new StrategyProcessor();
    strategyProcessor.setStrategy(strategy);
    return strategyProcessor.executeStrategy(choice, oddPlayed, evenPlayed);
  }

  /**
   * Returns the current strategy based on whether the bot won that round, and the current 
   * strategy that round.
   *
   * @return the strategy for the current round
   */
  private Strategy getNextStrategy() {
    Strategy strategy;
    if (winLastRound) { // Keep strategy the same
      strategy = randomStrategyPlayed ? (new RandomStrategy()) : (new TopStrategy());
    } else { // change strategy
      strategy = randomStrategyPlayed ? (new TopStrategy()) : (new TopStrategy());
    }

    return strategy;
  }

  /** Updates the last strategy played on the last round. */
  private void setLastStrategy(Strategy strategy) {
    this.randomStrategyPlayed = strategy instanceof RandomStrategy;
  }

  /**
   * Increments even played or odd played depending on the finger played and saves the finger 
   * played value.
   *
   * @param userFingerPlayed the value of the finger the user played
   */
  @Override
  public void rememberFingerPlayed(int userFingerPlayed) {
    super.rememberFingerPlayed(userFingerPlayed);
  }

  /**
   * Given the human win, sets whether the bot won the last round.
   *
   * @param humanWin whether the human won last round
   */
  public void setBotWin(boolean humanWin) {
    this.winLastRound = !humanWin;
  }
}
