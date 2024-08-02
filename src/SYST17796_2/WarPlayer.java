package SYST17796_2;

import java.util.ArrayList;

/**
 * Represents a player in the War card game. This class extends the Player class
 * and adds functionality specific to managing the player's hand of cards.
 * 
 * @author imgur
 */
public class WarPlayer extends Player {

    private ArrayList<PlayingCard> hand; // The player's hand of cards

    /**
     * Constructor to initialize a War player with a specific name.
     * 
     * @param name the name of the player.
     */
    public WarPlayer(String name) {
        super(name);
        this.hand = new ArrayList<>();
    }

    /**
     * Gets the player's hand of cards.
     * 
     * @return the hand of cards.
     */
    public ArrayList<PlayingCard> getHand() {
        return hand;
    }

    /**
     * Adds a card to the player's hand.
     * 
     * @param card the card to add.
     */
    public void addCardToHand(PlayingCard card) {
        hand.add(card);
    }

    /**
     * Plays (removes) the top card from the player's hand.
     * 
     * @return the played card, or null if the hand is empty.
     */
    public PlayingCard playCard() {
        if (!hand.isEmpty()) {
            return hand.remove(0);
        }
        return null;
    }

    /**
     * Plays (removes) a specified number of cards from the player's hand.
     * 
     * @param number the number of cards to play.
     * @return the list of played cards.
     */
    public ArrayList<PlayingCard> playCards(int number) {
        ArrayList<PlayingCard> cards = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            if (!hand.isEmpty()) {
                cards.add(hand.remove(0));
            }
        }
        return cards;
    }

    /**
     * This method is not implemented here as the game logic is handled in the
     * WarGame class.
     */
    @Override
    public void play() {
        // Implementation depends on the game flow, handled in WarGame class
    }
}
