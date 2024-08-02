package SYST17796_2;

import SYST17796_2.Player;
import java.util.ArrayList;

/**
 * The class that models a generic game. This class should be extended to create
 * specific games by implementing the abstract methods.
 * 
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public abstract class Game {

    private final String name; // The name of the game
    private ArrayList<Player> players; // The players participating in the game

    /**
     * Constructor to initialize the game with a specific name.
     * 
     * @param name the name of the game.
     */
    public Game(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    /**
     * Gets the name of the game.
     * 
     * @return the name of the game.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the players of the game.
     * 
     * @return a list of players.
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * Sets the players for the game.
     * 
     * @param players the list of players to be set.
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * The method to start the game. Should be implemented by subclasses to
     * define how the game is played.
     */
    public abstract void play();

    /**
     * The method to declare the winner once the game is over. Should be
     * implemented by subclasses to define how the winner is determined.
     */
    public abstract void declareWinner();
}
