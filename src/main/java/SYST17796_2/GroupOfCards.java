package SYST17796_2;

import SYST17796_2.PlayingCard;
import SYST17796_2.Rank;
import SYST17796_2.Suit;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents a group of playing cards, typically a deck. This class is used to
 * manage the deck in a card game, including shuffling and distributing cards.
 * 
 * @author imgur
 */
public class GroupOfCards {

    private ArrayList<PlayingCard> cards; // The list of cards in the group
    private int size; // The size of the group

    /**
     * Constructor to create a group of cards with a specific size.
     * 
     * @param size the number of cards in the group.
     */
    public GroupOfCards(int size) {
        this.size = size;
        cards = new ArrayList<>(size);
        initializeDeck(); // Initialize the deck with cards
        shuffle(); // Shuffle the deck after initialization
    }

    /**
     * Initializes the deck by adding all possible cards based on the suits and
     * ranks.
     */
    private void initializeDeck() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new PlayingCard(suit, rank));
            }
        }
    }

    /**
     * Returns the list of cards in the group.
     * 
     * @return the list of cards.
     */
    public ArrayList<PlayingCard> getCards() {
        return cards;
    }

    /**
     * Shuffles the group of cards randomly.
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }
}
