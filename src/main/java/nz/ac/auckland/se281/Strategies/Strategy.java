package nz.ac.auckland.se281.Strategies;

import nz.ac.auckland.se281.Main.Choice;

public interface Strategy {
  int getFingerChoice(Choice userChoice, int oddPlayed, int evenPlayed);
}
