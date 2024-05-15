package nz.ac.auckland.se281.strategies;

import nz.ac.auckland.se281.Main.Choice;

/**
 * An interface for the types of strategies for the game.
 * All have a common method that gets the finger using that strategy.
 */
public interface Strategy {
  int getFingerChoice(Choice userChoice, int oddPlayed, int evenPlayed);
}
