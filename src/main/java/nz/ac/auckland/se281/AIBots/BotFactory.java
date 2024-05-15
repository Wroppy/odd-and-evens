package nz.ac.auckland.se281.AIBots;

import nz.ac.auckland.se281.Main.Difficulty;

public class BotFactory {
  public static AIBot createBot(Difficulty difficulty) {
    switch (difficulty) {
      case EASY:
        return new EasyBot();
      case MEDIUM: 
        return new MediumBot();
      case HARD:
        return new HardBot();
      default: 
        return new EasyBot();
    }
  }
}
