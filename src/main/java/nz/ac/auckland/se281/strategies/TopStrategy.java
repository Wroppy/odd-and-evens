package nz.ac.auckland.se281.strategies;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Utils;

/**
 * The top strategy chooses a random number if the number of odd and even played are equal. It there
 * is an imbalance, the bot assumes the player will pick the heavier weighted side, and will pick to
 * counter it
 */
public class TopStrategy implements Strategy {

  @Override
  public int getFingerChoice(Choice userChoice, int oddPlayed, int evenPlayed) {
    // Randomly chooses a number between 0 and 5 if odd and even played are equal
    if (oddPlayed == evenPlayed) {
      return Utils.getRandomNumberRange(0, 5);
    }

    // Checks what the play has played the most
    if (evenPlayed > oddPlayed) {
      switch (userChoice) {
        case EVEN: // The user needs EVEN to win, so the bot chooses odd
          return Utils.getRandomOddNumber();
        default:
          return Utils.getRandomEvenNumber();
      }
    } else { // Odd played more than even
      switch (userChoice) {
        case EVEN: // Needs an even number to win
          return Utils.getRandomEvenNumber();
        default:
          return Utils.getRandomOddNumber();
      }
    }
  }
}
