package nz.ac.auckland.se281.Strategies;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Utils;

public class RandomStrategy implements Strategy {
  @Override
  public int getFingerChoice(Choice userChoice, int oddPlayed, int evenPlayed) {
    return Utils.getRandomNumberRange(0, 5);
  }
}
