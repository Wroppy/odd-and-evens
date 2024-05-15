package nz.ac.auckland.se281;

/**
 * A generic class for a player that plays and interacts with the game
 */
public abstract class GamePlayer {
  protected String name;

  public GamePlayer(String name) {
    this.name = name;
  }

  public abstract int getFinger();

  @Override
  public String toString() {
    return this.name;
  }
}
