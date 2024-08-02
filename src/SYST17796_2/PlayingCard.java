package SYST17796_2;

/**
 * Represents a playing card with a suit and rank. This class extends the
 * abstract Card class and provides implementation specific to a standard
 * playing card.
 * 
 * @author imgur
 */
public class PlayingCard extends Card {

    private final Suit suit; // The suit of the card (Hearts, Diamonds, Clubs, Spades)
    private final Rank rank; // The rank of the card (Two, Three, ..., Ace)

    /**
     * Constructor to create a playing card with a specific suit and rank.
     * 
     * @param suit the suit of the card.
     * @param rank the rank of the card.
     */
    public PlayingCard(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Gets the suit of the card.
     * 
     * @return the suit of the card.
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * Gets the rank of the card.
     * 
     * @return the rank of the card.
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Provides a string representation of the card in the format "Rank of Suit".
     * 
     * @return a string representation of the card.
     */
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
