package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  /**
   * Given the difficulty, odd or even, and the players name, resets and starts a new game
   * 
   * @param difficulty Enum that represents the difficulty levels (EASY, MEDIUM, HARD).
   * @param choice Enum that represents the player choice (Odd or Even).
   * @param options String array containing the player name.
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // Welcomes the player to the game
    String playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);

  }

  public void play() {}

  public void endGame() {}

  public void showStats() {}
}
