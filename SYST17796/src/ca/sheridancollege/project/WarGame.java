/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public class WarGame extends Game {
    private GroupOfCards deck;
    private static final int MAX_ROUNDS = 100;
    private ArrayList<Player> players;

    public WarGame(String name, ArrayList<Player> players) {
        super(name);
        this.players = players;
        deck = new GroupOfCards(52);
    }

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

            PlayingCard card1 = player1.playCard();
            PlayingCard card2 = player2.playCard();

            warPile.add(card1);
            warPile.add(card2);

            System.out.println(player1.getName() + " plays: " + card1);
            System.out.println(player2.getName() + " plays: " + card2);

            while (card1.getRank().equals(card2.getRank())) {
                System.out.println("War!");

                // Ensure both players have enough cards for a war
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

                // Set aside 3 cards as a side for each player
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

            // Determine the outcome of the round based on the played cards
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
        declareWinner();
    }

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

    public ArrayList<Player> getPlayers() {
        return players;
    }
}