package nz.ac.auckland.se281.AIBots;

import nz.ac.auckland.se281.Utils;

public class EasyBot extends AIBot {
  @Override
  public int getFinger() {
    return Utils.getRandomNumberRange(0, 5);
  }
}
