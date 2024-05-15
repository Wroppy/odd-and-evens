package nz.ac.auckland.se281.AIBots;

import nz.ac.auckland.se281.GamePlayer;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Utils;

public abstract class AIBot extends GamePlayer {
  protected int evenPlayed;
  protected int oddPlayed;
  protected int round;
  protected Choice choice;

  /**
   * Sets up default variables that the bot can use throughout the game for strategies.
   *
   * @param choice the user's choice to go odd or even that game
   */
  public AIBot(Choice choice) {
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
   * Increments evenPlayed, or oddPlayed depending on the finger the user played
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
