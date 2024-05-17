package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;
import nz.ac.auckland.se281.bots.AiPlayer;
import nz.ac.auckland.se281.bots.BotFactory;
import nz.ac.auckland.se281.bots.HardDifficultyBot;

/** This class represents the Game is the main entry point. */
public class Game {
  private boolean gameStarted;
  private int round;
  private UserPlayer player;
  private AiPlayer bot;
  private Choice choice;
  private int playerRoundsWon;
  private int botsRoundsWon;

  public Game() {
    this.gameStarted = false;
  }

  /**
   * Given the difficulty, odd or even, and the players name, resets and starts a new game.
   *
   * @param difficulty Enum that represents the difficulty levels (EASY, MEDIUM, HARD).
   * @param choice Enum that represents the player choice (Odd or Even).
   * @param options String array containing the player name.
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    this.round = 1;
    this.gameStarted = true;
    this.playerRoundsWon = 0;
    this.botsRoundsWon = 0;

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
    // Checks if the user has already played
    if (!this.gameStarted) { // Game has not started
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    MessageCli.START_ROUND.printMessage(String.valueOf(this.round));

    // Gets the user players finger and prints the hand
    int finger = this.player.getFinger();
    this.printHand(this.player, finger);

    // Gets the specified bot finger
    int botFinger = this.bot.getFinger();
    this.printHand(this.bot, botFinger);

    boolean humanWin = this.didHumanWinRound(finger, botFinger);
    // Prints out who won the round
    GamePlayer winner = humanWin ? this.player : this.bot;
    int sum = finger + botFinger;
    String sumDescription = Utils.isEven(sum) ? "EVEN" : "ODD";
    MessageCli.PRINT_OUTCOME_ROUND.printMessage(
        String.valueOf(sum), sumDescription, winner.toString());

    // Saves the winner in the game stats
    this.saveRoundWinner(humanWin);

    this.incrementRound();
    this.bot.rememberFingerPlayed(finger);

    // If the bot is hard, then pass in who won
    if (this.bot instanceof HardDifficultyBot) {
      ((HardDifficultyBot) this.bot).setBotWin(humanWin);
    }
  }

  /**
   * Returns true or false on whether the human player won the round.
   *
   * @param playerFinger the finger that the human player put out
   * @param botFinger the finger that the bot put out
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
   * Increments 1 to the amount that the player wins if the player won that round.
   *
   * @param humanWinRound whether the player won that round
   */
  public void saveRoundWinner(boolean humanWinRound) {
    if (humanWinRound) {
      this.playerRoundsWon++;
    } else {
      this.botsRoundsWon++;
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

  /**
   * Is called when the user invokes the end-game command. Will show the stats then show the winner
   * of the game, and a tie if it is a tie.
   */
  public void endGame() {
    // Prints the winner of the match
    if (!gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
  
    this.showStats();


    this.printWinner();
    
    // Resets the stats
    this.playerRoundsWon = 0;
    this.round = 1;
    this.botsRoundsWon = 0;
    this.gameStarted = false;
  }

  /**
   * Given the amount of rounds won and lost by both players, prints out who won, or whether the
   * game ended in a tie.
   */
  public void printWinner() {
    // Handles tied games
    if (this.botsRoundsWon == this.playerRoundsWon) {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
      return;
    }

    // Handles printing out the actual winner
    String winner = (playerRoundsWon > botsRoundsWon) ? player.toString() : bot.toString();

    MessageCli.PRINT_END_GAME.printMessage(winner);
  }

  /**
   * Shows the amount of round wins from the user player and the bot in the current game. Will print
   * an error if a game has not started yet.
   */
  public void showStats() {
    // Displays error message if show stats command is done when a game hasn't started
    if (!this.gameStarted) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    String botRoundWins = String.valueOf(this.botsRoundsWon);
    String playerRoundsWon = String.valueOf(this.playerRoundsWon);

    // Prints the stats
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        this.player.toString(), playerRoundsWon, botRoundWins);
    MessageCli.PRINT_PLAYER_WINS.printMessage(this.bot.toString(), botRoundWins, playerRoundsWon);
  }

  public void incrementWinner() {}
}
