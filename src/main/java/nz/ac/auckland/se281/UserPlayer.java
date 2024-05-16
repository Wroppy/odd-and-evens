package nz.ac.auckland.se281;

/** Handles the logic the user playing the game. */
public class UserPlayer extends GamePlayer {
  public UserPlayer(String name) {
    super(name);
  }

  /**
   * When called, asks the user for a number that is between 0 and 5 (inclusive) Ensures that the
   * input is valid and keeps asking until the condition is satisfied.
   *
   * @return the user's inputted number from 0 and 5
   */
  @Override
  public int getFinger() {
    MessageCli.ASK_INPUT.printMessage();
    String finger = Utils.scanner.nextLine();
    while (!Utils.isInteger(finger)
        || !(Integer.parseInt(finger) >= 0 && Integer.parseInt(finger) <= 5)) {

      // Asks prompt again if the message is invalid
      MessageCli.INVALID_INPUT.printMessage();
      MessageCli.ASK_INPUT.printMessage();
      finger = Utils.scanner.nextLine();
    }

    return Integer.parseInt(finger);
  }
}
