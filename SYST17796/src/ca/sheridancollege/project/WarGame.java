/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author deepr
 */
import java.util.ArrayList;
import java.util.List;

public class WarGame {
    private final List<WarPlayer> players = new ArrayList<>();
    private final WarDeck deck = new WarDeck();

    public void addPlayer(WarPlayer player) {
        players.add(player);
    }

    public void play() {
        distributeCards();

        while (atLeastOnePlayerHasCards()) {
            WarCard card1 = players.get(0).playCard();
            WarCard card2 = players.get(1).playCard();

            System.out.println(players.get(0).getName() + " plays: " + card1);
            System.out.println(players.get(1).getName() + " plays: " + card2);

            compareCards(card1, card2);
            
            if (isGameFinished()) {
                break;
            }
        }

        declareWinner();
    }

    private void distributeCards() {
        for (WarPlayer player : players) {
            for (int i = 0; i < 26; i++) {
                player.addToHand(deck.drawCard());
            }
        }
    }

    private void compareCards(WarCard card1, WarCard card2) {
        int result = Integer.compare(card1.getRank(), card2.getRank());
        System.out.println("Rank of card 1: " + card1.getRank());
        System.out.println("Rank of card 2: " + card2.getRank());
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
        WarPlayer winner = players.stream().filter(WarPlayer::hasCards).findFirst().orElse(null);
        System.out.println("The winner is: " + (winner != null ? winner.getName() : "None"));
    }

    private boolean isGameFinished() {
        return players.stream().anyMatch(player -> !player.hasCards());
    }

    public static void main(String[] args) {
        WarGame warGame = new WarGame();
        warGame.addPlayer(new WarPlayer("Player 1"));
        warGame.addPlayer(new WarPlayer("Player 2"));
        warGame.play();
    }
}
