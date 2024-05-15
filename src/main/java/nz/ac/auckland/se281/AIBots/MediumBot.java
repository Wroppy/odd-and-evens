package nz.ac.auckland.se281.AIBots;

import nz.ac.auckland.se281.Main.Choice;

public class MediumBot extends AIBot {
  public MediumBot(Choice choice) {
    super(choice);
  }

  @Override
  public int getFinger() {
    return 1;
  }
}
