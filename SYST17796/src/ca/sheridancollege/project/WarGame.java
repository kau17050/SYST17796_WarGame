/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author deepr
 * @Arsh
 */
import java.util.ArrayList;
import java.util.List;



public class WarGame {
    private final List<WarPlayer> players = new ArrayList<>();
    private final WarDeck deck = new WarDeck();
    private static final int MAX_ROUNDS = 100; // Define a maximum number of rounds to avoid infinite loops

    public void addPlayer(WarPlayer player) {
        players.add(player);
    }

    public void play() {
        distributeCards();

        int round = 0;
        while (atLeastOnePlayerHasCards() && round < MAX_ROUNDS) {
            WarCard card1 = players.get(0).playCard();
            WarCard card2 = players.get(1).playCard();

            System.out.println(players.get(0).getName() + " plays: " + card1);
            System.out.println(players.get(1).getName() + " plays: " + card2);

            compareCards(card1, card2);
            
            if (isGameFinished()) {
                break;
            }
            
            round++;
        }

        declareWinner();
    }

    private void distributeCards() {
        deck.shuffle();
        for (int i = 0; i < 26; i++) {
            players.get(0).addToHand(deck.drawCard());
            players.get(1).addToHand(deck.drawCard());
        }
    }

    private void compareCards(WarCard card1, WarCard card2) {
        int result = Integer.compare(card1.getGameRank(), card2.getGameRank());
        System.out.println("Rank of card 1: " + card1.getGameRank());
        System.out.println("Rank of card 2: " + card2.getGameRank());
        if (result > 0) {
            players.get(0).addToHand(card1);
            players.get(0).addToHand(card2);
            System.out.println(players.get(0).getName() + " wins the round!");
        } else if (result < 0) {
            players.get(1).addToHand(card1);
            players.get(1).addToHand(card2);
            System.out.println(players.get(1).getName() + " wins the round!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    private boolean atLeastOnePlayerHasCards() {
        return players.stream().anyMatch(WarPlayer::hasCards);
    }

    private void declareWinner() {
        WarPlayer gamer1 = players.get(0);
        WarPlayer gamer2 = players.get(1);
        
        if (!gamer1.hasCards()) {
            System.out.println("The winner is: " + gamer2.getName());
        } else if (!gamer2.hasCards()) {
            System.out.println("The winner is: " + gamer1.getName());
        } else {
            int player1Card = gamer1.getHandSize();
            int player2Card = gamer2.getHandSize();
            if (player1Card > player2Card) {
                System.out.println("The winner is: " + gamer1.getName());
            } else if (player2Card > player1Card) {
                System.out.println("The winner is: " + gamer2.getName());
            } else {
                System.out.println("It's a tie!");
            }
        }
    }

    private boolean isGameFinished() {
        return players.stream().anyMatch(player -> !player.hasCards());
    }

    public static void main(String[] args) {
        WarGame warGame = new WarGame();
        warGame.addPlayer(new WarPlayer("Player 1:"));
        warGame.addPlayer(new WarPlayer("Player 2:"));
        warGame.play();
    }
}