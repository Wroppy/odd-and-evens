package nz.ac.auckland.se281.AIBots;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class BotFactory {
  /**
   * Given the difficulty of the desired by, returns the respective difficulty.
   * Passes choice into the AIBot.
   * @param difficulty
   * @param choice
   * @return AIBot the bot that the user plays against
   */
  public static AIBot createBot(Difficulty difficulty, Choice choice) {
    switch (difficulty) {
      case EASY:
        return new EasyBot(choice);
      case MEDIUM:
        return new MediumBot(choice);
      case HARD:
        return new HardBot(choice);
      default:
        return new EasyBot(choice);
    }
  }
}
