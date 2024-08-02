package SYST17796_2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The class representing the War card game. This class extends the Game class
 * and provides specific implementations for playing the War game.
 * 
 * @author imgur
 */
public class WarGame extends Game {

    private GroupOfCards deck; // The deck of cards used in the game
    private static final int MAX_ROUNDS = 100; // Maximum number of rounds before the game ends in a tie
    private ArrayList<Player> players; // The list of players in the game

    /**
     * Constructor to initialize the War game with a name and a list of players.
     * 
     * @param name the name of the game.
     * @param players the players participating in the game.
     */
    public WarGame(String name, ArrayList<Player> players) {
        super(name);
        this.players = players;
        deck = new GroupOfCards(52); // Initialize a standard deck of 52 cards
    }

    /**
     * The method that defines how the War game is played. It involves dealing
     * cards to two players and comparing the cards in each round.
     */
    @Override
    public void play() {
        if (players.size() != 2) {
            throw new IllegalArgumentException("War requires exactly two players.");
        }

        WarPlayer player1 = (WarPlayer) players.get(0);
        WarPlayer player2 = (WarPlayer) players.get(1);

        // Distribute cards to players
        distributeCards(player1, player2);

        int round = 0;
        while (!player1.getHand().isEmpty() && !player2.getHand().isEmpty() && round < MAX_ROUNDS) {
            round++;
            System.out.println("\nRound " + round + ":");

            ArrayList<PlayingCard> warPile = new ArrayList<>();

            // Each player plays a card
            PlayingCard card1 = player1.playCard();
            PlayingCard card2 = player2.playCard();

            warPile.add(card1);
            warPile.add(card2);

            System.out.println(player1.getName() + " plays: " + card1);
            System.out.println(player2.getName() + " plays: " + card2);

            // Handle "War" scenario when the cards are equal in rank
            while (card1.getRank().equals(card2.getRank())) {
                System.out.println("War!");

                // Check if players have enough cards for war
                if (player1.getHand().size() < 4) {
                    player2.getHand().addAll(warPile);
                    player2.getHand().addAll(player1.getHand());
                    player1.getHand().clear();
                    System.out.println(player1.getName() + " does not have enough cards for war.");
                    return;
                } else if (player2.getHand().size() < 4) {
                    player1.getHand().addAll(warPile);
                    player1.getHand().addAll(player2.getHand());
                    player2.getHand().clear();
                    System.out.println(player2.getName() + " does not have enough cards for war.");
                    return;
                }

                // Each player sets aside 3 cards as a side
                ArrayList<PlayingCard> player1WarCards = player1.playCards(3);
                ArrayList<PlayingCard> player2WarCards = player2.playCards(3);

                warPile.addAll(player1WarCards);
                warPile.addAll(player2WarCards);

                System.out.println(player1.getName() + " sets aside 3 cards as a side.");
                System.out.println(player2.getName() + " sets aside 3 cards as a side.");

                // Flip over the fourth card
                card1 = player1.playCard();
                card2 = player2.playCard();

                warPile.add(card1);
                warPile.add(card2);

                System.out.println(player1.getName() + " flips over: " + card1);
                System.out.println(player2.getName() + " flips over: " + card2);
            }

            // Determine the winner of the round
            if (card1.getRank().ordinal() > card2.getRank().ordinal()) {
                // Player 1 wins the round
                player1.getHand().addAll(warPile);
                System.out.println(player1.getName() + " wins this round with a total of " + player1.getHand().size() + " cards.");
                System.out.println(player2.getName() + " loses this round with a total of " + player2.getHand().size() + " cards.");
            } else {
                // Player 2 wins the round
                player2.getHand().addAll(warPile);
                System.out.println(player1.getName() + " loses this round with a total of " + player1.getHand().size() + " cards.");
                System.out.println(player2.getName() + " wins this round with a total of " + player2.getHand().size() + " cards.");
            }
        }

        // Declare the winner after the game ends
        declareWinner();
    }

    /**
     * Distributes the deck of cards evenly between the two players.
     * 
     * @param player1 the first player.
     * @param player2 the second player.
     */
    private void distributeCards(WarPlayer player1, WarPlayer player2) {
        ArrayList<PlayingCard> cards = deck.getCards();
        Collections.shuffle(cards); // Shuffle the deck before distributing
        for (int i = 0; i < cards.size(); i++) {
            if (i % 2 == 0) {
                player1.addCardToHand(cards.get(i));
            } else {
                player2.addCardToHand(cards.get(i));
            }
        }
    }

    /**
     * Declares the winner based on the number of cards each player has at the
     * end of the game.
     */
    @Override
    public void declareWinner() {
        WarPlayer player1 = (WarPlayer) players.get(0);
        WarPlayer player2 = (WarPlayer) players.get(1);

        if (player1.getHand().size() > player2.getHand().size()) {
            System.out.println("Winner is: " + player1.getName());
        } else if (player2.getHand().size() > player1.getHand().size()) {
            System.out.println("Winner is: " + player2.getName());
        } else {
            System.out.println("It's a tie!");
        }
    }

    /**
     * Gets the players participating in the game.
     * 
     * @return the list of players.
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }
}
