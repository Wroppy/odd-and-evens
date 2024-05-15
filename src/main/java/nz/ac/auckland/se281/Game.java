package nz.ac.auckland.se281;

import nz.ac.auckland.se281.bots.AiPlayer;
import nz.ac.auckland.se281.bots.BotFactory;
import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int round = 1;
  private UserPlayer player;
  private AiPlayer bot;
  private Choice choice;

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
    this.choice = choice;
    this.bot = BotFactory.createBot(difficulty, this.choice);
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

    // Prints out who won the round
    GamePlayer winner = this.didHumanWinRound(finger, botFinger) ? this.player : this.bot;
    int sum = finger + botFinger;
    String sumDescription = Utils.isEven(sum) ? "EVEN" : "ODD";
    MessageCli.PRINT_OUTCOME_ROUND.printMessage(
        String.valueOf(sum), sumDescription, winner.toString());

    this.incrementRound();
    this.bot.rememberFingerPlayed(finger);
  }

  /**
   * Returns true or false on whether the human player won the round.
   *
   * @return whether the human won the round
   */
  public boolean didHumanWinRound(int playerFinger, int botFinger) {
    int sum = playerFinger + botFinger;
    if (choice == Choice.EVEN) { // User chose even
      return Utils.isEven(sum);
    } else { // User chose odd
      return Utils.isOdd(sum);
    }
  }

  /**
   * Prints out the player's name and hand.
   *
   * @param gamePlayer the player that wants to be printed out
   * @param finger the finger that the player put out in the previous round
   */
  public void printHand(GamePlayer gamePlayer, int finger) {
    MessageCli.PRINT_INFO_HAND.printMessage(gamePlayer.toString(), String.valueOf(finger));
  }

  /** When called, adds 1 to the round class variable. */
  private void incrementRound() {
    this.round++;

    this.bot.incrementRound();
  }

  public void endGame() {}

  public void showStats() {}
}
