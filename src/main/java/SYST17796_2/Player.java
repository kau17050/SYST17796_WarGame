package SYST17796_2;

/**
 * A class that represents a player in a game. This class is abstract and
 * should be extended to create specific player types for different games.
 * 
 * @author imgur
 */
public abstract class Player {

    private String name; // The unique name for the player

    /**
     * Constructor to initialize the player with a unique name.
     * 
     * @param name the unique name of the player.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * Gets the player's name.
     * 
     * @return the player's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the player's name.
     * 
     * @param name the new name of the player.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * The method to define the player's action in the game. This method should
     * be implemented by subclasses to define the specific behavior.
     */
    public abstract void play();
}
