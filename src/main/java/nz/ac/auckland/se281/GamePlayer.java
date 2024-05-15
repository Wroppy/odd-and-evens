package nz.ac.auckland.se281;

public abstract class GamePlayer {
  protected String name;

  public GamePlayer(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return this.name;
  } 
}
