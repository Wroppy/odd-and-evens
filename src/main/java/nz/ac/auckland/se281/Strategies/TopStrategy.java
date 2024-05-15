package nz.ac.auckland.se281.Strategies;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Utils;

public class TopStrategy implements Strategy {

  @Override
  public int getFingerChoice(Choice userChoice, int oddPlayed, int evenPlayed) {
    // Randomly chooses a number between 0 and 5 if odd and even played are equal
    if (oddPlayed == evenPlayed) {
      return Utils.getRandomNumberRange(0, 5);
    }

    // Checks what the play has played the most
    if (evenPlayed > oddPlayed) {
      if (userChoice == Choice.EVEN) {
        return Utils.getRandomOddNumber();
      } else {
        return Utils.getRandomEvenNumber();
      }
    } else {
      if (userChoice == Choice.EVEN) {
        return Utils.getRandomEvenNumber();
      } else {
        return Utils.getRandomOddNumber();
      }
    }
  }
}
