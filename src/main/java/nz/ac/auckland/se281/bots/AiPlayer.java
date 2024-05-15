package nz.ac.auckland.se281.bots;

import nz.ac.auckland.se281.GamePlayer;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Utils;

/**
 * An abstract class that holds the common logic between different difficulty bots. 
 */
public abstract class AiPlayer extends GamePlayer {
  protected int evenPlayed;
  protected int oddPlayed;
  protected int round;
  protected Choice choice;

  /**
   * Sets up default variables that the bot can use throughout the game for strategies.
   *
   * @param choice the user's choice to go odd or even that game
   */
  public AiPlayer(Choice choice) {
    super("HAL-9000");
    this.evenPlayed = 0;
    this.oddPlayed = 0;
    this.round = 1;
    this.choice = choice;
  }

  public void incrementRound() {
    this.round++;
  }

  /**
   * Increments evenPlayed, or oddPlayed depending on the finger the user played.
   *
   * @param userFingerPlayed the value of the finger the user played
   */
  public void rememberFingerPlayed(int userFingerPlayed) {
    if (Utils.isEven(userFingerPlayed)) {
      this.evenPlayed++;
    } else {
      this.oddPlayed++;
    }
  }
}
