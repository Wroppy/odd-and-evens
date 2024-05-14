package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int round = 1;
  private String playerName;

  /**
   * Given the difficulty, odd or even, and the players name, resets and starts a new game.
   *
   * @param difficulty Enum that represents the difficulty levels (EASY, MEDIUM, HARD).
   * @param choice Enum that represents the player choice (Odd or Even).
   * @param options String array containing the player name.
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // Welcomes the player to the game
    String playerName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
    this.playerName = playerName;
    this.round = 1;
  }

  /**
   * Implements the play logic of the game. Prints out the current round and asks the user for their
   * numeric input.
   */
  public void play() {
    MessageCli.START_ROUND.printMessage(String.valueOf(this.round));

    int finger = this.getFinger();
    MessageCli.PRINT_INFO_HAND.printMessage(this.playerName, String.valueOf(finger));

    this.incrementRound();
  }

  /**
   * When called, asks the user for a number that is between 0 and 5 (inclusive) Ensures that the
   * input is valid and keeps asking until the condition is satisfied.
   *
   * @return the user's inputted number from 0 and 5
   */
  public int getFinger() {
    MessageCli.ASK_INPUT.printMessage();
    String finger = Utils.scanner.nextLine();
    while (!Utils.isInteger(finger)
        || !(Integer.parseInt(finger) >= 0 && Integer.parseInt(finger) <= 5)) {

      // Asks prompt again if the message is invalid
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();
      finger = Utils.scanner.nextLine();
    }

    return Integer.parseInt(finger);
  }

  /** When called, adds 1 to the round class variable */
  private void incrementRound() {
    this.round++;
  }

  public void endGame() {}

  public void showStats() {}
}
