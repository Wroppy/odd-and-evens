package nz.ac.auckland.se281;

import nz.ac.auckland.se281.AIBots.AIBot;
import nz.ac.auckland.se281.AIBots.BotFactory;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int round = 1;
  private UserPlayer player;
  private AIBot bot;

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
    this.player = new UserPlayer(playerName);
    MessageCli.WELCOME_PLAYER.printMessage(this.player.toString());
    this.round = 1;

    this.bot = BotFactory.createBot(difficulty);
  }

  /**
   * Implements the play logic of the game. Prints out the current round and asks the user for their
   * numeric input.
   */
  public void play() {
    MessageCli.START_ROUND.printMessage(String.valueOf(this.round));

    // Gets the user players finger and prints the hand
    int finger = this.player.getFinger();
    this.printHand(this.player, finger);

    // Gets the specified bot finger
    int botFinger = this.bot.getFinger();
    this.printHand(this.bot, botFinger);

    this.incrementRound();
  }

  public void printHand(GamePlayer gamePlayer, int finger) {
    MessageCli.PRINT_INFO_HAND.printMessage(gamePlayer.toString(), String.valueOf(finger));
  }

  /** When called, adds 1 to the round class variable. */
  private void incrementRound() {
    this.round++;
  }

  public void endGame() {}

  public void showStats() {}
}
