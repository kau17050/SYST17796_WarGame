package SYST17796_2;

/**
 * The base class for a card in any card game. This class is abstract and
 * should be extended by specific card types in different games.
 * 
 * @author dancye
 */
public abstract class Card {

    /**
     * This method should be implemented by subclasses to provide a string
     * representation of the card, suitable for different games. Here, we are using it for War Game.
     * 
     * @return a string representation of the card.
     */
    @Override
    public abstract String toString();
}
