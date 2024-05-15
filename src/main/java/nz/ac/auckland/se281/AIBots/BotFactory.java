package nz.ac.auckland.se281.AiBots;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** Returns the desired bot based on difficulty. */
public class BotFactory {

  /**
   * Given the difficulty of the desired by, returns the respective difficulty. Passes choice into
   * the AIBot.
   *
   * @param difficulty the chosen difficulty of the game
   * @param choice the chosen side the player chose
   * @return AIBot the bot that the user plays against
   */
  public static AiPlayer createBot(Difficulty difficulty, Choice choice) {
    switch (difficulty) {
      case EASY: // Returns the easy bot
        return new EasyDifficultyBot(choice);
      case MEDIUM: // Returns the medium bot
        return new MediumDifficultyBot(choice);
      case HARD: // Returns the hard bot
        return new HardDifficultyBot(choice);
      default:
        return new EasyDifficultyBot(choice);
    }
  }
}
