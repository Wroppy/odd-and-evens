package nz.ac.auckland.se281.AiBots;

import nz.ac.auckland.se281.Main.Choice;

/**
 * Implements the hard bot. Its strategy involves a combination of the top strategy and random
 * strategy, dependent on the round number or the previous user's action.
 */
public class HardDifficultyBot extends AiPlayer {
  public HardDifficultyBot(Choice choice) {
    super(choice);
  }

  @Override
  public int getFinger() {
    return 1;
  }
}
